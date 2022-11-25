package com.example.inventory.servicesimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entity.Login;
import com.example.inventory.entity.Orders;
import com.example.inventory.entity.RestInventor;
import com.example.inventory.entity.Users;
import com.example.inventory.model.Registration;
import com.example.inventory.repos.LoginRepo;
import com.example.inventory.repos.UserRepo;
import com.example.inventory.services.Services;


@Service 
public class ServicesImplementation  implements Services{

	@Autowired
	LoginRepo loginrepo;
	
	@Autowired
	UserRepo userrepo;
	
	@Override
	public boolean authentication(String userId, String password) {
		// TODO Auto-generated method stub
		
		Login login = loginrepo.findById(userId).get();
		
	    if(login.getPassword().equals(password)) {
	    	return true;
	    }
		
		return false;
	}

	@Override
	public boolean authorization(String userId, String userRole) {
		// TODO Auto-generated method stub
		Users user = userrepo.findByUserId(userId).get();
		
		if(user.getRole().equals(userRole)) return true;
		
		
		return false;
	}

	@Override
	public String registration(Registration registration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editInventory(RestInventor restInventor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acceptOrders(Orders orders) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean triggerEmail(String email, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
