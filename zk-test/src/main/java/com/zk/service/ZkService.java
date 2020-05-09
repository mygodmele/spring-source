package com.zk.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

@Component
public class ZkService {

	@Value("${666}")
	String zk;

	public ZkService(){
		System.out.println("init ZkService");
	}

}
