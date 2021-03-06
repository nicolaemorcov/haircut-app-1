package com.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.commons.entities.Booking;
import com.commons.entities.Customer;
import com.commons.entities.Gender;
import com.commons.entities.Service;
import com.commons.entities.User;
import com.commons.manager.ApplicationManagerContext;
import com.commons.manager.objectmanagers.DBObjectManager;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;
import com.commons.service.BookingService;
import com.commons.service.ShopService;
import com.commons.service.UserService;

public class JPAObjectManagerContextTest {

	ApplicationManagerContext appManager;
	DBObjectManager dbManager;
	ObjectManagerContext objectManager;
	UserService us;
	


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("testing...");
		appManager = new ApplicationManagerContext();
		dbManager = new DBObjectManager(appManager);
		objectManager = new DataAccessObject(appManager, dbManager);
		dbManager.getMasterDBFactory();
	}

	@After
	public void tearDown() throws Exception {
		appManager = null;
		dbManager = null;
		objectManager = null;
	}
	
	
//	=======================================   Create    ==================================================
	
//	@Test
//	@Ignore
//	public void createBookingTest()  {
//		Booking b;
//		User u = ;
//		Service s = new Service();
//		
//		
//		System.out.println("saving the booking");
//		
//		try {
//			b = new Booking(8, 7, "07/05/2018", "18:00");
//			objectManager.persist(b);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("saved to db...");
//	}
	
	
	@Test
	@Ignore
	public void createCustomerTest()  {
		User c1;
		try {
			System.out.println("saving the object");
			c1 = new User("Fighter", "JCVD56", "Jean-claude", "Vandammer", "jcvd@mail.ru", "26/10/1960", Gender.MALE);
//			dbManager.createMasterDBFactory();
			objectManager.persist(c1);
			System.out.println("saved to db...");
		} catch (ParseException e) {
			System.out.println(e);
		}
	}
	
	                                         // Service
	@Test
	@Ignore
	public void createServiceTest()  {
		Service s;
		System.out.println("saving the object");
		s = new Service("Bald/Skin Fade", 14.00, "This is a Temple fade");
		objectManager.persist(s);
		System.out.println("saved to db...");
	}
//	==================================================================================================
	
	@Test
	@Ignore
	public void getAllBookings() {
		BookingService bs = new BookingService(objectManager);
		
		List<Booking> bookings = bs.getAllBookings();
		
		for(Booking b: bookings) {
			System.out.println(b.getCustomer().getFirstName());
		}
	}
	
//	@Test
//	@Ignore
//	public void deleteBooking() {
//		BookingService bs = new BookingService(objectManager);
//		List<Booking> bookings = bs.getAllBookings();
//		for(int i = 0 ;i < bookings.size(); i++) {
//			Booking b = bookings.get(i);
//			objectManager.delete(b);
//		}
		
		
//	}
	
	
//	
//	=============================     Delete  =========================================
	@Test
	@Ignore
	public void deleteUserByEmailTest() {
		UserService service = new UserService(objectManager);
		User user = service.findUserByEmail("im@gmail.com");
		service.deleteUser(user);
		System.out.println("User deleted");
	}
	
									//Service
	
	@Test
	@Ignore
	public void deleteServiceByIdTest() {
		ShopService s = new ShopService(objectManager);
		Service service = s.findServiceById(1);
		s.deleteService(service);
		System.out.println("Service deleted");
	}
	
	
	
////	=======================================kolia==============================
//	@Test
//	@Ignore
//	public void deleteBookingByCustId() {
//		BookingService bs = new BookingService(objectManager);
//		List<Booking> bookings = bs.findAllBookingsById(20);
//		
//		for (int i = 0; i < bookings.size(); i++) {
//			Booking b = bookings.get(i);
//			bs.deleteBooking(b);
//		}
//		System.out.println("Booking deleted");
//	}
	
	
	
	@Test
	@Ignore
	public void findUserByEmailTest() {
		UserService us = new UserService(objectManager);
		
		System.out.println("searching for user");
		User user = us.findUserByEmail("mm@gmail.com");
		System.out.println(user.getEmail() + ",  " + user.getFirstName() + " "  + user.getLastName());
	}
	
//	====================================kolia=====================
	@Test
	@Ignore
	public void getAllUsersTest() {
		UserService service = new UserService(objectManager);
		System.out.println("Getting all users");
		List<User> users = service.getAllUsers();
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			System.out.println(u.getFirstName() + ", " + u.getLastName());
			
		}
		
		System.out.println(users);
	}
	
