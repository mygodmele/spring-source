package com.zk.targetsource;

import com.zk.service.ServiceInterface;
import com.zk.service.TestService;
import org.springframework.stereotype.Component;

@Component
public class TestTargetBean {

	public TestTargetBean(){
		System.out.println("user default");
	}


	public TestTargetBean(ServiceInterface serviceInterface){
		System.out.println("use serviceInterface");
	}

	public TestTargetBean(TestService testService){
		System.out.println("use testService");
	}
}
