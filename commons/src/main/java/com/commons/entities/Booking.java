package com.commons.entities;
import java.sql.Time;
import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.commons.service.ServiceEntity;
@Table(name="booking")
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="booking_id")
	private int bookingId;
	
	@Column(name="service_id")
	private int serviceId;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name = "date_booked")
	private String dateBooked;
	
	@Column(name = "date_due")
	private Timestamp dateDue;
	
	@Column(name="booking_time")
	private String bookingTime;
	
	@Column(name="booking_price")
	private double bookingPrice;
	
	public Booking(){}
	

	
	/**
	 * @param bookingId
	 * @param serviceId
	 * @param customerId
	 * @param dateBooked
	 * @param dateDue
	 * @param bookingPrice
	 */
	public Booking(int serviceId, int customerId, String dateDue,
			String bookingTime, double bookingPrice) throws ParseException{
		this.setServiceId(serviceId);
		this.setCustomerId(customerId);
		this.setDateBooked(dateBooked);
		this.setDateDue(dateDue);
		this.setBookingPrice(bookingPrice);
		this.setBookingTime(bookingTime);
	}



	// generated (protected, final)
	//getters
	int getBookingId() {
		return bookingId;
	}
	int getServiceId() {
		return serviceId;
	}
	public String getDateBooked() {
		return dateBooked;
	}

	public Timestamp getDateDue() {
		return dateDue;
	}
	
	public String getBookingTime() {
		return bookingTime;
	}

	public int getCustomerId() {
		return customerId;
	}
	public double getBookingPrice() {
		return bookingPrice;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

//	public long getBarberId() {
//		return barberId;
//	}
//
//	public void setBarberId(int barberId) {
//		this.barberId = barberId;
//	}

	
	//setters
	protected void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
//	protected void setDateBooked() {
//		Date dNow = new Date( );
//	      SimpleDateFormat ft = 
//	      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
//	      this.dateBooked = ft.format(dNow);
//		
//	}
	
	

//	protected void setBookingId(int bookingId) {
//		this.bookingId = bookingId;
//	}
	
	protected void calculateBookingPrice(double bookingPrice) {
		this.bookingPrice = bookingPrice;
	}



	public void setDateBooked(String dateBooked)throws ParseException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		this.dateBooked = dtf.format(localDate); //2016/11/16
	}



	public void setDateDue(String dateDue) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		this.dateDue = new Timestamp(sdf.parse(dateDue).getTime());
	}



	public void setBookingPrice(double bookingPrice) {
		this.bookingPrice = bookingPrice;
	}
	
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	
}

