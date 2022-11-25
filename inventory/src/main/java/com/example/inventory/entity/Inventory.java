package com.example.inventory.entity;

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
	private String materialId;
	private long ResetQty;
	private long orderQuantity;
	private long availableQuantity;
	private java.time.LocalDate updateDate;

}
