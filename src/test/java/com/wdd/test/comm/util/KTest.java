package com.wdd.test.comm.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 15:41 2018/5/9
 */
public class KTest {
    public static void main(String[] args) {
        KafkaProducerUtils kafkaProducerUtils = KafkaProducerUtils.getInstance();
        JsonObject json = new JsonObject();
        JsonObject object = new JsonObject();
        object.addProperty("name", "weidongdong000");
        object.addProperty("age", 111);
        object.addProperty("address", "ssss");
        JsonArray array = new JsonArray();
        array.add("1");
        array.add("2");
        array.add("3");
        array.add(object);
        json.addProperty("titile", "主题信息");
        json.add("json", array);
        json.addProperty("sender", "this is me!!");
        json.add("jsonobject", object);
        System.out.println(json.toString());
        kafkaProducerUtils.sendMsg(json.toString());
    }
}
