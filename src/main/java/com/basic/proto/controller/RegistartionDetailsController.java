package com.basic.proto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basic.proto.form.RegistartionDetailsForm;

@Controller
public class RegistartionDetailsController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
//	
//	@Autowired
//	private AwsS3Service s3Service;
	
	@RequestMapping("/registartionSucess")
	public String welcome(@ModelAttribute("registartionDetailsForm") RegistartionDetailsForm registartionDetailsForm,Map<String, Object> model) throws Exception {
		model.put("FirstName", registartionDetailsForm.getFirstName());
		model.put("LastName", registartionDetailsForm.getLastName());
		model.put("EmailAdress", registartionDetailsForm.getEmailAdress());
		model.put("MobileNumber", registartionDetailsForm.getMobileNumber());
		model.put("WorkerType", registartionDetailsForm.getWorkerType());
		model.put("Rate", registartionDetailsForm.getRate());
		//s3Service.test();
		//AmazonSnsTest sns = new AmazonSnsTest();
		//sns.createTopic("Marthon Event");
		//sns.createSNSService(registartionDetailsForm.getEmailAdress(), "MarthonEvent");
		//sns.sendNotification("MarthonEvent");
		return "welcomeTest";
	}

}