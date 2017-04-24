package com.basic.proto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basic.proto.aws.service.AwsDyanmoDb;

@Controller
public class RegistartionDetailsController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
//	
	@Autowired
		private AwsDyanmoDb awsdynamoDb;
	
	@RequestMapping(value ="/registartionSucess")
	public String welcome() throws Exception {
		System.out.println("update / delete page...");
		return "editDeleteDetails/workerEditDelete";
	}

}