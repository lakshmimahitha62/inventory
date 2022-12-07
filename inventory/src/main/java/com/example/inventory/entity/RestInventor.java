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
public class RestInventor {

	@Id
	
	private String materialId;
	private Long ResetQty;
	private Long locationNumber;
	private java.time.LocalDate resetDate;
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public long getResetQty() {
		return ResetQty;
	}
	public void setResetQty(long resetQty) {
		ResetQty = resetQty;
	}
	public Long getLocationNumber() {
		return locationNumber;
	}
	public void setLocationNumber(Long locationNumber) {
		this.locationNumber = locationNumber;
	}
	public java.time.LocalDate getResetDate() {
		return resetDate;
	}
	public void setResetDate(java.time.LocalDate resetDate) {
		this.resetDate = resetDate;
	}
	public RestInventor(String materialId, long resetQty, Long locationNumber, LocalDate resetDate) {
		super();
		this.materialId = materialId;
		ResetQty = resetQty;
		this.locationNumber = locationNumber;
		this.resetDate = resetDate;
	}
	public RestInventor() {
		super();
	}
	
	
	
}
