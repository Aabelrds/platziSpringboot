package com.cursoPlatzi.springboot.configuration;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
	
	
	//Relacionamos toda la conf con nuestra base de datos.
	//bbdd en memoria con H2
	@Bean
	public  DataSource dataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:mem:testdb");
		dataSourceBuilder.username("SA");
		dataSourceBuilder.password("");
		
		return dataSourceBuilder.build();
	}
}
