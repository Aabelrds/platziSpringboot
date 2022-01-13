package com.cursoPlatzi.springboot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cursoPlatzi.springboot.bean.MyBeanProperties;
import com.cursoPlatzi.springboot.bean.MyBeanPropertiesImpl;
import com.cursoPlatzi.springboot.pojo.UserPojo;


//Config las variables diciendole a spring la clase.
@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfig {

	@Value("$(value.name)")
	private String name;

	@Value("$(value.lastName)")
	private String lastName;
	
	@Value("$(value.randomValue)")
	private String randomValue;
	
	@Bean
	public MyBeanProperties beanProperties() {
		
		return new MyBeanPropertiesImpl(name,lastName,randomValue);
	}
}
