package com.cursoPlatzi.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cursoPlatzi.springboot.bean.MyBean;
import com.cursoPlatzi.springboot.bean.MyBeanImpl2;
import com.cursoPlatzi.springboot.bean.MyBeanWithDependency;
import com.cursoPlatzi.springboot.bean.MyBeanWithDependencyImpl;
import com.cursoPlatzi.springboot.bean.MyOperation;
import com.cursoPlatzi.springboot.bean.MyOperationImpl;

@Configuration
public class BeanConfiguration {
	//Aquí si tenemos dos implementaciones de MyBean simplemente
	//cambiamos la impl que deseamos retornar.
	@Bean
	public MyBean beanOperation(){
		return new MyBeanImpl2();
		
	}
	
	@Bean
	public MyOperation beanOperationOperation(){
		return new MyOperationImpl();
		
	}
	
	//Config de la dependencia con dependencia (MyOperation)
	@Bean
	public MyBeanWithDependency beanOperationWithDependency(MyOperation myoperation){
		return new MyBeanWithDependencyImpl(myoperation);
		
	}
}
