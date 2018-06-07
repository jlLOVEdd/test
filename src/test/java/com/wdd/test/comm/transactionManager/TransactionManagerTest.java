package com.wdd.test.comm.transactionManager;

import com.wdd.test.bean.Role;
import com.wdd.test.bean.Sysuserinfo;
import com.wdd.test.dao.RoleMapper;
import com.wdd.test.dao.SysuserinfoMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"classpath:/applicationContext.xml", "classpath:/mybatis-spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(value = false)
@Transactional(transactionManager = "transactionManager")
public class TransactionManagerTest {

    @Resource
    private TestForTransactional testForTransactional;

    @Test
    @Transactional
    public void insertRoletest() {
        testForTransactional.test2();
        testForTransactional.test1();
    }
}
