package com.wdd.test.comm.util;

import java.util.EventObject;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 11:31 2018/5/7
 */
public class Lifecycle extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public Lifecycle(Object source) {
        super(source);
    }

    public static void main(String[] args) {
        String  ss = "select DISTINCT a.id from table1 a where a.id in (slect DISTINCT b.id from table2 b )";
        System.out.println("startIndex-----------"+ss.indexOf("DISTINCT"));
        System.out.println("endIndex-----------"+ss.indexOf("from"));
        //后面的where条件里有这个东西  导致startIndex>endIndex   报错

    }
}
