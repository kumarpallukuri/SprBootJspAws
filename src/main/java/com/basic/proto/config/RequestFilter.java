package com.basic.proto.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;



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
		System.out.println("do filter...!");
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//No transaction needed
		System.out.println("do init...!");
	}
	
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//do nothing
		System.out.println("do destroy...!");
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