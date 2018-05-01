package com.viewer.endpoints;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewer.handlers.BookingHandler;
import com.viewer.handlers.DisplayHandler;
import com.viewer.handlers.Handler;
import com.viewer.handlers.ResponseHandler;
import com.viewer.handlers.UserAuthenticationHandler;
import com.viewer.handlers.UserHandler;

/**
 * Here is where the request is forwarded by the server based web.xml configuration.
 * all localhost:8080/viewer/.....    with /viewer/ will be forwarded to this endpoint.
 * here we will decide wich handler to use for processing the request. for example if the 
 * url is /viewer/services/ then we need the ServiceHandler, if request url is /viewer/bookings
 * then we will need the BookingHandler
 * */
public class ServiceEndpoint extends Endpoint {

	private static final long serialVersionUID = 7959912518978202195L;
	
	int numOfAccesses = 0;
	
	// Logger sor the requests...
	private static final Logger log = Logger.getLogger(ServiceEndpoint.class.getName());

	@Override
	public void init(ServletConfig config) throws ServletException {
		log.info("Initialising the ServiceEndpoint servlet");
		initializeMappings();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {

		String path = request.getRequestURI();
		
		
		log.info("Request " + path + " received on ServiceEndpoint");
		numOfAccesses++;
		System.out.println(numOfAccesses);
		
		// here we will store all the path arguments
		List<String> pathArgs = getPathArgs(path);
		
		Handler handler = findHandler(path, pathArgs);
		
		if(handler == null) {
			// send back access denied
			log.info("ACCESS DENIED");
			
//			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/html/index.html");
//			try {
//				view.forward(request, response);
//			} catch (ServletException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			RequestDispatcher rd = request.getRequestDispatcher("html/mypage.html");
//			try {
//				rd.forward(request, response);
//			} catch (ServletException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
////			//TEMP  !!!!!!!!!!!!!!!!!!!
////			response.setContentType("application/json;charset=UTF-8");
//			response.setContentType("text/html");
//			response.setStatus(200);
//			try {
//				response.getWriter().write("/view.html");
//				
//				return;
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		} else {
			ResponseHandler rh = handler.doGet(request);
			
			rh.writeToHttpServletResponse(request, response);
		}
//		try {
//			response.getWriter().write("{name: test}");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		//this will hold the path params
//		List<String> pathArgs = new ArrayList<String>();
//		
//		Handler handler = findHandler(path, pathArgs);
//		

	}
	
	// associate right Handler with request type, 
	// if request url is localhost:8080/info/.... then call InfoHandler,
	// if request url is localhost:8080/auth/.... then call UserAuthenticationHandler,
	@Override
	protected void initializeMappings() {
		log.info("adding the handlers");
		
		addHandler(BookingHandler.class, "(?i)^/services/bookings");
		
		addHandler(UserHandler.class, "(?i)^/services/users");
	}

}
