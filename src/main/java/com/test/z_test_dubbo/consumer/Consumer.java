package com.test.z_test_dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.z_test_dubbo.provider.DemoService;

public class Consumer {

	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 100; i++) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "consumer-spring.xml" });
			context.start();

			DemoService demoService = (DemoService) context.getBean("demoService");

			String hello = demoService.sayHello("hejingyuan");
			System.out.println(hello);

			System.in.read();
		}
		
	}
}
