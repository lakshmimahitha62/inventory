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
public class RestInventor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int locationNumber;
	private String materialId;
	private long ResetQty;
	
	private java.time.LocalDate resetDate;
	
}
