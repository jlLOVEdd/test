package com.wdd.test.dao;

import com.wdd.test.bean.Sysuserinfo;
import com.wdd.test.bean.SysuserinfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysuserinfoMapper  {
    int countByExample(SysuserinfoExample example);

    int deleteByExample(SysuserinfoExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(Sysuserinfo record);

    int insertSelective(Sysuserinfo record);

    List<Sysuserinfo> selectByExample(SysuserinfoExample example);

    Sysuserinfo selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Sysuserinfo record, @Param("example") SysuserinfoExample example);

    int updateByExample(@Param("record") Sysuserinfo record, @Param("example") SysuserinfoExample example);

    int updateByPrimaryKeySelective(Sysuserinfo record);

    int updateByPrimaryKey(Sysuserinfo record);
    Sysuserinfo selectByName(@Param("name") String name);
}