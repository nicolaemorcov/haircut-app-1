package com.viewer.handlers;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestHandler {
//	
//	// ?param1=xxx&param2=yyy
//	private Map<String, String> urlParameters;
//	
//	// /page1/account/user
//	private List<String> pathParameters;
//	
//	// the request client did. the link user clicked
//	private String requestUri;
//	
//	private HttpServletRequest httpRequest;
//	
//	public ParsedRequest(HttpServletRequest httpRequest,
//			List<String> pathParameters) {
//		this.requestUri = httpRequest.getRequestURI();
//		this.httpRequest = httpRequest;
//		
//		this.pathParameters = new ArrayList<String>();
//
//		// parse the following link by adding url params in a list. take all after the '?' mark 
//		// http://www.java2s.com/query?pg=q&kl=XX&stype=stext&q=%2B%22Java+Programming%22&search.x=30&search.y=7";
//		// result: [pq: 1, kl: xx, stype: stext]
//		
//		
//		// parse the following link and add to a list http://www.java2s.com/Tutorial/Java/0320__Network/URLDecoder2.htm
//		// result is [Tutorial, java, 030__Network,URLDecoder2. htm]
//		for (String param : pathParameters) {
//			try {
//				String value = URLDecoder.decode(param, "UTF-8");
//				this.pathParameters.add(value);
//			} catch (Exception e) {
//				this.pathParameters.add(param);
//			}
//		}
//	}
}
