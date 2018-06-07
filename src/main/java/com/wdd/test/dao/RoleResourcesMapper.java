package com.wdd.test.dao;

import com.wdd.test.bean.RoleResources;
import com.wdd.test.bean.RoleResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourcesMapper {
    int countByExample(RoleResourcesExample example);

    int deleteByExample(RoleResourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleResources record);

    int insertSelective(RoleResources record);

    List<RoleResources> selectByExample(RoleResourcesExample example);

    RoleResources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleResources record, @Param("example") RoleResourcesExample example);

    int updateByExample(@Param("record") RoleResources record, @Param("example") RoleResourcesExample example);

    int updateByPrimaryKeySelective(RoleResources record);

    int updateByPrimaryKey(RoleResources record);
}