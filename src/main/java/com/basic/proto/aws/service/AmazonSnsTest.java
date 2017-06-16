package com.basic.proto.aws.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.ListTopicsRequest;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.services.sns.model.Topic;

public class AmazonSnsTest {
	AmazonSNS snsService;
	 static Logger logger = LoggerFactory.getLogger(AmazonSnsTest.class);
	@Autowired
	AwsIntializerService awsIntializerService;
	public AmazonSnsTest() {
		// TODO Auto-generated constructor stub

		// create a client connection based on credentials
		snsService = new AmazonSNSClient(awsIntializerService.credentialsForAwsClients());
	}

	public void createSNSService(String emailId, String topicName) throws Exception {
		logger.info(topicName);
		try {
			
			List<Topic> topics = listTopics();
			// Subscribe to the topic selected
			for (Topic topic : topics) {
				if (topic.getTopicArn().endsWith(topicName)) {
					SubscribeResult sr = snsService
							.subscribe(new SubscribeRequest(topic.getTopicArn(), "email", emailId));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public  void sendNotification(String topicName) {
		logger.info("In send");

		List<Topic> topics = listTopics();
		// Subscribe to the topic selected
		for (Topic topic : topics) {
			if (topic.getTopicArn().endsWith(topicName)) {
				snsService.publish(new PublishRequest(topic.getTopicArn(),
						"New Notification!Test  " + topic.getTopicArn()));
				//snsService.publish(arg0, arg1)
			}
		}
	}

	 public void createTopic(String topicName) {
		 logger.info("In create");
	
	 // AmazonSNS
	 if (snsService == null)
		 logger.info("AKSDAKJDKAJSDKAJSDKAJDKASSJDKASSJD");
	 // Create a topic
	 CreateTopicRequest createReq = new
	 CreateTopicRequest().withName(topicName);
	 CreateTopicResult createRes = snsService.createTopic(createReq);
	 }

	public List<Topic> listTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		String nextToken = null;

		do {

			// create the request, with nextToken if not empty
			ListTopicsRequest request = new ListTopicsRequest();
			if (nextToken != null)
				request = request.withNextToken(nextToken);

			// call the web service
			ListTopicsResult result = snsService.listTopics(request);

			nextToken = result.getNextToken();

			// get that list of topics
			topics.addAll(result.getTopics());

			// go on if there are more elements
		} while (nextToken != null);

		logger.info("Topics: " + topics);

		// show the list of topics...

		return topics;
	}

//	public static void main(String[] args) throws Exception {
//		AmazonSnsTest amazonSnsTest = new AmazonSnsTest();
//		//amazonSnsTest.createTopic("FirstTest");
//		amazonSnsTest.listTopics();
//		//amazonSnsTest.createSNSService("ksware03@gmail.com", "FirstTest");
//		amazonSnsTest.sendNotification("FirstTest");
//		
//	}
}
