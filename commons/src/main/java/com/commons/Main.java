package com.commons;

import java.text.ParseException;

import com.commons.entities.Booking;
import com.commons.entities.User;
import com.commons.manager.ApplicationManagerContext;
import com.commons.manager.objectmanagers.DBObjectManager;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;
import com.commons.service.BookingService;
import com.commons.service.UserService;

public class Main {

	public static void main(String[] args) throws ParseException {
//		User newUser = new User("krg111", "4223", "Toby", "Gore", "toby129@gmail.com", "22/10/1978");
//		try {
//			newUser.setDOB("22/10/1978");
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
////		}
//		
		Booking newBooking = new Booking(24, 2, "25/3/2018", "10:20", 17.00);
		try {
			newBooking.setDateDue("25/03/2018");
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		ApplicationManagerContext appManager;
		DBObjectManager dbManager;
		
		DataAccessObject objectManager;
		
		appManager = new ApplicationManagerContext();
		dbManager = new DBObjectManager(appManager);
		objectManager = new DataAccessObject(appManager, dbManager);
		
//		UserService service = new UserService(objectManager);
//		service.createUser(newUser);

//		
		
	}
}
