package com.example.inventory.servicesimpl;

import java.util.List;

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
public class ServicesImplementation implements Services {

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

		if (logindetails.getPassword().equals(login.getPassword())) {
			return userrepo.findByUserId(logindetails.getUserId()).get().getRole();
		}
		
		return "Invalid UserId or Password";
	}

	@Override
	public String registration(Registration registration) {
		// TODO Auto-generated method stub
		UserIdUtilities useridutil = new UserIdUtilities();
		String userId = useridutil.generateUserId(userrepo);
		Users user = new Users(userId, registration.getName(), registration.getPhone(), registration.getEmail(),
				registration.getRole(), registration.getDob());
		userrepo.save(user);
		Login login = new Login(userId, registration.getPassword());
		loginrepo.save(login);
		return userId;
	}

	@Override
	public String editInventory(RestInventor restInventor) {
		// TODO Auto-generated method stub

		restrepo.save(restInventor);

		Inventory inventory = inventoryrepo.findByMaterialIdAndLocationNumber(restInventor.getMaterialId(),
				restInventor.getLocationNumber());

		inventory.setResetQty(restInventor.getResetQty());
		inventory.setAvailableQuantity(inventory.getResetQty() - inventory.getOrderQuantity());

		inventoryrepo.save(inventory);

		return "updated";
	}

	@Override
	public String acceptOrders(Orders orders) {
		// TODO Auto-generated method stub

		orderrepo.save(orders);
		Inventory inventory = inventoryrepo.findByMaterialIdAndLocationNumber(orders.getMaterialId(),
				orders.getLocationNumber());
		
		inventory.setOrderQuantity(inventory.getOrderQuantity()+orders.getOrderQuantity());
		inventory.setAvailableQuantity(inventory.getResetQty() - inventory.getOrderQuantity());

		inventoryrepo.save(inventory);

		return "Order Successfull";

	}

	@Override
	public Boolean triggerEmail(String email, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> getInventorys(Long locnum) {

		return inventoryrepo.findAllByLocationNumber(locnum);

	}

	@Override
	public Inventory getInventory(Long locnum, String matId) {
		return inventoryrepo.findByMaterialIdAndLocationNumber(matId, locnum);
	}
	
	
	
}
