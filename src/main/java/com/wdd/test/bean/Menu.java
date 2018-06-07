package com.wdd.test.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Menu extends  Resources {

    private List<Menu> childrenList;

    public List<Menu> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Menu> childrenList) {
        this.childrenList = childrenList;
    }




}
