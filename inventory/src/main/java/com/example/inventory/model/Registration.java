package com.example.inventory.model;

import java.util.Date;

//import javax.persistence.Entity;


public class Registration {
	private String name;
	 private String phone;
	private String email;
	private Date dob;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Registration(String name, String phone, String email, Date dob) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
	}
	public Registration() {
		super();
	}
	
	

}