package com.example.inventory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.entity.Login;
import com.example.inventory.model.Registration;
import com.example.inventory.response.Message;
import com.example.inventory.services.Services;
import com.example.inventory.utility.UserIdUtilities;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {
	
	@Autowired
	Services services;
	
	
	
	@Autowired
	UserIdUtilities useridutil;
	@GetMapping("")
	public Message loginMesssage(@RequestBody Login login){
		return login(login);
//		return "Hello hi";
		//return useridutil.generateUserId();
		
	}
	
	@PostMapping("/login")
	public Message login(@RequestBody Login login) {
		
		return new Message(services.authentication(login));

	}
	
	@PostMapping("/register")
	public Message registrationPage(@RequestBody Registration registation)  {
		
		return  new Message("your user ID is "+services.registration(registation)) ;
		
		
	}
	
}
