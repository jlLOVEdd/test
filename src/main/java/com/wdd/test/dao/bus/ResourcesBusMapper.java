package com.wdd.test.dao.bus;

import com.wdd.test.bean.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourcesBusMapper {
    /**
     * 查询菜单
     * @return
     */
    public List<Menu> selectMenuList();
}
