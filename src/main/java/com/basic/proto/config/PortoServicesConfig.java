package com.basic.proto.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;




/**
 * Class holds the configuration for the service 
 *
 */

@Configuration
public class PortoServicesConfig extends WebMvcConfigurerAdapter {
	
	
	/**
	 * Bean for the  filter
	 * @return
	 */
//	@Bean
//	public Filter propertiesFilter() {
//		System.out.println("propertiesFilter ..!");
//		return new RequestFilter();
//	}
//	
//	/**
//	 * Add the beans and the order for Filters
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean registerFilter() {
//		System.out.println("registerFilter ..!");
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		//registration.setFilter(propertiesFilter());
//		registration.setOrder(1);
//		return registration;
//	}
//	

	@Bean
	public TransactionEventCleanupInterceptor cleanUp(){
		System.out.println("cleanUp ..!");
		return new TransactionEventCleanupInterceptor();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/static/**")
	            .setCachePeriod(0);
	}
	
    /**
     * Configure TilesConfigurer.
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
 
    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
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