//	========================================================================
	
	@Test
	@Ignore
	public void getAllServicesTest() {
		ShopService service = new ShopService(objectManager);
		System.out.println("Getting all services");
		List<Service> services = service.getAllServices();
		
		for (int i = 0; i < services.size(); i++) {
			Service s = services.get(i);
			System.out.println(s.getServiceName() + ", " + s.getServicePrice());
			
		}
		
		System.out.println(services);
	}
	
//	
//	//===========Kolia=============
//	@Test
//	@Ignore
//	public void findBookingByIdTest() {
//		BookingService bs = new BookingService(objectManager);
//		
//		System.out.println("searching for booking");
//		List<Booking> bookings = bs.findAllBookingsById(22);
//		for (int i = 0; i < bookings.size(); i++) {
//			Booking b = bookings.get(i);
//			System.out.println(b.getCustomerId() + ", " + b.getDateDue() + ", " + b.getBookingPrice());
//			
//		}
//	}
	
//	=============KOLIA===============================
	@Test
	@Ignore
	public void findUserByIdTest() {
		UserService service = new UserService(objectManager);
		System.out.println("searching for user");
		User user = service.findUserById(1);
		System.out.println(user.getFirstName() + ", " + user.getLastName());
	
	}
	
//	========================================================================
	
	@Test
	@Ignore
	public void findBookingByIdTest() {
		BookingService service = new BookingService(objectManager);
		System.out.println("searching for booking");
		Booking booking = service.findBookingById(2);
		System.out.println(booking.getDateDue() + ", " + booking.getBookingTime());
	
	}
	
//	===========================================================================
	
	@Test
	@Ignore
	public void loginTest() {
		UserService service = new UserService(objectManager);
		System.out.println("searching for user");
		User user = service.login("Jimbo", "j19imbo");
		System.out.println(user.getFirstName() + ", " + user.getLastName());
	
	}
	
	
	
////	=============Kolia==========================
//	@Test
////	@Ignore
//	public void createBookingTest() {
//		Booking b1;
//		try {
//			System.out.println("saving the object");
//			b1 = new Booking(4, 3, "29/06/2018", "16:40", 22.00);
////			dbManager.createMasterDBFactory();
//			objectManager.persist(b1);
//			System.out.println("booking saved to db...");
//		}catch (ParseException e) {
//			System.out.println(e);
//		}
//	}
	
	@Ignore
	@Test
	public void readPropertiesFile() {
		Properties kwMappingProperties = new Properties();
		
		try {
			kwMappingProperties.load(new FileInputStream("src/main/resources/kw_mapping.properties"));
			System.out.println(
					kwMappingProperties.getProperty("46B6488DD72C62D1E10000000A1553F7"));
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("temp test");
	}
	
//	===================================   Update       ======================================
	@Test
	@Ignore
	public void updateUserFirstNameTest() {
		UserService service = new UserService(objectManager);
		System.out.println("searching for user");
		User user = service.findUserByEmail("bb@mail.com");
		user.setFirstName("John");
		user.setLastName(" Flick");
		service.updateFirstName(user);
		System.out.println("User updated....");
	} 
	
	
//	@Test
//	@Ignore
//	public void updateBookingTest() {
//		BookingService service = new BookingService(objectManager);
//		System.out.println("searching for booking");
//		Booking booking = service.findBookingById(3);
//		booking.setStatus("Terminat");
//		String status = booking.getStatus();
//		System.out.println("Booking updated....");
////		System.out.println(booking.getStatus());
//		service.updateBooking();
//	} 
	
	

//	======================================================
	
//	@Test
//	@Ignore
//	public void changeDateTimeTest() {
//		BookingService bs = new BookingService(objectManager);
//		try {
//			System.out.println("searching for booking");
//			Booking booking = bs.findBookingById(1);
//			booking.setDateDue("17/05/2018");
//			booking.setBookingTime("11:00");
//			bs.changeDateTime(booking);
//		}catch (ParseException e) {
//			System.out.println(e);
//		}
//	} 
//	============================================================================================

	
////	====================================kolia=====================================
	
	
//	@Test
//	public void tempTest() {
//		 String url = "http://www.%20test.com/home/user/";
//		    String decoded;
//			try {
//				decoded = URLDecoder.decode(url, "UTF-8");
//				
//				System.out.println(decoded);
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    
//	}

}
