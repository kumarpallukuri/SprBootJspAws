package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
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

public class AwsDyanmoDb {
	public static void main(String[] args) {
		AWSCredentials credentials = new BasicAWSCredentials("",
				"");
		// This client will default to US West (Oregon)
		AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials);
		// Modify the client so that it accesses a different region.
		client.withRegion(Regions.US_EAST_1);
		client.setEndpoint("dynamodb.us-east-2.amazonaws.com");
		DynamoDB dynamoDB = new DynamoDB(client);
		Table table = dynamoDB.getTable("WorkersTableTest");
		addItem(table);
		// updateExistingAttributeConditionally(table);
		retrieveItem(table);
		fetchAllItems(table);
		// deleteITem(table);
		ScanRequest scanRequest = new ScanRequest().withTableName("WorkersTableTest");

		ScanResult result = client.scan(scanRequest);
		for (Map<String, AttributeValue> item : result.getItems()) {
			System.out.println(item.get("workertID"));
		}

	}

	private static void addItem(Table table) {
		// Build the item
		Item item = new Item().withPrimaryKey("workertID", 3).withString("workerEmailID", "iks@gmail.com")
				.withString("workerField", "Carpenterd").withString("workerName", "kumarss")
				.withNumber("workerPhoneNumber", 500);
		// Write the item to the table
		PutItemOutcome outcome = table.putItem(item);
	}

	private static void retrieveItem(Table table) {
		try {
			Item item = table.getItem("workertID", 1);
			System.out.println("Printing item after retrieving it....");
			System.out.println(item.toJSONPretty());

		} catch (Exception e) {
			System.err.println("GetItem failed.");
			System.err.println(e.getMessage());
		}

	}

	private static void updateExistingAttributeConditionally(Table table) {
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

	private static void deleteITem(Table table) {
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

	private static void fetchAllItems(Table table) {
		Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
		expressionAttributeValues.put(":pr", 1002);

		ItemCollection<ScanOutcome> items = table.scan("workertID  < :pr", // FilterExpression
				"workertID, workerEmailID, workerField, workerName,workerPhoneNumber", // ProjectionExpression
				null, // ExpressionAttributeNames - not used in this example
				expressionAttributeValues);

		System.out.println("Scan of " + "WorkersTableTest" + " for items with a price less than 2.");
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toJSONPretty());
		}

	}	 

}
