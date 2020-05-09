package com.zk.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Priority;

@Component
public class IndexService implements ServiceInterface, InitializingBean {

	@Autowired
	TestService testService;

	@Value("${abc}")
	public String num;

	ZkService zkService;

	public IndexService(){
		System.out.println("init indexService ");
	}

	@PostConstruct
	public void print() {
		System.out.println("=====" + num + "-" + testService + "-" + zkService);
	}

	@Autowired
	public void setxxx(ZkService zks){
		zkService = zks;
		System.out.println("1111111111");
	}

	@Autowired
	public String say() {
		System.out.println("22222222222");
		return "brig method";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("实现自InitializingBean");
	}

	@PreDestroy
	public void closeii(){
		System.out.println("====================");
		testService.say();
		System.out.println(zkService.zk);
	}
}
