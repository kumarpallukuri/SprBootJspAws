package com.basic.proto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basic.proto.aws.service.AwsDyanmoDb;
import com.basic.proto.form.RegistartionDetailsForm;

@Controller
public class EditDetailsController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	//
	@Autowired
	private AwsDyanmoDb awsdynamoDb;

	@RequestMapping(value = "/workerDetails/{id}", method = RequestMethod.GET)
	public String welcome(@PathVariable("id") long id) throws Exception {
		System.out.println("idddddd");

		return "welcomeTest2";
	}

}