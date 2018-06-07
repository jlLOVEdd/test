package com.wdd.test.comm.uptofather;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public class Father {
    public static String name ="father";

    public  Father(){
        System.out.println("Father Constructor");
    }

    static {
        System.out.println(" father static");
    }

    public static void Ftest(){
        System.out.println("static method");
    }
    void single(){
        System.out.println("father is single");
        System.out.println(this);
        eat();
    }
    void eat(){
        System.out.println("i am father");
    }
}
