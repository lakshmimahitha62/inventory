package com.example.inventory.services;

import com.example.inventory.entity.Login;
import com.example.inventory.entity.Orders;
import com.example.inventory.entity.RestInventor;
import com.example.inventory.model.Registration;

public interface Services {
	
	public String authentication(Login login);
	public String registration(Registration registration);
	public boolean editInventory(RestInventor restInventor);
	public boolean acceptOrders(Orders orders);
	public Boolean triggerEmail(String email, String message);
	
	

}
