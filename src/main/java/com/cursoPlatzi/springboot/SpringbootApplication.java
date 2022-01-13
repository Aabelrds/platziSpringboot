package com.cursoPlatzi.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursoPlatzi.springboot.bean.MyBean;
import com.cursoPlatzi.springboot.bean.MyBeanProperties;
import com.cursoPlatzi.springboot.bean.MyBeanWithDependency;
import com.cursoPlatzi.springboot.bean.MyOperation;
import com.cursoPlatzi.springboot.component.ComponentDependency;
import com.cursoPlatzi.springboot.pojo.UserPojo;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner{
	
	// Inyectamos las dependencias en el constructor de la clase principal 
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanProperties myBeanProperties;
	private UserPojo userPojo;
	
	//@QUALIFIER INDICA QUE DEPENDENCIA QUIERES UTILIZAR.
	public SpringbootApplication(
			@Qualifier("componentImpl2") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanProperties myBeanProperties,
			UserPojo userPojo) {
		super();
		
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanProperties = myBeanProperties;
		this.userPojo = userPojo;
	}



	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}


//Por medio de CommandLineRunner podemos mostrar todas las dependencias con sus variables
	@Override
	public void run(String... args){
		
		this.componentDependency.sayHello();
		this.myBean.print();
		this.myBeanWithDependency.printWithDependency();
		System.out.println(this.myBeanProperties.getValues());
		System.out.println(this.userPojo.getEmail());
		
	}

}

