package com.basic.proto.aws.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.basic.proto.form.RegistartionDetailsForm;
import com.basic.proto.form.Workers;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WorkerDetailsDataService {

	@Autowired
	AwsIntializerService awsIntializerService;
	
	 AmazonDynamoDBClient client = null;
	 Table table = null;
	 Logger logger = LoggerFactory.getLogger(this.getClass());
	public  void intiliazeTable() {
		if(table == null){
			// This client will default to US West1(Oregon)
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
			logger.info(""+item.get("workertID"));
		}
		// Build the item
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 logger.info("timestamp"+timestamp.getTime());
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
	
	public  void addItemWithWorkerObject( Workers registartionDetailsForm) {
		intiliazeTable();
		ScanRequest scanRequest = new ScanRequest().withTableName("WorkersTableTest");
		ScanResult result = client.scan(scanRequest);
		int lastValue = 0;
		for (Map<String, AttributeValue> item : result.getItems()) {
			logger.info(""+item.get("workertID"));
		}
		// Build the item
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 logger.info(""+timestamp.getTime());
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
				
		// Writee the item to the table
		//workerId (N)	workerAddress (S)	workerAvailablity (S)	workerCity (S)	workerDistrict (S)	
		//workerEmail (S)	workerName (S)	workerPhoneNumber (N)	workerProffession (S)	workerRate (N)	workerState (S)
		PutItemOutcome outcome = table.putItem(item);
	}

	public  Workers retrieveItem(double id) {
		intiliazeTable();
		Workers worker = null;
		try {
			Item item = table.getItem("workerId", id);
			logger.info("Printing item after retrieving it....");
			logger.info(item.toJSONPretty());
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
		ValueMap workerFields = new ValueMap();
		workerFields.withNumber(":phoneNumber", worker.getWorkerPhoneNumber());
		workerFields.withString(":email", worker.getWorkerEmail());
		workerFields.withString(":name", worker.getWorkerName());
		workerFields.withString(":city",worker.getWorkerCity());
		try {
//			UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("workerId", worker.getWorkerId())
//					.withUpdateExpression("set workerPhoneNumber =  :phoneNumber")
////					.withUpdateExpression("set workerEmail =  :email")
////					.withUpdateExpression("set workerName =  :name")
////					.withUpdateExpression("set workerCity =  :city")
//					.withValueMap(workerFieldssd)
//					.withReturnValues(ReturnValue.UPDATED_NEW);
////					.withValueMap(new ValueMap().withString(":email", worker.getWorkerEmail()))
////					.withValueMap(new ValueMap().withString(":name", worker.getWorkerName()))
////					.withValueMap(new ValueMap().withString(":city",worker.getWorkerCity()))
			//UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
		//	System.out.println("UpdateItem succeeded:\n" + outcome.getItem().toJSONPretty());
			Item item = new Item().withPrimaryKey("workerId", worker.getWorkerId())
			.withString("workerEmail", worker.getWorkerEmail())
			.withString("workerProffession", worker.getWorkerProffession())
			.withString("workerName", worker.getWorkerName())
			.withNumber("workerPhoneNumber", worker.getWorkerPhoneNumber())
			.withString("workerAddress", worker.getWorkerAddress())
			.withString("workerDistrict", worker.getWorkerDistrict())
			.withString("workerCity", worker.getWorkerCity())
			.withString("workerState", worker.getWorkerState())
			.withString("workerAvailablity", worker.getWorkerAvailablity())
			.withString("workerRate", worker.getWorkerRate());
			PutItemOutcome outcome = table.putItem(item);
			logger.info("UpdateItem succeeded:\n" + outcome.getItem().toJSONPretty());
		} catch (Exception e) {
			System.err.println("Error updating item in " + table);
			System.err.println(e.getMessage());
		}
	}

	public  void deleteITem(double id,double phoneNumber) {
		// Write the item to the table
		
		intiliazeTable();
		try {
			logger.info("delete sucessfully enter");
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			 logger.info(""+timestamp.getTime());
			DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey("workerId", id)
					.withConditionExpression("workerPhoneNumber <= :val")
					.withValueMap(new ValueMap().withNumber(":val", phoneNumber));
			try {
				logger.info("Attempting a conditional delete...");
				table.deleteItem(deleteItemSpec);
				logger.info("DeleteItem succeeded");
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			logger.info("delete sucessfully");
		} catch (Exception e) {
			logger.info("Error updating item in " + table);
			logger.info(e.getMessage());
		}
	}

	public List<Workers> fetchAllItems() throws JsonParseException, JsonMappingException, IOException {
		// This client will default to US West (Oregon)
		
		intiliazeTable();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 logger.info(""+timestamp.getTime());
		List<Workers> allWorkers = new ArrayList<Workers>();
		Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
		expressionAttributeValues.put(":pr", timestamp.getTime());

		ItemCollection<ScanOutcome> items = table.scan("workerId  < :pr", // FilterExpression
				"workerId, workerEmail, workerProffession, workerName,workerPhoneNumber,"
				+ "workerAddress,workerAvailablity,workerCity,workerDistrict,workerRate,workerState",// ProjectionExpression
				null, // ExpressionAttributeNames - not used in this example
				expressionAttributeValues);
		
		logger.info("Scan of " + "WorkersTableTest" + " for items with a price less than 2.");
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
	
	public List<Workers> filterItems(String filterString) throws JsonParseException, JsonMappingException, IOException {
		// This client will default to US West (Oregon)
		
		intiliazeTable();
		logger.info("filterItems service");
		List<Workers> allWorkers = new ArrayList<Workers>();
		String[] filterValues = filterString.split("_");
	  	Map<String, AttributeValue> expressionAttributeValues = new HashMap<String, AttributeValue>();
	  	String filterDropdwonValue =filterValues[0];
	  	if(filterValues[0].equals("Proffession")){
	  		filterDropdwonValue = "workerProffession";
	  	}else if(filterValues[0].equals("City")){
	  		filterDropdwonValue = "workerCity";
	  	}
		expressionAttributeValues.put(":val", new AttributeValue().withS(filterValues[1]));
	//	ScanRequest scanRequest = new ScanRequest().withTableName("WorkersTableTest");
	//	ScanResult result = client.scan(scanRequest);
		String expressionValue = filterDropdwonValue +" < :val";
		ScanRequest scanRequest = new ScanRequest().withTableName("WorkersTableTest")
				.withFilterExpression(expressionValue).withProjectionExpression("workerId")
				.withExpressionAttributeValues(expressionAttributeValues);

		ScanResult result = client.scan(scanRequest);
		
		Map<String, Object> expressionAttributeValues2 = new HashMap<String, Object>();
        expressionAttributeValues2.put(":pr", filterValues[1]);
        String filterCondition = filterDropdwonValue +" = :pr";
        ItemCollection<ScanOutcome> items = table.scan(
        		filterCondition,
            "workerId, workerEmail, workerName, workerPhoneNumber,workerCity,workerProffession", 
            null, 
            expressionAttributeValues2);
        //"workerId, workerEmail, workerProffession, workerName,workerPhoneNumber,"
	//	+ "workerAddress,workerAvailablity,workerCity,workerDistrict,workerRate,workerState"
        logger.info("Scan of for items with a price less than 100.");
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
           // System.out.println(iterator.next().toJSONPretty());
            ObjectMapper mapper = new ObjectMapper();
			String json = iterator.next().toJSONPretty();
			Workers worker = null;
			worker = new ObjectMapper().readValue(json, Workers.class);
			logger.info("filter json-->"+json);
			allWorkers.add(worker);
        }    
		return allWorkers;
	}
	
	public List<Workers> filterItemsWithProfessionAndCity(String filterString) throws JsonParseException, JsonMappingException, IOException {
		// This client will default to US West (Oregon)
		
		intiliazeTable();
		logger.info("filterItems service");
		List<Workers> allWorkers = new ArrayList<Workers>();
		String[] searchValue = filterString.split("_");
		Map<String, Object> expressionAttributeValues2 = new HashMap<String, Object>();
        expressionAttributeValues2.put(":pr", searchValue[0]);
        expressionAttributeValues2.put(":pr1",searchValue[1]);
        ItemCollection<ScanOutcome> items = table.scan(
        		"workerProffession =:pr AND workerCity =:pr1",
            "workerId, workerEmail, workerName, workerPhoneNumber,workerCity,workerProffession", 
            null, 
            expressionAttributeValues2);
        logger.info("Scan of for items with a price less than 100.");
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            ObjectMapper mapper = new ObjectMapper();
			String json = iterator.next().toJSONPretty();
			Workers worker = null;
			worker = new ObjectMapper().readValue(json, Workers.class);
			logger.info("filter json-->"+json);
			allWorkers.add(worker);
        }    
		return allWorkers;
	}


}
