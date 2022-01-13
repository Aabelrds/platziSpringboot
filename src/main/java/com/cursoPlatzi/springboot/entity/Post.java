package com.cursoPlatzi.springboot.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id", nullable= false, unique = true)
	private Long id;
	
	@Column(name = "post_description", length = 400)
	private String description;
	
	@ManyToOne
	private User user;
	
	
	public Post() {
		super();
	}


	public Post(String description, User user) {
		super();
		this.description = description;
		this.user = user;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", user=" + user + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
