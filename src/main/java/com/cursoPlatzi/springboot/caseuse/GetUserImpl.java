package com.cursoPlatzi.springboot.caseuse;


import java.util.List;

import com.cursoPlatzi.springboot.entity.User;
import com.cursoPlatzi.springboot.service.UserService;

public class GetUserImpl implements GetUser{

	private UserService userService;
	
	
	public GetUserImpl(UserService userService) {
		this.userService = userService;
	}


	@Override
	public List<User> getAll() {
		
		return userService.getAllUsers();
	}


}
