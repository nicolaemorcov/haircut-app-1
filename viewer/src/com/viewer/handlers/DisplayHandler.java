package com.viewer.handlers;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.commons.entities.Service;
import com.commons.entities.User;
import com.commons.manager.ApplicationManagerContext;
import com.commons.manager.objectmanagers.DBObjectManager;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;
import com.commons.service.ShopService;
import com.commons.service.UserService;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class DisplayHandler extends Handler{
	
	ObjectManagerContext objectManager;
	ShopService service;
	
	public DisplayHandler(ObjectManagerContext objectManager) {
		this.objectManager = objectManager;
		service = new ShopService(objectManager);
	}
	
	@Override
	public ResponseHandler doGet(HttpServletRequest request) {
		String path = request.getRequestURI();
		
		List<String> args = getPathArgs(path);
		
		if(args.size() > 1) {
			System.out.println(args.get(1));
			if(args.get(1).equals("bookings")) {
				return new HtmlFileResponse("/html/bookings.html");
			}
		}
		return new HtmlFileResponse("/html/admin.html");
	}	
}