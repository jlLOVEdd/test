package com.wdd.test.comm.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 16:28 2018/5/8
 */
@Component("KafkaListener")
public class KafkaListener implements ApplicationListener<ContextRefreshedEvent> {

    public KafkaListener() {
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            listenerThread listener = new listenerThread();
            listener.setDaemon(true);
            listener.setName("ssssss");
            listener.start();
        }

    }


    @EnableRetry
    class listenerThread extends Thread {
        listenerThread() {
        }

        @Override
        public void run() {
            //DepositLog.info(">>>>>>>>>>Kafka  listener  starting ........");
            Properties props = new Properties();
            props.put("bootstrap.servers", "127.0.0.1:9092");

            /**
             * latest 从消费到的最新的offset位置开始消费 earliest 从最初的offset位置开始消费，如果是新的topic话
             * none 从当前produce生产的最新的offset开始消费，默认
             */
           // props.put("auto.offset.reset","none");

            props.put("group.id", "test");
            props.put("enable.auto.commit", "true");
            props.put("auto.commit.interval.ms", "60000");
            props.put("session.timeout.ms", "30000");
            props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
           /* props.put("enable.auto.commit", WebSrvUtil.srv("kafka.enable.auto.commit"));
            // 自动提交offset到zookeeper的时间间隔
            props.put("auto.commit.interval.ms", WebSrvUtil.srv("kafka.auto.commit.interval.ms"));
            props.put("session.timeout.ms", WebSrvUtil.srv("kafka.session.timeout.ms"));
            props.put("key.deserializer", WebSrvUtil.srv("kafka.key.deserializer"));
            props.put("value.deserializer", WebSrvUtil.srv("kafka.value.deserializer"));
            props.put("group.id", WebSrvUtil.srv("kafka.group.id"));*/

            KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
            String a_topic = "test22";
            consumer.subscribe(Arrays.asList(a_topic));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(">>>>>> fetched from partition " + record.partition() + ", offset: " + record.offset());
                    System.out.println(">>>>>> message: " + record.value());
                    // 获取offset 相等

                    try {
                        JsonObject obj = new JsonParser().parse(record.value()).getAsJsonObject();
                        System.out.println(">>>>>>>>>>>title:"+obj.get("titile").getAsString());
                        System.out.println(">>>>>>>>>>>>>>>>list:"+obj.get("json").getAsJsonArray().get(1));
                        System.out.println(">>>>>>>>>>>>>>>>list:"+obj.get("jsonobject").getAsJsonObject().toString());
                        SpringContextHolder.getBean(KafkaRetry.class).retrytest();
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                        System.out.println(">>>>>>>>>>>>>>>> 数据poll异常");
                    }


                }
            }
        }
    }
}


