package com.wdd.test.dao.bus;

import com.wdd.test.bean.Sysuserinfo;
import com.wdd.test.bean.SysuserinfoVo;
import com.wdd.test.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface SysuserinfoBusMapper extends BaseMapper<SysuserinfoVo,Integer> {
    SysuserinfoVo selectByName(@Param("name") String name);
}
