package com.example.inventory.controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.entity.Inventory;
import com.example.inventory.entity.Login;
import com.example.inventory.entity.Orders;
import com.example.inventory.entity.RestInventor;
import com.example.inventory.model.Registration;
import com.example.inventory.response.Message;
import com.example.inventory.services.Services;
import com.example.inventory.utility.UserIdUtilities;
import com.example.inventory.validations.InventoryValidation;
import com.example.inventory.validations.UserValidation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {

	@Autowired
	Services services;

	@Autowired
	UserIdUtilities useridutil;
	
	@Autowired
	InventoryValidation inventoryValidation;

	@PostMapping("/login")
	public ResponseEntity<Message> login(@RequestBody Login login) {

		return new ResponseEntity<>(new Message(services.authentication(login)), HttpStatus.OK);

	}

	@PostMapping("/register")
	public ResponseEntity<Message> registrationPage(@RequestBody Registration registation) {

		String validateUser = UserValidation.validateUser(registation);
		if (validateUser.equals(""))

			return new ResponseEntity<>(new Message("your user ID is " + services.registration(registation)),
					HttpStatus.OK);
		else
			return new ResponseEntity<>(new Message(validateUser), HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getInventory/{locNum}/{materialId}")
	public ResponseEntity<Inventory> getInventory(@PathVariable long locNum, @PathVariable String materialId) {
		
		Inventory inventory = services.getInventory(locNum, materialId);
			return new ResponseEntity<>(inventory,HttpStatus.OK);
		

	}

	@GetMapping("/getInventorys/{locNum}")
	public ResponseEntity<List<Inventory>> getInventory(@PathVariable long locNum) {

		
		List<Inventory> inventorys = services.getInventorys(locNum);
		if(!inventorys.isEmpty())
		return new ResponseEntity<>(inventorys,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		

	}

	@PostMapping("/updateInventory/{locNum}/{materialId}/{qty}")
	public ResponseEntity<Message> updateInventory(@PathVariable long locNum, @PathVariable String materialId,
			@PathVariable long qty) {

		HttpStatus status;
		status = HttpStatus.OK;
		String msg = inventoryValidation.validateInvntory(locNum, materialId, qty);

		if (msg.equals("")) {

			RestInventor restInventor = new RestInventor(materialId, qty, locNum, new Date());
			return new ResponseEntity<>(new Message(services.editInventory(restInventor)), status);

		} else {
			return new ResponseEntity<>(new Message(msg), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/order/{locNum}/{materialId}/{qty}")
	public ResponseEntity<Message> order(@PathVariable long locNum, @PathVariable String materialId,
			@PathVariable long qty) {

		HttpStatus status;
		status = HttpStatus.OK;
		String msg = inventoryValidation.validateOrder(locNum, materialId, qty);

		if (msg.equals("")) {

			RestInventor restInventor = new RestInventor(materialId, qty, locNum, new Date());
			return new ResponseEntity<>(new Message(services.editInventory(restInventor)), status);

		} else {
			return new ResponseEntity<>(new Message(msg), HttpStatus.BAD_REQUEST);
		}
	}

}
