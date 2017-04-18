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
//		model.put("FirstNames", registartionDetailsForm.getFirstName());
//		model.put("LastNames", registartionDetailsForm.getLastName());
//		model.put("EmailAdress", registartionDetailsForm.getEmailAdress());
//		model.put("MobileNumber", registartionDetailsForm.getMobileNumber());
//		model.put("WorkerType", registartionDetailsForm.getWorkerType());
//		model.put("Rate", registartionDetailsForm.getRate());
//		//s3Service.test();
//		//AmazonSnsTest sns = new AmazonSnsTest();
//		//sns.createTopic("Marthon Event");
//		//sns.createSNSService(registartionDetailsForm.getEmailAdress(), "MarthonEvent");
//		//sns.sendNotification("MarthonEvent");
//		awsdynamoDb.detailsAdd(registartionDetailsForm);
	//	awsdynamoDb.fetchAllItems();
		System.out.println("testtttt...");
		return "welcomeTest";
	}

}