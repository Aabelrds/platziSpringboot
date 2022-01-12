package com.cursoPlatzi.springboot.component;

import org.springframework.stereotype.Component;

//Creación de dependencia.
@Component
public class ComponentImpl implements ComponentDependency{

	@Override
	public void sayHello() {
		
		System.out.println("Hellow ");
	}

}
