package com.wdd.test.comm.util;

import com.wdd.test.bean.Sysuserinfo;
import com.wdd.test.dao.SysuserinfoMapper;
import com.wdd.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@ContextConfiguration(locations = {"classpath:/applicationContext.xml", "classpath:/mybatis-spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(value = false)
@Transactional(transactionManager = "transactionManager")
public class UserTest {
    @Autowired
    private UserService userService;

    @Autowired
    private SysuserinfoMapper sysuserinfoMapper;

    @Test
    public void testInsertUser() {
        try {
            Sysuserinfo sysuserinfo = new Sysuserinfo();
            sysuserinfo.setUsername("admin");
            sysuserinfo.setAgentid("1");
            sysuserinfo.setUsertype("0");
            sysuserinfo.setStatus("1");
            sysuserinfo.setCardid("11");
            sysuserinfo.setIsNickname("a");
            sysuserinfo.setMobile("11234422333");
            sysuserinfo.setPwdLastDatetime(new Date());

            sysuserinfo.setSex("1");
            sysuserinfo.setUpdatetime(new Date());
            sysuserinfo.setCreatetime(DateUtils.parseDateTime(DateUtils.formatDate(new Date(), DateUtils.Format.DATETIME.toString()), DateUtils.Format.DATETIME.toString()));
            String pwd = MD5Password.getEncryptedPwd("1");
            sysuserinfo.setPassword(pwd);
            Sysuserinfo s = userService.selectByName("weidongdong");
            System.out.println(s.getUsername());
            userService.inserUser(sysuserinfo);
            System.out.println("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
