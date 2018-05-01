package com.viewer.handlers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.commons.entities.Booking;
import com.commons.manager.ApplicationManagerContext;
import com.commons.manager.objectmanagers.DBObjectManager;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;
import com.commons.service.BookingService;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class BookingHandler extends Handler{
	ObjectManagerContext objectManager;
	BookingService service;
	
	
	public BookingHandler(ObjectManagerContext objectManager) {
		this.objectManager = objectManager;
		service = new BookingService(objectManager);
	}
	
	
	@Override
	public ResponseHandler doGet(HttpServletRequest request) {
		BookingService service = new BookingService(objectManager);
		System.out.println("Getting all bookings");
		List<Booking> bookings = service.getAllBookings();
		
		System.out.println(bookings);
		
		// convert to JSON
		Gson gson = new Gson();
		
//		String output = gson.toJson(bookings);
		
		JSONObject jsonObject = new JSONObject();
		
		// {"data": [{}, {}]}
		jsonObject.put("data", bookings);
		//return response
		return new JSONResponse(jsonObject);
	}
}
