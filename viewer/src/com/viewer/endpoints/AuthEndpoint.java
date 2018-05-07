package com.viewer.endpoints;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewer.handlers.BookingHandler;
import com.viewer.handlers.Handler;
import com.viewer.handlers.ResponseHandler;
import com.viewer.handlers.UserAuthenticationHandler;
import com.viewer.handlers.UserHandler;

public class AuthEndpoint extends Endpoint{

	private static final long serialVersionUID = 4785042788453160450L;
	
	int numOfAccesses = 0;

	// Logger sor the requests...
	private static final Logger log = Logger
			.getLogger(AuthEndpoint.class.getName());
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		log.info("Initialising the AuthEndpoint servlet");
		//do similar as in ServiceEndpoint
		
		
	}
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) {
		
		String path = request.getRequestURI();
		log.info("Request " + path + " received on AuthEndpoint");
		
		

	}
	

		
	}