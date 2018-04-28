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
	ApplicationManagerContext appManager = new ApplicationManagerContext();
	DBObjectManager dbManager = new DBObjectManager(appManager);
	ObjectManagerContext objectManager = new DataAccessObject(appManager, dbManager);
	UserService service;
	
	
	public UserHandler() {
		service = new UserService();
	}
	
	@Override
	public ResponseHandler doGet(HttpServletRequest request) {
		UserService service = new UserService(objectManager);
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
