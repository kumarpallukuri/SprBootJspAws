package com.basic.proto.aws.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.basic.proto.form.LoginDetailsForm;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LoginDetailsDataService {
	
	@Autowired
	AwsIntializerService awsIntializerService;
	 AmazonDynamoDBClient client = null;
	 Table table = null;
	 Logger logger = LoggerFactory.getLogger(this.getClass());
	public  void intiliazeTable() {
		if(table == null){
			// This client will default to US West1(Oregon)
			client = new AmazonDynamoDBClient(awsIntializerService.credentialsForAwsClients());
			// Modify the client so that it accesses a different regionn.
			client.withRegion(Regions.US_EAST_1);
			client.setEndpoint("dynamodb.us-east-2.amazonaws.com");
			DynamoDB dynamoDB = new DynamoDB(client);
			table = dynamoDB.getTable("Workersregistration");
		}
	}
	
	public  long addItem( LoginDetailsForm loginDetailsForm) {
		intiliazeTable();
		loginDetailsForm.setFullProfile("no");
		// Build the item
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 long workerId = timestamp.getTime();
		Item item = new Item().withPrimaryKey("workerId", workerId)
				.withString("password", loginDetailsForm.getPassword())
				.withString("userName", loginDetailsForm.getUserName())
				.withNumber("phoneNumber", loginDetailsForm.getPhoneNumber())
				.withString("workerName", loginDetailsForm.getWorkerName())
				.withString("fullProfile", loginDetailsForm.getFullProfile());
				
		// Write the item to the table
		//workerId (N)	workerAddress (S)	workerAvailablity (S)	workerCity (S)	workerDistrict (S)	
		//workerEmail (S)	workerName (S)	workerPhoneNumber (N)	workerProffession (S)	workerRate (N)	workerState (S)
		PutItemOutcome outcome = table.putItem(item);
		return workerId;
	}
	

	public LoginDetailsForm getUserDetails(String userName) throws JsonParseException, JsonMappingException, IOException {
		// This client will default to US West (Oregon)
		
		intiliazeTable();
		logger.info("filterItems service");
		//String[] filterValues = filterString.split("_");
	  	Map<String, AttributeValue> expressionAttributeValues = new HashMap<String, AttributeValue>();
		expressionAttributeValues.put(":val", new AttributeValue().withS(userName));
	//	ScanRequest scanRequest = new ScanRequest().withTableName("WorkersTableTest");
	//	ScanResult result = client.scan(scanRequest);
		String expressionValue = "userName" +" < :val";
		ScanRequest scanRequest = new ScanRequest().withTableName("Workersregistration")
				.withFilterExpression(expressionValue).withProjectionExpression("workerId")
				.withExpressionAttributeValues(expressionAttributeValues);

		ScanResult result = client.scan(scanRequest);
		
		Map<String, Object> expressionAttributeValues2 = new HashMap<String, Object>();
        expressionAttributeValues2.put(":pr", userName);
        String filterCondition = "userName" +" = :pr";
        ItemCollection<ScanOutcome> items = table.scan(
        		filterCondition,
            "workerId, password, userName, phoneNumber,workerName,fullProfile", 
            null, 
            expressionAttributeValues2);
        logger.info("Scan of for items with a price less than 100.");
        LoginDetailsForm loginDetailsForm = null;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
           // System.out.println(iterator.next().toJSONPretty());
            ObjectMapper mapper = new ObjectMapper();
			String json = iterator.next().toJSONPretty();
			loginDetailsForm = new ObjectMapper().readValue(json, LoginDetailsForm.class);
			logger.info("filter json-->"+json);
        }    
		return loginDetailsForm;
	}

}
