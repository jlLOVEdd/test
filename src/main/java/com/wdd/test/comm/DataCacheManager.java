package com.wdd.test.comm;


import com.wdd.test.bean.Sysuserinfo;
import com.wdd.test.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class DataCacheManager implements InitializingBean {
    @Autowired
    private CacheManager cacheManager;
    private Logger logger = Logger.getLogger(DataCacheManager.class);
    public static final String ROLE = "roleInfo";

    @Resource
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.initRoles();
    }

    public void initRoles() {
        Sysuserinfo sysuserinfo = userService.selectByName("weidongdong");
        logger.info("唯一登陆名" + sysuserinfo.getUsername() + "---" + sysuserinfo.getPassword());
    }

    public void initpasscs() {

        Cache cache = cacheManager.getCache("passwordRetryCache");
        cache.put("1", "我是shab");
        logger.info(cache.get("1"));

    }
}
