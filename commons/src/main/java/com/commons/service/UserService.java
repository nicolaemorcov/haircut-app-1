package com.commons.service;



import java.util.List;

import javax.persistence.Query;

import com.commons.entities.User;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;

public class UserService {
	protected ObjectManagerContext oc;
	protected DataAccessObject dao;
	
	public UserService(ObjectManagerContext oc) {
		this.oc = oc;
	}
	
	public void createUser(User user) {
		//kolia
		oc.persist(user);
		//===========================================
	}
	
	public void deleteUser(User user) {
		String query = "DELETE FROM User u WHERE u.email = :emailVariable";
		
		Query q = oc.createQuery(query)
				.setParameter("emailVariable", user.getEmail());
		oc.executeQuery(q);
	}
	
//	===================Kolia=========================
	public void updateFirstName(User user) {
		String sql = "UPDATE User p SET p.firstName = :firstNameVar WHERE "
				+ "p.email = :newEmail";
		
		Query q = oc.createQuery(sql)
				.setParameter("firstNameVar", user.getFirstName())
				.setParameter("newEmail", user.getEmail());
		oc.executeQuery(q);
		
	}
	
	
	
	
	public User findUserByEmail(String email) {
		String query = "FROM User p WHERE p.email = :email";
		
		//create query
		User user = oc.getSingleResult(User.class, query, "email", email);
		
		return user;
	}
	
//	==============KOLIA===========================
	public User findUserById(int userId) {
		String query = "FROM User p WHERE p.id = :user_id";
		
		User user = oc.getSingleResult(User.class, query, "user_id", userId);
		return user;
		
	}
	

}
