package com.wdd.test.comm.util;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 11:09 2018/3/16
 */
@ContextConfiguration(locations = {"classpath:/applicationContext.xml", "classpath:/mybatis-spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(value = false)
@Transactional(transactionManager = "transactionManager")
public class Test {

    @Resource
    private JedisUtils jedisUtils;

    private Jedis jedis;

    @Before
    public void setup() {
        //连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证

    }

    /**
     * redis存储字符串
     */
    @org.junit.Test
    public void testString() {
        //-----添加数据----------
        jedis.set("name1", "xinxin");//向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name1"));//执行结果：xinxin

        jedis.append("name", " is my lover"); //拼接
        System.out.println(jedis.get("name"));

        jedis.del("name");  //删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name", "liuling", "age", "23", "qq", "476777XXXsssss");
        jedis.incr("age"); //进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));

    }

    @org.junit.Test
    public void keyString() {
        //jedisUtils.setvlaue("ss","ssss");
        System.out.println("---------"+jedisUtils.getValue("ss"));

    }

}
