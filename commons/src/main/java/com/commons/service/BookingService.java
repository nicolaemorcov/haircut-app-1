package com.commons.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.commons.entities.Booking;
import com.commons.entities.User;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;

public class BookingService {
	protected ObjectManagerContext oc;
	DataAccessObject dao;
	ShopService services;
	
	//this is for development only. will be removed when
	// there will be database available
	List<Booking> allBookings = new ArrayList<Booking>();
	
	public BookingService(ObjectManagerContext oc) {
		this.oc = oc;
		
		
	}
	
	public BookingService() {
		// TODO Auto-generated constructor stub
	}

	public void createBooking(Booking booking) {
		oc.persist(booking);
		System.out.println("Create booking");
	}
	
//	//==============================kolia==========================================================
//	public void deleteBooking(Booking booking) {
//		String query = "DELETE FROM Booking b WHERE b.customerId = :customerIdVariable";
//		
//		Query q = oc.createQuery(query)
//				.setParameter("customerIdVariable", booking.getCustomerId());
//		oc.executeQuery(q);
//	}
//	
//	public void changeDateTime(Booking booking) {
//		String sql = "UPDATE Booking b SET b.dateDue = :dateDue, b.bookingTime = :time WHERE "
//				+ " b.customerId = :customerIdVar";
//		
//		Query q = oc.createQuery(sql)
//				.setParameter("dateDue", booking.getDateDue())
//				.setParameter("customerIdVar", booking.getCustomerId())
//				.setParameter("time", booking.getBookingTime());
//		oc.executeQuery(q);
//		
//	}
	
//	public void changeCustomer(Booking booking) {
//		String sql = "UPDATE Booking b SET b.customerId = :customerId  WHERE "+ 
//				" b.customerId = :customerIdVar";
//		
//		Query q = oc.createQuery(sql)
//				.setParameter("customerId", booking.getCustomerId());
//		oc.executeQuery(q);
//	}
	
	
	
//	===============Kolia=========================
	public List<Booking> findAllBookingsById(int id){
//		User user = new User();
		String query = "FROM Booking b WHERE b.customerId = :customerIdVariable";
		
		//create query
		List<Booking> bookings = oc.getResultList(Booking.class, query, "customerIdVariable", id);
		return bookings;
	}
	
//	====================kolia===============================================
	public Booking findBookingById(int id){
//		User user = new User();
		String query = "FROM Booking b WHERE b.bookingId = :bookingIdVariable";
		
		//create query
		Booking booking = oc.getSingleResult(Booking.class, query, "bookingIdVariable", id);
		return booking;
	}
	
	
	
	
//	
	
	public void updateBooking(int bookingId, String bookingNewStatus) {
//		Booking b = new Booking();
		System.out.println(bookingId);
		System.out.println(bookingNewStatus);
		
		
		String sql = "UPDATE Booking " + 
				"SET status = \'" + bookingNewStatus +  "\' " + 
				"WHERE id = " + bookingId;
		
//		Query q = oc.createQuery(sql);
		oc.executeUpdate(sql);
		
		System.out.println(bookingId);
		System.out.println("This is the status: ---------> " + bookingNewStatus);
		//oc.executeUpdate
		System.out.println("update booking");
	}
	
	


	
	
//	===============Kolia==========================
	public List<Booking> getAllBookings() {

		String query = "FROM Booking b";
		
		//Create query
		List<Booking> bookings = oc.getResultList(Booking.class, query);


		return bookings;
	}
}
