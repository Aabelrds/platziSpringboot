package com.cursoPlatzi.springboot.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false, unique= true )
	private Long id;
	
	@Column(name = "user_name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "user_email", nullable = false, length = 50)
	private String email;
	
	@Column(name = "user_birthDate")
	private LocalDate birthDate;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Post> posts = new ArrayList<>();
	
	
	public User(String name, String email, LocalDate birthDate) {
		super();
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;

	}
	
	


	public User() {
	}




	@Override
	public String toString() {
		
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", "
				+ "birthDate=" + birthDate + ", posts=" + posts + "]";
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




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public LocalDate getBirthDate() {
		return birthDate;
	}




	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}



	public List<Post> getPosts() {
		return posts;
	}




	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
