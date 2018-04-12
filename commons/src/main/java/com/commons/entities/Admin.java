package com.commons.entities;

import java.sql.Timestamp;
import java.text.ParseException;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="user")  
@Entity
public class Admin extends User{

	public Admin(String username, String password, String firstName, String lastName, String email, String dob, Gender gender) throws ParseException {
		super(username, password, firstName, lastName, email, dob, gender);
		// TODO Auto-generated constructor stub
	}
}
