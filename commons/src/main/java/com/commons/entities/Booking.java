package com.commons.entities;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table(name="booking")
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name="service_id")
	private Service service;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private User customer;
	
	@Column(name = "date_booked")
	private String dateBooked;
	
	@Column(name = "date_due")
	private Timestamp dateDue;
	
	@Column(name="time")
	private String bookingTime;
	
//	@Column(name="price")
//	private double bookingPrice;
	
//	public Booking(){}
//	
//
//	
//	/**
//	 * @param bookingId
//	 * @param serviceId
//	 * @param customerId
//	 * @param dateBooked
//	 * @param dateDue
//	 * @param bookingPrice
//	 */
//	public Booking(int serviceId, int customerId, String dateDue,
//			String bookingTime, double bookingPrice) throws ParseException{
//		this.setServiceId(serviceId);
//		this.setCustomerId(customerId);
//		this.setDateBooked(dateBooked);
//		this.setDateDue(dateDue);
//		this.setBookingPrice(bookingPrice);
//		this.setBookingTime(bookingTime);
//	}


	public String getDateBooked() {
		return dateBooked;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Timestamp getDateDue() {
		return dateDue;
	}
	
	public String getBookingTime() {
		return bookingTime;
	}


//	public double getBookingPrice() {
//		return bookingPrice;
//	}
//	
//	protected void calculateBookingPrice(double bookingPrice) {
//		this.bookingPrice = bookingPrice;
//	}



	public void setDateBooked(String dateBooked)throws ParseException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		this.dateBooked = dtf.format(localDate); //2016/11/16
	}



	public void setDateDue(String dateDue) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		this.dateDue = new Timestamp(sdf.parse(dateDue).getTime());
	}



//	public void setBookingPrice(double bookingPrice) {
//		this.bookingPrice = bookingPrice;
//	}
	
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	
}

