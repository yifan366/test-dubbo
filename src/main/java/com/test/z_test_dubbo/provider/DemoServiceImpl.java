package com.test.z_test_dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "hello:"+name;
	}

}
