package com.wdd.test.comm.uptofather;

public class Son  extends  Father{

    public  static String name ="son";

    public  Son(){
        System.out.println("Son Constructor");
    }

    static {
        System.out.println(" Son static");
    }

    public static void test(){
        System.out.println("static method");
    }
    @Override
    void eat( ) {
       System.out.println(" i am son");
    }
    void  playGame(){
        System.out.println("payGame of son");
    }
}
