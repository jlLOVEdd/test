package com.wdd.test.comm.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 18:05 2018/5/8
 */
public class KafkaProducerUtils {

    private static ConcurrentHashMap<String, Object> propCache = new ConcurrentHashMap<String, Object>();

    private KafkaProducerUtils() {
        super();
    }


    public static final KafkaProducerUtils getInstance() {
        return KafkaClientUtilsHolder.INSTANCE;
    }

    private static class KafkaClientUtilsHolder {
        private final static KafkaProducerUtils INSTANCE = new KafkaProducerUtils();
    }

    public void sendMsg(Object msg) {
        Properties properties = null;
        if (propCache != null && propCache.containsKey("properties")) {
            properties = (Properties) propCache.get("properties");
        } else {
            properties = getProperties();
            propCache.put("properties", properties);
        }
        Producer<String, Object> producer = new KafkaProducer<String, Object>(properties);
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<String, Object>("test22", msg);
        producer.send(producerRecord, (RecordMetadata recordMetadata, Exception e) -> {
            if (e != null) {
                e.printStackTrace();
            } else {
                System.out.println("this send matadata is :" + recordMetadata);
            }
        });

        producer.close();
    }

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            // 使用ClassLoader加载properties配置文件生成对应的输入流
            InputStream in = KafkaProducerUtils.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return properties;
    }
}
