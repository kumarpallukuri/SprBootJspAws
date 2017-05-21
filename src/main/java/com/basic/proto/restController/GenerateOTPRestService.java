package com.basic.proto.restController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.basic.proto.aws.service.WorkerDetailsDataService;
import com.basic.proto.form.Workers;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class GenerateOTPRestService {

    //Todo this service is useful for mobile app
    @RequestMapping(value = "/generateOTPMob/{mobileNumber}", method = RequestMethod.GET)
    public  ResponseEntity<Integer> generateOTPRestService(@PathVariable("mobileNumber") String mobileNumber) throws JsonParseException, JsonMappingException, IOException {
    	int otp = 1233;
        return new ResponseEntity<Integer>(otp, HttpStatus.OK);
    }

}