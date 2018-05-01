package com.viewer.endpoints;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.manager.ApplicationManagerContext;
import com.commons.manager.objectmanagers.DBObjectManager;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;
import com.viewer.handlers.BookingHandler;
import com.viewer.handlers.DisplayHandler;
import com.viewer.handlers.Handler;
import com.viewer.handlers.HtmlFileResponse;
import com.viewer.handlers.ResponseHandler;
import com.viewer.handlers.UserAuthenticationHandler;
import com.viewer.handlers.UserHandler;

public class Endpoint extends HttpServlet{
	
	ApplicationManagerContext appManager = new ApplicationManagerContext();
	DBObjectManager dbManager = new DBObjectManager(appManager);
	ObjectManagerContext objectManager = new DataAccessObject(appManager, dbManager);

	private static final long serialVersionUID = 4785042788453160450L;

	// Logger sor the requests...
	private static final Logger log = Logger
			.getLogger(Endpoint.class.getName());
	
	// this LinkedHashMap has restriction to store only classes that extends the Handler class
	private Map<Pattern, Class<? extends Handler>> handlerMapping = new LinkedHashMap<Pattern, Class<? extends Handler>>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		log.info("Initialising the ServiceEndpoint servlet");
		initializeMappings();
	}
	
	protected void initializeMappings() {
		log.info("adding the handlers");
		
		// the url localhost:8080/info/...
		addHandler(DisplayHandler.class, "(?i)^/view/*");
		
//		addHandler(UserHandler.class, "(?i)^/view/users");
	}

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) {
		
		String path = request.getRequestURI();
		
		// here we will store all the path arguments
				List<String> pathArgs = getPathArgs(path);
		Handler handler = findHandler(path, pathArgs);
		
		if(handler == null) {
			// send back access denied
			log.info("ACCESS DENIED");
			
		} else {
			ResponseHandler rh = handler.doGet(request);
			
			rh.writeToHttpServletResponse(request, response);
		}
		
//		try {
//			response.sendRedirect("/view/bookings");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<String> args = getPathArgs(path);
//		log.info("Request " + path + " received on Endpoint");
//		
//		ResponseHandler handler = new HtmlFileResponse(path+".html");
////		ResponseHandler handler = new HtmlFileResponse("WEB-INF/html/admin.html");
//		
//		handler.writeToHttpServletResponse(request, response);

		
	}
	
	public String generateFilePath(List<String> args) {
		StringBuilder path = new StringBuilder("WEB-INF/html/");
		
		if (args.size() > 1) {
			if(args.get(1) == "bookings") {
				return path.append("booking.html").toString();
			}
		}
		
		path.append("admin.html");
		
		return path.toString();
	}
	
	protected List<String> getPathArgs(String path) {
		
		String[] pathArguments = path.split("/");
		
		List<String> pathArgs = new ArrayList<String>();
		for (int i = 1; i < pathArguments.length; i++) {
			pathArgs.add(pathArguments[i]);
		}
		
		return pathArgs;
	}
	
	protected Handler findHandler(String path, List<String> pathArgs) {

		if (path.endsWith("/")) {
			path = path.replaceAll("/+$", "");
		}

		log.info("Path is " + path);

		for (Entry<Pattern, Class<? extends Handler>> entry : handlerMapping
				.entrySet()) {
			Matcher matcher = entry.getKey().matcher(path);

			log.info("Matcher is " + entry.getKey());

			if (matcher.find()) {
				for (int i = 0; i < matcher.groupCount(); i++) {
					if (matcher.group(i + 1) != null) {
						pathArgs.add(matcher.group(i + 1));
					}
				}
				Class<? extends Handler> handlerClass = entry.getValue();

				log.info("Class " + handlerClass.getName() + " is found");

				// return a handler with objectManager Parameter
				switch(handlerClass.getName()) {
				case "com.viewer.handlers.DisplayHandler":
					return new DisplayHandler(objectManager);
					
				case "com.viewer.handlers.BookingHandler":
					return new BookingHandler(objectManager);
					
				case "com.viewer.handlers.UserHandler":
					return new UserHandler(objectManager);
				}
//				try {
//					return handlerClass.getConstructor().newInstance();
//				} catch (InstantiationException | IllegalAccessException 
//						| IllegalArgumentException | InvocationTargetException 
//						| NoSuchMethodException | SecurityException e) {
//					System.out.println("Failed to return new instance using class name: " 
//							+ e);
//				}
			}
		}
		return null;
	}
	
	// when Servlet starts, add the handler to the HashMap  /info/: InfoHandler.class
	// 
	protected void addHandler(Class<? extends Handler> handlerClass,
			String urlPattern) {
		
		Pattern pattern = Pattern.compile(urlPattern);
		handlerMapping.put(pattern, handlerClass);
	}
}
