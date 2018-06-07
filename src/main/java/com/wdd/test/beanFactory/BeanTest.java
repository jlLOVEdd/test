package com.wdd.test.beanFactory;

import java.util.ArrayList;
import java.util.List;

public class BeanTest {

	public BeanTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeansFactoryInferter bf = new BeansFactorySon();
		bf.getSon();
		List list= new ArrayList();
		System.out.println(list.size());
	}

}
