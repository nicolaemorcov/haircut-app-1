package com.viewer.handlers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.commons.service.ServiceEntity;
import com.commons.service.ShopService;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class DisplayHandler extends Handler{

	ShopService service;
	
	public DisplayHandler() {
		service = new ShopService();
	}
	
	@Override
	public ResponseHandler doGet(HttpServletRequest request) {
		// get all the services from database
		// using ShopService.getAllServices()  method from the commons project
		List<ServiceEntity> services = service.getAllServices();
		
		// convert to JSON
		Gson gson = new Gson();
		
		String output = gson.toJson(services);
		
		JSONObject jsonObject = new JSONObject();
		
		// {"data": [{Male haircut}, {Female Haircut, price, dec}]}
		jsonObject.put("data", services);
		//return response
		return new JSONResponse(jsonObject);
	}
//	
//	@Override
//	public ResponseHandler doPost(HttpServletRequest request) {
//		// check if the user is admin, if is not admin then return 401 Restriced
//		
//		// get parametr from the request
//		
//		// save or update service in the database
//	}
}
