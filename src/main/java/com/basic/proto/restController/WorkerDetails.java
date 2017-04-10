package com.basic.proto.restController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.basic.proto.aws.service.AwsDyanmoDb;
import com.basic.proto.form.RegistartionDetailsForm;
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
 
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<Workers>> listAllUsers() throws JsonParseException, JsonMappingException, IOException {
        List<Workers> users = userService.fetchAllItems();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        System.out.println(users );
        return new ResponseEntity<List<Workers>>(users, HttpStatus.OK);
    }

}