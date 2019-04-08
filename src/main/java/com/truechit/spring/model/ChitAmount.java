package com.truechit.spring.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ChitAmount")
public class ChitAmount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long chitId;
	private int chitCycle;
	private double amount;
	
	public ChitAmount(Long chitId, int chitCycle, double amount) {
		super();
		this.chitId = chitId;
		this.chitCycle = chitCycle;
		this.amount = amount;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getChitId() {
		return chitId;
	}
	public void setChitId(Long chitId) {
		this.chitId = chitId;
	}
	public int getChitCycle() {
		return chitCycle;
	}
	public void setChitCycle(int chitCycle) {
		this.chitCycle = chitCycle;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
}
