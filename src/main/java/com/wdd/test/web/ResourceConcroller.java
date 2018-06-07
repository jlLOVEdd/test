package com.wdd.test.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wdd.test.bean.Menu;
import com.wdd.test.bean.dataType.Groal;
import com.wdd.test.service.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/resources")
public class ResourceConcroller {

    @Resource
    private ResourceService resourceService;

    /**
     * 查询main页的菜单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAllMenu",produces = {"application/json;charset=utf-8"})
    private Groal selectAllMenu() {
        List<Menu> lsit =null;
        Groal groal = new Groal();
        String json =null;
        try {
            lsit = resourceService.selectAllMenu();
            json = JSONArray.toJSONString(lsit);
             System.out.println(json);
            groal.setData(lsit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groal;
    }
}
