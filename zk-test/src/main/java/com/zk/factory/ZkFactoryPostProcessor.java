package com.zk.factory;

import com.zk.service.IndexService;
import com.zk.targetsource.TestTargetBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

//@Component
public class ZkFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		//GenericBeanDefinition zkService = (GenericBeanDefinition) beanFactory.getBeanDefinition("zkService");
		/**
		 * 在bd生成后，在对象实例化前，对bdMap中的值进行修改
		 */
		//zkService.setBeanClass(IndexService.class);
		//zkService.setBeanClassName("com.zk.service.IndexService");

		AbstractBeanDefinition testTargetBean = (AbstractBeanDefinition) beanFactory.getBeanDefinition("testTargetBean");
		testTargetBean.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
	}
}
