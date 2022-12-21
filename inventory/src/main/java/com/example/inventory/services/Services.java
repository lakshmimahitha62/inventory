package com.example.inventory.services;

import java.util.List;

import com.example.inventory.entity.Inventory;
import com.example.inventory.entity.Login;
import com.example.inventory.entity.Orders;
import com.example.inventory.entity.RestInventor;
import com.example.inventory.model.Registration;

public interface Services {
	
	public String authentication(Login login);
	public String registration(Registration registration);
	public String editInventory(RestInventor restInventor);
	public String acceptOrders(Orders orders);
	public Boolean triggerEmail(String email, String message);
	public List<Inventory> getInventorys(Long locnum);
	public Inventory getInventory(Long locnum, String matId);
	
	
}
