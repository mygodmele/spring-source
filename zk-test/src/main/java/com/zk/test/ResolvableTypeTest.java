package com.zk.test;

import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.Map;

public class ResolvableTypeTest {

	public class InnerTest extends HashMap implements Runnable {

		private Integer a;
		private String b;

		public InnerTest(){}

		public String testMethod(String test){
			return test;
		}

		public void run(){
			System.out.println("run");
		}

	}

	public static void main(String[] args) {

		ResolvableType resolvableType = ResolvableType.forClass(InnerTest.class);
		System.out.println(resolvableType.getType());
		System.out.println(resolvableType.getSuperType().getType());
		System.out.println(resolvableType.getRawClass());

	}

}
