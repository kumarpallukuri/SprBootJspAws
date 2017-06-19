package com.basic.proto.restController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.basic.proto.aws.service.WorkerDetailsDataService;
import com.basic.proto.form.UserLoginSessionForm;
import com.basic.proto.form.Workers;
import com.basic.proto.util.AppUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class WorkerDetailsRestService {

	static Logger logger = (Logger) LoggerFactory.getLogger(WorkerDetailsRestService.class);
	// injectt vii application.propertiess
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@Autowired
	UserLoginSessionForm userLoginSessionForm;

	@Autowired
	WorkerDetailsDataService workersService; // Service hich will do all data
												// retrieval/manipulation worker

	// -------------------Retrieve All
	// workers---------------------------------------------

	@RequestMapping(value = "/addworkerDetail", method = RequestMethod.POST)
	public ResponseEntity<List<Workers>> addWorkerDetails(@RequestBody Workers worker)
			throws JsonParseException, JsonMappingException, IOException {
		//
		// Code processing the input parameters
		logger.info(worker.getWorkerName());
		logger.info(worker.getWorkerEmail());
		workersService.addItemWithWorkerObject(worker);
		List<Workers> workers = workersService.fetchAllItems();
		if (workers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		logger.info("response result from db" + workers);
		return new ResponseEntity<List<Workers>>(workers, HttpStatus.OK);
	}

	@RequestMapping(value = "/workerDetail", method = RequestMethod.POST)
	public ResponseEntity<List<Workers>> updateDetails(@RequestBody Workers worker)
			throws JsonParseException, JsonMappingException, IOException {
		//
		// Code processing the input parameters
		logger.info(worker.getWorkerName());
		logger.info(worker.getWorkerEmail());
		workersService.updateExistingAttributeConditionally(worker);
		List<Workers> workers = workersService.fetchAllItems();
		if (workers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		logger.info("response result from db" + workers);
		return new ResponseEntity<List<Workers>>(workers, HttpStatus.OK);
	}

	@RequestMapping(value = "/workerDetails", method = RequestMethod.GET)
	public ResponseEntity<List<Workers>> listAllWorkers() throws JsonParseException, JsonMappingException, IOException {
		List<Workers> workers = workersService.fetchAllItems();
		if (workers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		for (Workers worker : workers) {
			if (!userLoginSessionForm.isUserLogin()) {
				worker.setPhoneNumberToDisplay(AppUtil.maskPhoneNumber(worker.getWorkerPhoneNumber()));
			} else {
				worker.setPhoneNumberToDisplay(Long.toString(worker.getWorkerPhoneNumber()));
			}
		}
		logger.info("response result from db" + workers);
		return new ResponseEntity<List<Workers>>(workers, HttpStatus.OK);
	}

	@RequestMapping(value = "/workerDetailRemove/{id}/{phoneNumber}", method = RequestMethod.GET)
	public ResponseEntity<List<Workers>> removeWorkerDetails(@PathVariable("id") long id,
			@PathVariable("phoneNumber") long phoneNumber)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("idss -->" + id);
		logger.info("phoneNumber -->" + phoneNumber);
		workersService.deleteITem(id, phoneNumber);
		List<Workers> workers = workersService.fetchAllItems();
		if (workers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		
		logger.info("response result from db" + workers);
		return new ResponseEntity<List<Workers>>(workers, HttpStatus.OK);
	}

	@RequestMapping(value = "/filterDetails/{filterString}", method = RequestMethod.GET)
	public ResponseEntity<List<Workers>> filterWorkerDetails(@PathVariable("filterString") String filterString)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("filterDetails -->");
		List<Workers> workers = workersService.filterItems(filterString);
		if (workers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		for (Workers worker : workers) {
			if (!userLoginSessionForm.isUserLogin()) {
				worker.setPhoneNumberToDisplay(AppUtil.maskPhoneNumber(worker.getWorkerPhoneNumber()));
			} else {
				worker.setPhoneNumberToDisplay(Long.toString(worker.getWorkerPhoneNumber()));
			}
		}
		logger.info("response result from db" + workers);
		return new ResponseEntity<List<Workers>>(workers, HttpStatus.OK);
	}

	@RequestMapping(value = "/homeFilterDetails/{filterString}", method = RequestMethod.GET)
	public ModelAndView filterWorkerDetailsForHomeSearch(
			@PathVariable("filterString") String filterString)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("filterDetails -->");
		List<Workers> workers = workersService.filterItemsWithProfessionAndCity(filterString);
		
		ModelAndView mv = new ModelAndView();
		if (workers.isEmpty()) {
			//return new ResponseEntity(HttpStatus.NO_CONTENT);
			mv.setViewName("home");
			mv.addObject("SearchReturnedNoResults",true);
			return mv;
		}

		for (Workers worker : workers) {
			if (!userLoginSessionForm.isUserLogin()) {
				worker.setPhoneNumberToDisplay(AppUtil.maskPhoneNumber(worker.getWorkerPhoneNumber()));
			} else {
				worker.setPhoneNumberToDisplay(Long.toString(worker.getWorkerPhoneNumber()));
			}
		}
		logger.info("response result from db" + workers);
		mv.setViewName("workerResults");
		mv.addObject("workers", workers);
		return mv;
		//return new ResponseEntity<List<Workers>>(workers, HttpStatus.OK);
	}

}