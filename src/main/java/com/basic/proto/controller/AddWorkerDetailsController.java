package com.basic.proto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.basic.proto.aws.service.AwsDyanmoDb;
import com.basic.proto.form.RegistartionDetailsForm;
import com.basic.proto.form.Workers;

@Controller
public class AddWorkerDetailsController {
	// Writte the item to the table
	// workerId (N) workerAddress (S) workerAvailablity (S) workerCity (S)
	// workerDistrict (S)
	// workerEmail (S) workerName (S) workerPhoneNumber (N) workerProffession
	// (S) workerRate (N) workerState (S)
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	//
	@Autowired
	private AwsDyanmoDb awsdynamoDb;

	@RequestMapping(value = "/addWorkerDetails")
	public String welcome(@ModelAttribute RegistartionDetailsForm registartionDetailsForm) throws Exception {
		System.out.println("add worker details...");
		// awsdynamoDb.addItem(registartionDetailsForm);
		return "details/addDetails";
	}

	@RequestMapping(value = "/addWorkerDetailsValues")
	public ModelAndView addWorkerDetails(@ModelAttribute RegistartionDetailsForm registartionDetailsForm)
			throws Exception {
		System.out.println("add worker details...");
		awsdynamoDb.addItem(registartionDetailsForm);
		System.out.println(registartionDetailsForm.getWorkerEmail());
		return new ModelAndView("redirect:/register");
	}

	@RequestMapping(value = "/fullWorkerDetail/{id}")
	public String workerDetails(@PathVariable("id") String id, Map<String, Object> model) throws Exception {
		System.out.println("add worker detailszz.." + id + "ff");
		double idValue = Double.parseDouble(id);
		Workers worker = awsdynamoDb.retrieveItem(idValue);
		model.put("workerPhoneNumber", worker.getWorkerPhoneNumber());
		model.put("workerProffession", worker.getWorkerProffession());
		model.put("workerEmail", worker.getWorkerEmail());
		model.put("workerAddress", worker.getWorkerAddress());
		model.put("workerCity", worker.getWorkerCity());
		model.put("workerAvailablity", worker.getWorkerAvailablity());
		model.put("workerDistrict", worker.getWorkerDistrict());
		model.put("workerName", worker.getWorkerName());
		model.put("workerRate", worker.getWorkerRate());
		model.put("workerState", worker.getWorkerState());

		return "details/personalworkerInfo";
	}
	
	@RequestMapping(value = "/editDetails/{id}")
	public String editWorkerDetails(@PathVariable("id") String id, Map<String, Object> model) throws Exception {
		System.out.println("add worker detailszz.." + id + "ff");
		double idValue = Double.parseDouble(id);
		Workers worker = awsdynamoDb.retrieveItem(idValue);
		model.put("workerPhoneNumber", worker.getWorkerPhoneNumber());
		model.put("workerProffession", worker.getWorkerProffession());
		model.put("workerEmail", worker.getWorkerEmail());
		model.put("workerAddress", worker.getWorkerAddress());
		model.put("workerCity", worker.getWorkerCity());
		model.put("workerAvailablity", worker.getWorkerAvailablity());
		model.put("workerDistrict", worker.getWorkerDistrict());
		model.put("workerName", worker.getWorkerName());
		model.put("workerRate", worker.getWorkerRate());
		model.put("workerState", worker.getWorkerState());

		return "details/editDetails";
	}
}