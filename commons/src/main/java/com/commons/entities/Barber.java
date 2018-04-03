package com.commons.entities;

import java.sql.Timestamp;
import java.text.ParseException;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="user")  
@Entity
public class Barber extends User{
	
	public Barber(String username, String password, String firstName, String lastName, String email, String dob, String address,
			String staffInfo) throws ParseException {
		super(username, password, firstName, lastName, email, dob);
		this.address = address;
		this.staffInfo = staffInfo;
	}
		
		private String address;
		private String staffInfo;
		
		//getters
		public String getAddress() {
			return address;
		}
		public String getStaffInfo() {
			return staffInfo;
		}
		
		//setters
		public void setAddress(String address) {
			this.address = address;
		}
		public void setStaffInfo(String staffInfo) {
			this.staffInfo = staffInfo;
		}
		
		
		
}
