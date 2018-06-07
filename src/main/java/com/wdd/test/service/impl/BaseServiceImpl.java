package com.wdd.test.service.impl;

import com.wdd.test.dao.BaseMapper;
import com.wdd.test.service.BaseService;

import java.io.Serializable;


public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    abstract BaseMapper<T, ID> getBaseMapper();

    @Override
    public int insert(T entity) {
        return getBaseMapper().insert(entity);
    }

}
