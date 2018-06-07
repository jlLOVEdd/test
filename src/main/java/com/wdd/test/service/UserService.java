package com.wdd.test.service;

import com.wdd.test.bean.Sysuserinfo;

public interface UserService {

    public Sysuserinfo selectByName(String name);

    void inserUser(Sysuserinfo sysuserinfo);

}
