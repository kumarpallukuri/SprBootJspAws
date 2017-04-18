package com.basic.proto.aws.service;

import java.io.IOException;
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
			table = dynamoDB.getTable("WorkersTableTest");
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
		Item item = new Item().withPrimaryKey("workertID", 3)
				.withString("workerEmailID", registartionDetailsForm.getEmailAdress())
				.withString("workerField", registartionDetailsForm.getWorkerType())
				.withString("workerName", registartionDetailsForm.getFirstName())
				.withNumber("workerPhoneNumber", registartionDetailsForm.getRate());
		// Write the item to the table
		PutItemOutcome outcome = table.putItem(item);
	}

	public  void retrieveItem() {
		intiliazeTable();
		try {
			Item item = table.getItem("workertID", 1);
			System.out.println("Printing item after retrieving it....");
			System.out.println(item.toJSONPretty());

		} catch (Exception e) {
			System.err.println("GetItem failed.");
			System.err.println(e.getMessage());
		}

	}

	public  void updateExistingAttributeConditionally() {
		intiliazeTable();
		try {
			UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("workerID", "1234")
					.withUpdateExpression("set workerPhoneNumber =  :val")
					.withValueMap(new ValueMap().withNumber(":val", 5)).withReturnValues(ReturnValue.UPDATED_NEW);
			UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
			System.out.println("UpdateItem succeeded:\n" + outcome.getItem().toJSONPretty());

		} catch (Exception e) {
			System.err.println("Error updating item in " + table);
			System.err.println(e.getMessage());
		}
	}

	public  void deleteITem() {
		intiliazeTable();
		try {
			DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey("workerID", "1234")
					.withConditionExpression("workerPhoneNumber <= :val")
					.withValueMap(new ValueMap().withNumber(":val", 5));
			try {
				System.out.println("Attempting a conditional delete...");
				table.deleteItem(deleteItemSpec);
				System.out.println("DeleteItem succeeded");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		} catch (Exception e) {
			System.err.println("Error updating item in " + table);
			System.err.println(e.getMessage());
		}
	}

	public List<Workers> fetchAllItems() throws JsonParseException, JsonMappingException, IOException {
		// This client will default to US West (Oregon)
		intiliazeTable();
		List<Workers> allWorkers = new ArrayList<Workers>();
		Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
		expressionAttributeValues.put(":pr", 1002);

		ItemCollection<ScanOutcome> items = table.scan("workertID  < :pr", // FilterExpression
				"workertID, workerEmailID, workerField, workerName,workerPhoneNumber", // ProjectionExpression
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
