package com.wdd.test.dao;

import com.wdd.test.bean.GroupRole;
import com.wdd.test.bean.GroupRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupRoleMapper {
    int countByExample(GroupRoleExample example);

    int deleteByExample(GroupRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroupRole record);

    int insertSelective(GroupRole record);

    List<GroupRole> selectByExample(GroupRoleExample example);

    GroupRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GroupRole record, @Param("example") GroupRoleExample example);

    int updateByExample(@Param("record") GroupRole record, @Param("example") GroupRoleExample example);

    int updateByPrimaryKeySelective(GroupRole record);

    int updateByPrimaryKey(GroupRole record);
}