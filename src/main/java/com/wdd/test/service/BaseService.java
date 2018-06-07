package com.wdd.test.service;


import java.io.Serializable;

public interface BaseService <T,ID extends Serializable>{

    /**
     * 增加
     */
    public abstract int insert(T entity);
}
