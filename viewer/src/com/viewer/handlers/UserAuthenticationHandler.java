package com.viewer.handlers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.commons.entities.User;
import com.commons.manager.objectmanagers.ObjectManagerContext;
import com.commons.service.UserService;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class UserAuthenticationHandler extends Handler {
	UserService service;

	ObjectManagerContext objectManager;

	public UserAuthenticationHandler(ObjectManagerContext objectManager) {
		this.objectManager = objectManager;
		this.service = new UserService(objectManager);
	}

	@Override
	public ResponseHandler doPost(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Searching account.......");
		User user = service.login(username, password);
		
		System.out.println(user);
		
		// convert to JSON
		Gson gson = new Gson();
		
		String output = gson.toJson(user);
		
		JSONObject jsonObject = new JSONObject();
		
		// {"data": [{Male haircut}, {Female Haircut, price, dec}]}
		jsonObject.put("data", user);
		//return response
		return new JSONResponse(jsonObject);
	
}
}