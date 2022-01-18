package com.cursoPlatzi.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoPlatzi.springboot.caseuse.GetUser;
import com.cursoPlatzi.springboot.entity.User;


//RestController nos permite que todos los métodos 
//se formateen con el formato Json
@RestController
@RequestMapping("/api/users")
public class userRestController {
	
	private GetUser getUser;
	
	
	public userRestController(GetUser getUser) {
		super();
		this.getUser = getUser;
	}

	@GetMapping("/")
	List<User> getUsers(){
		
		return getUser.getAll();
	}
}
