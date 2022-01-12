package com.cursoPlatzi.springboot.bean;

public class MyOperationImpl implements MyOperation{

	@Override
	public int sum(int number) {
		
		return number += number;
	}

}
