package com.basic.proto.aws.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.basic.proto.form.LoginDetailsForm;
import com.basic.proto.form.RegistartionDetailsForm;

@Component
public class LoginDetailsDataService {
	
	@Autowired
	AwsIntializerService awsIntializerService;
	 AmazonDynamoDBClient client = null;
	 Table table = null;

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
	
	public  void addItem( LoginDetailsForm loginDetailsForm) {
		intiliazeTable();
//		ScanRequest scanRequest = new ScanRequest().withTableName("WorkersTableTest");
//		ScanResult result = client.scan(scanRequest);
//		int lastValue = 0;
//		for (Map<String, AttributeValue> item : result.getItems()) {
//			System.out.println(item.get("workertID"));
//		}
		// Build the item
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 System.out.println(timestamp.getTime());
		Item item = new Item().withPrimaryKey("workerId", timestamp.getTime())
				.withString("password", loginDetailsForm.getPassword())
				.withString("userName", loginDetailsForm.getUserName())
				.withNumber("phoneNumber", loginDetailsForm.getPhoneNumber())
				.withString("workerName", loginDetailsForm.getWorkerName())
				.withString("fullProfile", loginDetailsForm.getFullProfile());
				
		// Write the item to the table
		//workerId (N)	workerAddress (S)	workerAvailablity (S)	workerCity (S)	workerDistrict (S)	
		//workerEmail (S)	workerName (S)	workerPhoneNumber (N)	workerProffession (S)	workerRate (N)	workerState (S)
		PutItemOutcome outcome = table.putItem(item);
	}

}
