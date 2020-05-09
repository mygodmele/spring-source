package com.zk.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAspectj {

	/*@Pointcut("execution(* com.zk.service.IndexService.*(..))")
	public void pointCut(){}

	@Before("pointCut()")
	public void beforeExecution(){
		System.out.println("before execution");
	}*/
}
