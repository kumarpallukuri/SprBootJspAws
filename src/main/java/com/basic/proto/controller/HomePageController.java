package com.basic.proto.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basic.proto.form.RegistartionDetailsForm;
import com.basic.proto.form.UserLoginSessionForm;

@Controller
public class HomePageController {

	// inject g application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	

	@Autowired
	UserLoginSessionForm userLoginSessionForm;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/register")
	public String welcome() {
		//model.put("message", this.message);
		logger.info("welcome method");
		return "register";
	}
	
	@RequestMapping("/home")
	public String welcome1(@ModelAttribute("registartionDetailsForm") RegistartionDetailsForm registartionDetailsForm,
			Map<String, Object> model) {
		model.put("message", this.message);
		return "home";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/forgotPassword")
	public String forgotPass() {
		return "forgotPass";
	}

}