package com.commons.entities;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user")  
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	private String username;
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	
	@Column(name = "dob")
	private Timestamp dob;
	
	@Column(name = "gender")
	private Gender gender;
	
	public User() {}
	//constructor for Person class
	public User(String username, String password, String firstName, String lastName, String email,
			String dob, Gender gender) throws ParseException{
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setDOB(dob);
		this.setGender(gender);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public int getId(){
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//getters
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
	public Timestamp getDOB() {
		return dob;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	
	
	//setters
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setDOB(String dob) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		this.dob = new Timestamp(sdf.parse(dob).getTime());
	}
	
	public Gender getGender() {
		return gender;
	}
	
	//log in
	public boolean logIn(String username, String password) {
		return username.equals(this.username) && password.equals(this.password);
	}
	
/*	//log out
	public boolean logOut() {
		return false;
	}*/
	
	
}
