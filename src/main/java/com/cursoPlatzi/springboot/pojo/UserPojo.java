package com.cursoPlatzi.springboot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

//Configuramos el acceso a las variables creadas en el properties
@ConstructorBinding
@ConfigurationProperties(prefix = "user")
public class UserPojo {

	private String email;
	private String name;
	private int age;
	
	public UserPojo(String email, String name, int age) {
		super();
		this.email = email;
		this.name = name;
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
