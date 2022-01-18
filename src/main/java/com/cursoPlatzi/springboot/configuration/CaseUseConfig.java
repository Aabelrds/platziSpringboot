package com.cursoPlatzi.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cursoPlatzi.springboot.caseuse.GetUser;
import com.cursoPlatzi.springboot.caseuse.GetUserImpl;
import com.cursoPlatzi.springboot.service.UserService;

@Configuration
public class CaseUseConfig {

	@Bean
	GetUser getUser(UserService userService) {
		return new GetUserImpl(userService);
	}
}
