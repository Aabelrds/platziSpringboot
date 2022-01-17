package com.cursoPlatzi.springboot.dto;

public class UserDto {
	// En esta clase representaremos lo que queremos obtener en nuestras consultas Sql
	
	private Long id;
	private String name;
	private String birthDate;
	
	public UserDto(Long id, String name, String birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	
}