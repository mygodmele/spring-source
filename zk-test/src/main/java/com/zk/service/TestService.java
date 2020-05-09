package com.zk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class TestService implements ServiceInterface{

	public TestService(){
		System.out.println("init TestService");
	}

	@Autowired
	IndexService indexService;

	@Override
	public Integer say() {
		System.out.println("TestService");
		return 1;
	}

	// 循环依赖 由于先注入earlyBean，即还未填充属性，导致这里为空
	/*@PostConstruct
	public void testPost(){
		System.out.println("indexService中的testService这里应该为空：" + indexService.testService);
		System.out.println("num应该也为空： " + indexService.num);
	}*/

	@PreDestroy
	public void closee(){
		System.out.println("====================");
		System.out.println(indexService.num);
	}
}
