package com.wdd.test.service.impl;

import com.wdd.test.bean.Sysuserinfo;
import com.wdd.test.dao.BaseMapper;
import com.wdd.test.dao.SysuserinfoMapper;
import com.wdd.test.dao.bus.SysuserinfoBusMapper;
import com.wdd.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends BaseServiceImpl<Sysuserinfo, Integer> implements UserService {

    @Resource
    private BaseMapper<Sysuserinfo, Integer> baseMapper;

    @Resource
    private SysuserinfoBusMapper sysuserinfoBusMapper;

    @Resource
    private SysuserinfoMapper sysuserinfoMapper;

    @Override
    BaseMapper<Sysuserinfo, Integer> getBaseMapper() {
        return baseMapper;
    }

    @Override
    public Sysuserinfo selectByName(String name) {
        return sysuserinfoMapper.selectByName(name);
    }

    /**
     * 新增用户
     * @param sysuserinfo
     */
    @Override
    public void inserUser(Sysuserinfo sysuserinfo) {
        sysuserinfoMapper.insert(sysuserinfo);
    }
}
