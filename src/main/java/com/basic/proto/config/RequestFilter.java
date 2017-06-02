package com.basic.proto.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.basic.proto.form.AppSessionForm;
import com.basic.proto.form.UserLoginSessionForm;



/**
 * Servlet Filter - populates the server transaction properties
 */
public class RequestFilter implements Filter {
	
	/**
	 * autowire environment context
	 */
	@Autowired
	Environment env;
	
	/** Get the logger **/
	Logger logger = (Logger) LoggerFactory.getLogger(RequestFilter.class);
	
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	//	System.out.println("do filter...!");
		HttpServletRequest reHttpServletRequest = (HttpServletRequest) request;
		HttpSession httpSession = reHttpServletRequest.getSession();
		UserLoginSessionForm userLoginSession = (UserLoginSessionForm) request.getAttribute("userLoginSessionForm");
		if(userLoginSession != null){
			//Todo
			if(userLoginSession.isUserLogin()){
				//System.out.println("usr  logged in");
			}
		}else{
			//System.out.println("usr not logged in");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//No transaction needed
		System.out.println(" filter do init...!");
		AppSessionForm appSessionForm = ApplicationSessionObject.getApplicationSessionObject();
	}
	
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//do nothing
		System.out.println("do destroy...!");
		//To do write all appsession from data to serilizable file
	}
	
	
}
/*****************************************************************************
 * ELSEVIER CONFIDENTIAL
 * 
 * 
 * This document is the property of Elsevier, and its contents are proprietary
 * to Elsevier. Reproduction in any form by anyone of the materials contained
 * herein without the permission of Elsevier is prohibited. Finders are asked to
 * return this document to the following Elsevier location.
 * 
 * Elsevier 360 Park Avenue South, New York, NY 10010-1710
 * 
 * Copyright (c) 2016 by Elsevier, A member of the Reed Elsevier plc group.
 * 
 * All Rights Reserved.
 *****************************************************************************/