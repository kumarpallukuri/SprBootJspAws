package com.basic.proto.aws.service;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
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

	public AmazonSnsTest() {
		// TODO Auto-generated constructor stub
		AWSCredentials credentials = new BasicAWSCredentials("3KI3I7ZK6FRD6T4TXBW3",
				"3J+NCv8bno/WP9evvtCybSIB4H1DIIzfPJRBDnMf");

		// create a client connection based on credentials
		snsService = new AmazonSNSClient(credentials);
	}

	public void createSNSService(String emailId, String topicName) throws Exception {
		System.out.println(topicName);
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
		System.out.println("In send");

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
	 System.out.println("In create");
	
	 // AmazonSNS
	 if (snsService == null)
	 System.out.println("AKSDAKJDKAJSDKAJSDKAJDKASSJDKASSJD");
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

		System.out.println("Topics: " + topics);

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
