package com.basic.proto.restController;

import java.io.IOException;
import java.util.List;

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

import com.basic.proto.aws.service.AwsDyanmoDb;
import com.basic.proto.form.Workers;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class WorkerDetails {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	
	

	@Autowired
	AwsDyanmoDb userService; //Service which will do all data retrieval/manipulation work
 
    // -------------------Retrieve All Users---------------------------------------------
	
	@RequestMapping(value = "/workerDetail", method = RequestMethod.POST)	
	public  ResponseEntity<List<Workers>>  updateDetails( @RequestBody Workers workers ) throws JsonParseException, JsonMappingException, IOException   {		
		//
		// Code processing the input parameters
		System.out.println(workers.getWorkerName());
		System.out.println(workers.getWorkerEmailID());
		//	
		List<Workers> users = userService.fetchAllItems();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        System.out.println(users );
        return new ResponseEntity<List<Workers>>(users, HttpStatus.OK);
	}
    @RequestMapping(value = "/workerDetails", method = RequestMethod.GET)
    public ResponseEntity<List<Workers>> listAllWorkers() throws JsonParseException, JsonMappingException, IOException {
        List<Workers> users = userService.fetchAllItems();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        System.out.println(users );
        return new ResponseEntity<List<Workers>>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "/workerDetailRemove/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Workers>> eidtWorkerDetails(@PathVariable("id") double id,@PathVariable("id") String workerName) throws JsonParseException, JsonMappingException, IOException {
    	System.out.println("idss -->"+id);
    	System.out.println("workerName -->"+workerName);
    	userService.deleteITem(id);
        List<Workers> users = userService.fetchAllItems();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        System.out.println(users );
        return new ResponseEntity<List<Workers>>(users, HttpStatus.OK);
    }

}