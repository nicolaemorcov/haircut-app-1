package com.viewer.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlFileResponse extends ResponseHandler {
	private String forwardUrl;

	public HtmlFileResponse(String forwardUrl) {
		super();
		this.forwardUrl = forwardUrl;
	}
	
	@Override
	public void writeToHttpServletResponse(HttpServletRequest request,
			HttpServletResponse response) {
	
		setContentType("text/html");
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		
		try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println("Forward to url "+forwardUrl+" failed " + e);
        }
	}
}
