package com.wdd.test.dao;

import com.wdd.test.bean.UserResources;
import com.wdd.test.bean.UserResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserResourcesMapper {
    int countByExample(UserResourcesExample example);

    int deleteByExample(UserResourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserResources record);

    int insertSelective(UserResources record);

    List<UserResources> selectByExample(UserResourcesExample example);

    UserResources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserResources record, @Param("example") UserResourcesExample example);

    int updateByExample(@Param("record") UserResources record, @Param("example") UserResourcesExample example);

    int updateByPrimaryKeySelective(UserResources record);

    int updateByPrimaryKey(UserResources record);
}