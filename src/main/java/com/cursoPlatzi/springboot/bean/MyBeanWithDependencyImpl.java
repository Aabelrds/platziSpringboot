package com.cursoPlatzi.springboot.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency{
	
	Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImpl.class);
	private MyOperation myOperation;
	
	public MyBeanWithDependencyImpl(MyOperation myOperation) {
		super();
		this.myOperation = myOperation;
	}

	@Override
	public void printWithDependency() {
		
		// Nos sirve para debuggear lo que pasa en determinada parte de la app
		LOGGER.info("Hemos ingresado al metodo MyBeanWaithDependency");
		int numero = 2;
		LOGGER.debug("El número enviado para la operación es :" + numero);
		System.out.println("Hellow desde MyBeanWithDependency ");
		System.out.println(this.myOperation.sum(numero));
		
		
	}
// Implementando una dependencia con dependencia.
}
