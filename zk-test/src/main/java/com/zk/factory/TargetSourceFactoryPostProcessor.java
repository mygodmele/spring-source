package com.zk.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

//@Component
public class TargetSourceFactoryPostProcessor implements BeanFactoryPostProcessor {


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractAutowireCapableBeanFactory factory = (AbstractAutowireCapableBeanFactory) beanFactory;
		for (BeanPostProcessor beanPostProcessor : factory.getBeanPostProcessors()) {
			System.out.println("执行bean生命周期前的beanPostProcessor： " + beanPostProcessor);
		}
	}
}
