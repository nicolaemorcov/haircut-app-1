package com.commons.entities;

import java.sql.Date;

public class Order {
	
	public int quantity;
	public Date date; // is sql the right one ?
	private Status status;
	
	
	//getters
	public int getQuantity() {
		return quantity;
	}
	public Date getDate() {
		return date;
	}
	public Status getStatus() {
		return status;
	}
	
	//setters
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
