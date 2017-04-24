package com.basic.proto.aws.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.basic.proto.form.RegistartionDetailsForm;
import com.basic.proto.form.Workers;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AwsDyanmoDb {

	@Autowired
	AwsIntializerService awsIntializerService;
	 AmazonDynamoDBClient client = null;
	 Table table = null;

	public  void intiliazeTable() {
		if(table == null){
			// This client will default to US West (Oregon)
			client = new AmazonDynamoDBClient(awsIntializerService.credentialsForAwsClients());
			// Modify the client so that it accesses a different region.
			client.withRegion(Regions.US_EAST_1);
			client.setEndpoint("dynamodb.us-east-2.amazonaws.com");
			DynamoDB dynamoDB = new DynamoDB(client);
			table = dynamoDB.getTable("WorkersDetails");
		}
	}



	public  void addItem( RegistartionDetailsForm registartionDetailsForm) {
		intiliazeTable();
		ScanRequest scanRequest = new ScanRequest().withTableName("WorkersTableTest");
		ScanResult result = client.scan(scanRequest);
		int lastValue = 0;
		for (Map<String, AttributeValue> item : result.getItems()) {
			System.out.println(item.get("workertID"));
		}
		// Build the item
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 System.out.println(timestamp.getTime());
		Item item = new Item().withPrimaryKey("workerId", timestamp.getTime())
				.withString("workerEmail", registartionDetailsForm.getWorkerEmail())
				.withString("workerProffession", registartionDetailsForm.getWorkerProffession())
				.withString("workerName", registartionDetailsForm.getWorkerName())
				.withNumber("workerPhoneNumber", registartionDetailsForm.getWorkerPhoneNumber())
				.withString("workerAddress", registartionDetailsForm.getWorkerAddress())
				.withString("workerDistrict", registartionDetailsForm.getWorkerDistrict())
				.withString("workerCity", registartionDetailsForm.getWorkerCity())
				.withString("workerState", registartionDetailsForm.getWorkerState())
				.withString("workerAvailablity", registartionDetailsForm.getWorkerAvailablity())
				.withString("workerRate", registartionDetailsForm.getWorkerRate());
				
		// Write the item to the table
		//workerId (N)	workerAddress (S)	workerAvailablity (S)	workerCity (S)	workerDistrict (S)	
		//workerEmail (S)	workerName (S)	workerPhoneNumber (N)	workerProffession (S)	workerRate (N)	workerState (S)
		PutItemOutcome outcome = table.putItem(item);
	}

	public  Workers retrieveItem(double id) {
		intiliazeTable();
		Workers worker = null;
		try {
			Item item = table.getItem("workerId", id);
			System.out.println("Printing item after retrieving it....");
			System.out.println(item.toJSONPretty());
			ObjectMapper mapper = new ObjectMapper();
			worker = new ObjectMapper().readValue(item.toJSONPretty(), Workers.class);
		} catch (Exception e) {
			System.err.println("GetItem failed.");
			System.err.println(e.getMessage());
		}
		return worker;
	}

	public  void updateExistingAttributeConditionally(Workers worker) {
		//workerId (N)	workerAddress (S)	workerAvailablity (S)	workerCity (S)	workerDistrict (S)	
		//workerEmail (S)	workerName (S)	workerPhoneNumber (N)	workerProffession (S)	workerRate (N)	workerState (S)
		intiliazeTable();
		try {
			UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("workerId", worker.getWorkerId())
					.withUpdateExpression("set workerPhoneNumber =  :phoneNumber")
					.withUpdateExpression("set workerEmail =  :email")
					.withUpdateExpression("set workerName =  :name")
					.withUpdateExpression("set workerCity =  :city")
					.withValueMap(new ValueMap().withNumber(":phoneNumber", worker.getWorkerPhoneNumber()))
					.withValueMap(new ValueMap().withString(":email", worker.getWorkerEmail()))
					.withValueMap(new ValueMap().withString(":name", worker.getWorkerName()))
					.withValueMap(new ValueMap().withString(":city",worker.getWorkerCity()))
					.withReturnValues(ReturnValue.UPDATED_NEW);
			UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
			System.out.println("UpdateItem succeeded:\n" + outcome.getItem().toJSONPretty());

		} catch (Exception e) {
			System.err.println("Error updating item in " + table);
			System.err.println(e.getMessage());
		}
	}

	public  void deleteITem(double id,double phoneNumber) {
		// Write the item to the table
		
		intiliazeTable();
		try {
			System.out.println("delete sucessfully enter");
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			 System.out.println(timestamp.getTime());
			DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey("workerId", id)
					.withConditionExpression("workerPhoneNumber <= :val")
					.withValueMap(new ValueMap().withNumber(":val", phoneNumber));
			try {
				System.out.println("Attempting a conditional delete...");
				table.deleteItem(deleteItemSpec);
				System.out.println("DeleteItem succeeded");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println("delete sucessfully");
		} catch (Exception e) {
			System.err.println("Error updating item in " + table);
			System.err.println(e.getMessage());
		}
	}

	public List<Workers> fetchAllItems() throws JsonParseException, JsonMappingException, IOException {
		// This client will default to US West (Oregon)
		
		intiliazeTable();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 System.out.println(timestamp.getTime());
		List<Workers> allWorkers = new ArrayList<Workers>();
		Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
		expressionAttributeValues.put(":pr", timestamp.getTime());

		ItemCollection<ScanOutcome> items = table.scan("workerId  < :pr", // FilterExpression
				"workerId, workerEmail, workerProffession, workerName,workerPhoneNumber,"
				+ "workerAddress,workerAvailablity,workerCity,workerDistrict,workerRate,workerState",// ProjectionExpression
				null, // ExpressionAttributeNames - not used in this example
				expressionAttributeValues);
		
		System.out.println("Scan of " + "WorkersTableTest" + " for items with a price less than 2.");
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
			ObjectMapper mapper = new ObjectMapper();
			String json = iterator.next().toJSONPretty();
			Workers worker = null;
			worker = new ObjectMapper().readValue(json, Workers.class);
			allWorkers.add(worker);
			// Workers staff1 = null;
			// staff1 = mapper.readValue(iterator.next().toJSONPretty(),
			// Workers.class);
			// allWorkers.add(staff1);
		}

		return allWorkers;

	}

}
