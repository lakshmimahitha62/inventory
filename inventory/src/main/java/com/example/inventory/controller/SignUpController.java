package com.example.inventory.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.model.Registration;
import com.example.inventory.services.Services;
import com.example.inventory.utility.UserIdUtilities;

@RestController

public class SignUpController {
	
	@Autowired
	Services services;
	
	@Autowired
	UserIdUtilities useridutil;
	@GetMapping("")
	public String loginMesssage(){
		return login("Mahi1234","mahitha1","user");
//		return "Hello hi";
		//return useridutil.generateUserId();
		
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
	
	@RequestMapping("/register")
	public String registrationPage() throws ParseException {
		SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		
		 date = dateFor.parse("08/07/2019");
		
		Registration register=new Registration("Mahitha","1287384938","njanjfd@ndfm.com",date);
		
		return  "your user ID is "+services.registration(register) ;
		
		
		
	}
	
}
