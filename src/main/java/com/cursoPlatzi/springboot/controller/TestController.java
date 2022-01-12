package com.cursoPlatzi.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping
	@ResponseBody
	public ResponseEntity<String> connection(){
		
		return new ResponseEntity<>("<h1> Hello from controller </h1> ", HttpStatus.OK);
	}

}
