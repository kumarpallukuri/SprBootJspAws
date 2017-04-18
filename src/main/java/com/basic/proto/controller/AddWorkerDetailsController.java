package com.basic.proto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.basic.proto.aws.service.AwsDyanmoDb;
import com.basic.proto.form.RegistartionDetailsForm;

@Controller
public class AddWorkerDetailsController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
//	
	@Autowired
		private AwsDyanmoDb awsdynamoDb;
	
	@RequestMapping(value ="/addWorkerDetails")
	public String welcome(@ModelAttribute RegistartionDetailsForm registartionDetailsForm) throws Exception {
		System.out.println("add worker details...");
		//awsdynamoDb.addItem(registartionDetailsForm);
		return "welcome";
	}
	
	@RequestMapping(value ="/addWorkerDetailsValues")
	public ModelAndView addWorkerDetails(@ModelAttribute RegistartionDetailsForm registartionDetailsForm) throws Exception {
		System.out.println("add worker details...");
		//awsdynamoDb.addItem(registartionDetailsForm);
		System.out.println(registartionDetailsForm.getEmailAdress());
		return  new ModelAndView("redirect:/register");
	}
	
	@RequestMapping(value ="/fullWorkerDetail/{id}")
	public String workerDetails(@PathVariable("id") String id) throws Exception {
		System.out.println("add worker details..");
		//awsdynamoDb.addItem(registartionDetailsForm);
		System.out.println(id);
		return  "fullWorkerDetails";
	}

}