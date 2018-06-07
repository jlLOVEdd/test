package com.wdd.test.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class Aspject {
    public Aspject() {
        // TODO Auto-generated constructor stub
    }

    @Pointcut("execution(* *add*(..))")
    public void addmethod() {
        System.out.println("I am pointcut method");
    }

    @Before("addmethod()")
    public void setLOg() {
        System.out.println("currentTime:" + System.currentTimeMillis() + "----before");
    }

    @After("addmethod()")
    public void setAfterLOg() {
        System.out.println("currentTime:" + System.currentTimeMillis() + "----After");
    }

}
