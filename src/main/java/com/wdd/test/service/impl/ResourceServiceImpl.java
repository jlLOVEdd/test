package com.wdd.test.service.impl;

import com.wdd.test.bean.Menu;
import com.wdd.test.dao.bus.ResourcesBusMapper;
import com.wdd.test.service.ResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Resource
    private ResourcesBusMapper resourcesBusMapper;

    /**
     * 查询所有的菜单
     * @return
     */
    @Override
    public List<Menu> selectAllMenu() {
        return resourcesBusMapper.selectMenuList();
    }
}
