package com.zk.factory;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Set;

public class CustomScan extends ClassPathBeanDefinitionScanner {

	public CustomScan(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@Override
	public Set<BeanDefinition> findCandidateComponents(String basePackage) {
		return super.findCandidateComponents(basePackage);
	}

	@Override
	protected boolean isCandidateComponent(MetadataReader metadataReader) throws IOException {
		return super.isCandidateComponent(metadataReader);
	}
}
