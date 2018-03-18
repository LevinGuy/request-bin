package com.levin.guy.bin.model;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**
 * Skeleton class that exposes some basic information that we want to store about a Request.
 *
 * Please add whatever you feel is missing.
 */
public class Request {

    private String id;
    private String methodName;
    private String requestURI;
    private String content;
    private Map<String, String> headers;

    public Request() {
    	this.headers = new HashMap<String, String>();
    	this.id = UUID.randomUUID().toString();
    }

    public static Request buildFromHttpRequest(HttpServletRequest httpServletRequest) throws IOException {
        Request request = new Request();
        request.methodName = httpServletRequest.getMethod();
        request.requestURI = httpServletRequest.getRequestURI();

        Enumeration<String> hds = httpServletRequest.getHeaderNames();
        while (hds.hasMoreElements())
        {
        	String name = hds.nextElement();
        	String value = httpServletRequest.getHeader(name);
        	request.headers.put(name, value);
        }
                
        try(BufferedReader bufferedReader = httpServletRequest.getReader()) {
            if(bufferedReader != null) {
                String line = null;
                request.content = "";
                while ((line = bufferedReader.readLine()) != null) {
                    request.content += line + System.getProperty("line.separator");
                }
            }
        }
        return request;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public String getContent() {
        return content;
    }

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
