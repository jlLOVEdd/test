package com.wdd.test.dao;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisUtilsDao  {
	@Resource(name="redisTemplate")
	private RedisTemplate redisTemplate;
	
	public Object get(){
		return redisTemplate.opsForValue().get("ss");
	}
}
