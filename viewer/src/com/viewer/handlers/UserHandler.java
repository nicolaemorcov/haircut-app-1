package com.viewer.handlers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.commons.entities.User;
import com.commons.manager.ApplicationManagerContext;
import com.commons.manager.objectmanagers.DBObjectManager;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;
import com.commons.service.UserService;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class UserHandler extends Handler{
	UserService service;
	
	ObjectManagerContext objectManager;

	public UserHandler(ObjectManagerContext objectManager) {
		this.objectManager = objectManager;
		this.service = new UserService(objectManager);
	}
	
	
	
	@Override
	public ResponseHandler doGet(HttpServletRequest request) {
		
		System.out.println("Getting all users");
		List<User> users = service.getAllUsers();
		
		System.out.println(users);
		
		// convert to JSON
		Gson gson = new Gson();
		
		String output = gson.toJson(users);
		
		JSONObject jsonObject = new JSONObject();
		
		// {"data": [{Male haircut}, {Female Haircut, price, dec}]}
		jsonObject.put("data", users);
		//return response
		return new JSONResponse(jsonObject);
	}
	
	
	
}
