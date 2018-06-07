package com.wdd.test.comm.transactionManager;

import com.wdd.test.bean.Role;
import com.wdd.test.bean.Sysuserinfo;
import com.wdd.test.dao.RoleMapper;
import com.wdd.test.dao.SysuserinfoMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class TestForTransactional {
    @Resource
    private SysuserinfoMapper sysuserinfoMapper;

    @Resource
    private RoleMapper roleMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test2() {
        Role role = new Role();
        role.setId(11);
        role.setRoleCode("测试1111");
        roleMapper.insert(role);
    }

    @Transactional
    public void test1() {
        Sysuserinfo sysuserinfo = new Sysuserinfo();
        sysuserinfoMapper.insert(sysuserinfo);
    }
}
