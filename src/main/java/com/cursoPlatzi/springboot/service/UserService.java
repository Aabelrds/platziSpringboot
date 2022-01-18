package com.cursoPlatzi.springboot.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursoPlatzi.springboot.entity.User;
import com.cursoPlatzi.springboot.repository.UserRepository;

@Service
public class UserService {

	private final Log LOG = LogFactory.getLog(UserService.class);
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Transactional
	public void saveTransactional(List<User> users) {
		
		users.stream()
			.peek(user -> LOG.info("usuario guardado" + user))
			.forEach(userRepository::save);
	}
	
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
}
