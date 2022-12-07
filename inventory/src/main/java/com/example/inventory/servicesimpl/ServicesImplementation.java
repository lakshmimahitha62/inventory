package com.example.inventory.servicesimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entity.Inventory;
import com.example.inventory.entity.Login;
import com.example.inventory.entity.Orders;
import com.example.inventory.entity.RestInventor;
import com.example.inventory.entity.Users;
import com.example.inventory.model.Registration;
import com.example.inventory.repos.EditInventoryRepo;
import com.example.inventory.repos.InventoryRepo;
import com.example.inventory.repos.LoginRepo;
import com.example.inventory.repos.OrderRepo;
import com.example.inventory.repos.UserRepo;
import com.example.inventory.services.Services;
import com.example.inventory.utility.UserIdUtilities;


@Service 
public class ServicesImplementation  implements Services{

	@Autowired
	LoginRepo loginrepo;
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	EditInventoryRepo restrepo;
	
	@Autowired
	OrderRepo orderrepo;
	
	@Autowired 
	InventoryRepo inventoryrepo;
	
	@Override
	public String authentication(Login login) {
		// TODO Auto-generated method stub
		
		Login logindetails = loginrepo.findById(login.getUserId()).get();
		
	    if(logindetails.getPassword().equals(login.getPassword())) {
	    	return userrepo.findByUserId(logindetails.getUserId()).get().getRole();
	    }
		
		return "Invalid UserId or Password";
	}

	

	@Override
	public String registration(Registration registration) {
		// TODO Auto-generated method stub
		UserIdUtilities useridutil=new UserIdUtilities();
		String userId=useridutil.generateUserId(userrepo);
		Users user=new Users(userId,registration.getName(),registration.getPhone(),registration.getEmail(),registration.getRole(),registration.getDob());
		userrepo.save(user);
		return userId;
	}

	@Override
	public boolean editInventory(RestInventor restInventor) {
		// TODO Auto-generated method stub
		
		restrepo.save(restInventor);
		
		Inventory inventory = inventoryrepo.findByMaterialNumberAndLocationNumber(restInventor.getMaterialId(), restInventor.getLocationNumber());
		
		inventory.setAvailableQuantity(restInventor.getResetQty() - inventory.getOrderQuantity());
		
		inventoryrepo.save(inventory);
		
		return true;
	}

	@Override
	public boolean acceptOrders(Orders orders) {
		// TODO Auto-generated method stub
		
		orderrepo.save(orders);
		Inventory inventory = inventoryrepo.findByMaterialNumberAndLocationNumber(orders.getMaterialId(),orders.getLocationNumber());
		
		inventory.setAvailableQuantity(inventory.getResetQty() - orders.getOrderQuantity());
		
		inventoryrepo.save(inventory);
		
		return true;
		
	}

	@Override
	public Boolean triggerEmail(String email, String message) {
		// TODO Auto-generated method stub
		return null;
	}

}
