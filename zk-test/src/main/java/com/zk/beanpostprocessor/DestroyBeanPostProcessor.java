package com.zk.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class DestroyBeanPostProcessor implements DestructionAwareBeanPostProcessor {

	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		if(beanName.equals("indexService")){
			System.out.println("postProcessBeforeDestruction by index");
		}
	}

	@Override
	public boolean requiresDestruction(Object bean) {
		return true;
	}
}
