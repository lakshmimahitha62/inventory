package com.example.inventory.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int locationNumber;
	private String materialNumber;
	private long ResetQty;
	private long orderQuantity;
	private long availableQuantity;
	private java.time.LocalDate updateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLocationNumber() {
		return locationNumber;
	}
	public void setLocationNumber(int locationNumber) {
		this.locationNumber = locationNumber;
	}
	public String getMaterialNumber() {
		return materialNumber;
	}
	public void setMaterialNumber(String materialId) {
		this.materialNumber = materialId;
	}
	public long getResetQty() {
		return ResetQty;
	}
	public void setResetQty(long resetQty) {
		ResetQty = resetQty;
	}
	public long getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public long getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public java.time.LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.time.LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	public Inventory(int id, int locationNumber, String materialId, long resetQty, long orderQuantity,
			long availableQuantity, LocalDate updateDate) {
		super();
		this.id = id;
		this.locationNumber = locationNumber;
		this.materialNumber = materialId;
		ResetQty = resetQty;
		this.orderQuantity = orderQuantity;
		this.availableQuantity = availableQuantity;
		this.updateDate = updateDate;
	}
	public Inventory() {
		super();
	}
	
	
	
}
