package com.basic.proto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basic.proto.aws.service.WorkerDetailsDataService;
import com.basic.proto.form.LoginDetailsForm;
import com.basic.proto.form.RegistartionDetailsForm;

@Controller
public class RegistartionDetailsController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
//	
	@Autowired
		private WorkerDetailsDataService awsdynamoDb;
	
	@RequestMapping(value ="/registartionSucess")
	public String welcome() throws Exception {
		System.out.println("update / delete page...");
		return "editDeleteDetails";
	}
	
	@RequestMapping(value ="/login")
	public String welcome(@ModelAttribute LoginDetailsForm loginDetailsForm) throws Exception {
		System.out.println("login page...");
			return "login";
	}

}