package com.commons.service;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;

import com.commons.entities.User;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;

public class UserService {
	protected ObjectManagerContext oc;
	protected DataAccessObject dao;
	
	public UserService() {}
	
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
		String sqlName = "UPDATE User p SET p.firstName = :firstNameVar," + 
				"p.lastName = :lastNameVar" + 
				" WHERE p.email = :newEmail";
		
		Query q = oc.createQuery(sqlName)
				.setParameter("firstNameVar", user.getFirstName())
				.setParameter("lastNameVar", user.getLastName())
				.setParameter("newEmail", user.getEmail());
		oc.executeQuery(q);
		
	}
	
//	=================================================================
	
	public List<User> getAllUsers() {
		
		String query = "FROM User u";
		
		//Create query
		List<User> users = oc.getResultList(User.class, query);
		return users;
		
	}
	
//	===================================================================
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
	
//	============================================================================================
	
	public User login(String username, String password) {
		
		String sql = "FROM User u WHERE u.username = :usernameVar AND u.password = :passwordVarTemporary";
		User user = oc.getSingleResult(User.class, sql, "usernameVar", username, "passwordVarTemporary", password);
		
//		String sql = "FROM User WHERE username = \'" + username + "\' AND password = " + password; 
//		User user = oc.getSingleResult(User.class, sql);
		
		return user;

	}
}

