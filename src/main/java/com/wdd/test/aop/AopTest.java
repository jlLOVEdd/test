package com.wdd.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class AopTest {

	public static void main(String[] args) {
		ApplicationContext app1 = new ClassPathXmlApplicationContext("applicationContext.xml");
		Buness bun  =(Buness)app1.getBean("buness");
		bun.add();
		bun.add1();
		bun.addTo();
		bun.textadd();
	}

}
