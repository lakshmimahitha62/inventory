package com.example.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.services.Services;

@RestController
//@Component
public class SignUpController {
	
	@Autowired
	Services services;
	
	@GetMapping("")
	public String loginMesssage(){
		return login("Mahi1234","mahitha1","user");
//		return "Hello hi";
	}
	
	
	public String login(String userId, String password, String role) {
		boolean f = services.authentication(userId, password);
		
		if(!f)return "Invalid userId or password";
		else {
			
			boolean roleFlag = services.authorization(userId, role);
			if(!roleFlag) return "Your not authorized";
		}
		return "Successfully logined in ";
	}
	
}
