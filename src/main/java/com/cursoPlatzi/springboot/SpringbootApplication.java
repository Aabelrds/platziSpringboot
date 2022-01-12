package com.cursoPlatzi.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursoPlatzi.springboot.bean.MyBean;
import com.cursoPlatzi.springboot.bean.MyBeanWithDependency;
import com.cursoPlatzi.springboot.bean.MyOperation;
import com.cursoPlatzi.springboot.component.ComponentDependency;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner{
	
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	
	//@QUALIFIER INDICA QUE DEPENDENCIA QUIERES UTILIZAR.
	public SpringbootApplication(
			@Qualifier("componentImpl2") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency) {
		super();
		
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}



	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}



	@Override
	public void run(String... args){
		
		this.componentDependency.sayHello();
		this.myBean.print();
		this.myBeanWithDependency.printWithDependency();
		
	}

}

