package com.cursoPlatzi.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

public class MyBeanPropertiesImpl implements MyBeanProperties{

	private String name;
	private String lastName;
	private String random;
	
	
	
	
	public MyBeanPropertiesImpl(String name, String lastName, String random) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.random = random;
	}




	@Override
	public String getValues() {
		
		return name +" - "+lastName + " - " + random;
	}


}
