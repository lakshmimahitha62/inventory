package com.example.inventory.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.inventory.repos.InventoryRepo;

@Component
public class InventoryValidation {

	@Autowired
	InventoryRepo inventoryRepo;

	public String validateInvntory(long locNum, String materialId, long qty) {

		if (inventoryRepo.findByMaterialIdAndLocationNumber(materialId, locNum).getResetQty() > qty)
			return "Updated Quantity should be Greater than Reset Quantity";
		return "";

	}

	public String validateOrder(long locNum, String materialId, long qty) {

		if (inventoryRepo.findByMaterialIdAndLocationNumber(materialId, locNum).getAvailableQuantity() > qty && qty > 0)
			return "Order Quantity should be less than avalable Quantity";
		return "";

	}


}
