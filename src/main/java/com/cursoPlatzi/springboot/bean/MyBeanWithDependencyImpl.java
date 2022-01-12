package com.cursoPlatzi.springboot.bean;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

	private MyOperation myOperation;
	
	public MyBeanWithDependencyImpl(MyOperation myOperation) {
		super();
		this.myOperation = myOperation;
	}

	@Override
	public void printWithDependency() {
		
		int numero = 2;
		System.out.println("Hellow desde MyBeanWithDependency ");
		System.out.println(this.myOperation.sum(numero));
		
		
	}
// Implementando una dependencia con dependencia.
}
