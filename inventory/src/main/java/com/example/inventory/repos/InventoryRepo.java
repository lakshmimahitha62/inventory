package com.example.inventory.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.entity.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
	public Inventory findByMaterialNumberAndLocationNumber(String materialId, Long locationNumber);
	
}
