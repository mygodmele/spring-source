package com.zk.test;

import com.zk.config.AppConfig;
import com.zk.factory.MyBeanFactory;
import com.zk.service.*;
import com.zk.targetsource.TestTargetBean;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.TargetSourceCreator;
import org.springframework.aop.framework.autoproxy.target.QuickTargetSourceCreator;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.aop.target.ThreadLocalTargetSource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class zkTest {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(AppConfig.class);
		context.refresh();

		//********************************************
		// 测试parentBeanFactory
		/*ConfigurableListableBeanFactory listableBeanFactory = context.getBeanFactory();
		listableBeanFactory.setParentBeanFactory(new MyBeanFactory());
		listableBeanFactory.getBean("aaa", BeanFactoryService.class);*/

		//********************************************

		/*IgnoreService testService = (IgnoreService) context.getBean("ignoreService");
		testService.say();*/

		//********************************************
		// 查看BD的类型
		// appConfig配置类的db类型：AnnotatedGenericBeanDefinition
		//System.out.println(context.getBeanDefinition("appConfig").getClass().getSimpleName());

		// @component的db类型：ScannedGenericBeanDefinition
		//System.out.println(context.getBeanDefinition("zkFactoryPostProcessor").getClass().getSimpleName());
		//System.out.println(context.getBeanDefinition("zkService").getClass().getSimpleName());

		//********************************************
		// 测试AOP循环依赖代理生成
		// 为什么不加proxyTargetClass = true不行，因为使用了JDK动态代理，需要转型成接口类型
		/*IndexService indexService = (IndexService) context.getBean("indexService");
		indexService.say();
		IgnoreService ignoreService = (IgnoreService) context.getBean("ignoreService");
		ignoreService.say();*/
		//********************************************
		// 测试targetsource
		/*for (BeanFactoryPostProcessor beanFactoryPostProcessor : context.getBeanFactoryPostProcessors()) {
			System.out.println("====== " + beanFactoryPostProcessor);
		}
		AbstractAutowireCapableBeanFactory factory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
		AbstractAutoProxyCreator creator = (AbstractAutoProxyCreator) factory.getBeanPostProcessors().get(3);

		System.out.println(">>>>>> " + creator);
		*//*ThreadLocalTargetSource threadLocalTargetSource = new ThreadLocalTargetSource();
		threadLocalTargetSource.setTargetClass(TestTargetBean.class);*//*

		QuickTargetSourceCreator quickTargetSourceCreator = new QuickTargetSourceCreator();
		quickTargetSourceCreator.setBeanFactory(factory);
		creator.setCustomTargetSourceCreators(new TargetSourceCreator[]{quickTargetSourceCreator});*/


		/*SingletonTargetSource singletonTargetSource = new SingletonTargetSource(new TestTargetBean());
		System.out.println(singletonTargetSource.getTarget());*/
		//********************************************
		// 测试构造方法推断
		context.getBean("indexService");
		context.close();
	}

}
