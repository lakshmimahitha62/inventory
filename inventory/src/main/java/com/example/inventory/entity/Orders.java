package com.example.inventory.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private Date localDate;

	
	private Time localTime;
	private Long locationNumber;
	private Integer materialNumber;
	private Long orderQuantity;
	private String orderStatus;

}
