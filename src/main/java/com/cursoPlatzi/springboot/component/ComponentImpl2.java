package com.cursoPlatzi.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImpl2 implements ComponentDependency{

	@Override
	public void sayHello() {

		System.out.println("Hellow I'm ComponentImpl2");
		
	}

}
