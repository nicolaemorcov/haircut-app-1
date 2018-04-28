package com.viewer.handlers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.commons.entities.Service;
import com.commons.entities.User;
import com.commons.manager.ApplicationManagerContext;
import com.commons.manager.objectmanagers.DBObjectManager;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;
import com.commons.service.ShopService;
import com.commons.service.UserService;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class DisplayHandler extends Handler{
	ApplicationManagerContext appManager = new ApplicationManagerContext();
	DBObjectManager dbManager = new DBObjectManager(appManager);
	ObjectManagerContext objectManager = new DataAccessObject(appManager, dbManager);
	ShopService service;
	
	
	public DisplayHandler() {
		service = new ShopService();
	}
	
	@Override
	public ResponseHandler doGet(HttpServletRequest request) {
		ShopService service = new ShopService(objectManager);
		System.out.println("Getting all services");
		List<Service> services = service.getAllServices();
		
		System.out.println(services);
		
		// convert to JSON
		Gson gson = new Gson();
		
		String output = gson.toJson(services);
		
		JSONObject jsonObject = new JSONObject();
		
		// {"data": [{Male haircut}, {Female Haircut, price, dec}]}
		jsonObject.put("data", services);
		//return response
		return new JSONResponse(jsonObject);
	}
	
	
	
}