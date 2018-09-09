package eu.babywatcher.services.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	boolean isMongoInitialized = false;

	@Value("${spring.cloud.kubernetes.secrets.paths}")
	String trustFilePath;
	
	@Value("${trust.file.name}")
	String trustFileName;
	
	@Value("${trust.file.password}")
	String trustFilePassword;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (!isMongoInitialized &&
				beanName.endsWith("MongoProperties")) {
			isMongoInitialized = true;
			if (trustFilePath != null && trustFilePath.length() > 0 &&
					trustFileName != null && trustFileName.length() > 0 &&
					trustFilePassword != null && trustFilePassword.length() > 0) {
				System.setProperty("javax.net.ssl.trustStore", trustFilePath + "/" + trustFileName);
				System.setProperty("javax.net.ssl.trustStorePassword", trustFilePassword);
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}
}
