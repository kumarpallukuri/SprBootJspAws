package com.basic.proto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basic.proto.form.RegistartionDetailsForm;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	
	

	@RequestMapping("/register")
	public String welcome(@ModelAttribute("registartionDetailsForm") RegistartionDetailsForm registartionDetailsForm,Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

}