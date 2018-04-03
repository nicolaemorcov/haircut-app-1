package com.commons.entities;

import java.sql.Timestamp;
import java.text.ParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user")  
@Entity
public class Customer extends User{
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Timestamp dob;
	
	public Customer(String username, String password, String firstName, String lastName, String email, String dob) throws ParseException {
		super(username, password, firstName, lastName, email, dob);
		// TODO Auto-generated constructor stub
		this.username = getUsername();
		this.password = getPassword();
		this.firstName = getFirstName();
		this.lastName = getLastName();
		this.email = getEmail();
		this.dob = getDOB();
	}
}
