package com.truechit.spring.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "Chit")
public class Chit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chitId;
	private String chitName;
	private int numberofUsers;
	private int numberofPhases;
	//(Monthly/weekly/bimonth/biweekly) Need to change field to Enum
	private String chitType;
	private double foremanFee;
	private String maxBiddingCalculationRegex;
	@ElementCollection
	private List<User> users;
	private String status;
	private double chitAmount;

	public double getChitAmount() {
		return chitAmount;
	}

	public void setChitAmount(double chitAmount) {
		this.chitAmount = chitAmount;
	}

	public String getChitName() {
		return chitName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setChitName(String chitName) {
		this.chitName = chitName;
	}

	public Long getChitId() {
		return chitId;
	}

	public void setChitId(Long chitId) {
		this.chitId = chitId;
	}

	public int getNumberofUsers() {
		return numberofUsers;
	}

	public void setNumberofUsers(int numberofUsers) {
		this.numberofUsers = numberofUsers;
	}

	public int getNumberofPhases() {
		return numberofPhases;
	}

	public void setNumberofPhases(int numberofPhases) {
		this.numberofPhases = numberofPhases;
	}

	public String getChitType() {
		return chitType;
	}

	public void setChitType(String chitType) {
		this.chitType = chitType;
	}

	public double getForemanFee() {
		return foremanFee;
	}

	public void setForemanFee(double foremanFee) {
		this.foremanFee = foremanFee;
	}

	public String getMaxBiddingCalculationRegex() {
		return maxBiddingCalculationRegex;
	}

	public void setMaxBiddingCalculationRegex(String maxBiddingCalculationRegex) {
		this.maxBiddingCalculationRegex = maxBiddingCalculationRegex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
