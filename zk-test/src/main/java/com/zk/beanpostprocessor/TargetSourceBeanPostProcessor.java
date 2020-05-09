package com.zk.beanpostprocessor;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

@Component
//此类生效后会永远返回一个代理对象，除非返回一个空对象
public class TargetSourceBeanPostProcessor extends AbstractAutoProxyCreator {
	@Override
	protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource customTargetSource) throws BeansException {

		return DO_NOT_PROXY;
	}
}
