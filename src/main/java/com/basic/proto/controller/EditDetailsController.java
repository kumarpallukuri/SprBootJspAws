package com.basic.proto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basic.proto.aws.service.WorkerDetailsDataService;

@Controller
public class EditDetailsController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	//
	@Autowired
	private WorkerDetailsDataService awsdynamoDb;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/workerDetails/{id}", method = RequestMethod.GET)
	public String welcome(@PathVariable("id") long id) throws Exception {
		logger.info("idddddd");

		return "welcomeTest2";
	}

}