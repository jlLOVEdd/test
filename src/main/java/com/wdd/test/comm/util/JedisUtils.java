package com.wdd.test.comm.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 10:37 2018/3/16
 */
@Component
public class JedisUtils {

   @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public JedisUtils() {
    }

    /**
     * delete key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * get value
     */
    public Object  getValue(String key) {
       return  redisTemplate.opsForValue().get(key);
    }

    public  void setvlaue(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

}
