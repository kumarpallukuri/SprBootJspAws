package com.basic.proto.aws.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

@Service
public class GenerateOTPService {

	@Autowired
	AwsIntializerService awsIntializerService;
	AmazonSNSClient snsClient = null;

	public int generateOTP(String mobileNumber) {
		snsClient = new AmazonSNSClient(awsIntializerService.credentialsForAwsClients());
		snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));
		
		//To do otp generation logic
		int otp = 3311;
		String message = "My SMS message"+otp;
		//To do
		//remove +1 once india number testing done...
		String phoneNumber = "+1"+mobileNumber;
		Map<String, MessageAttributeValue> smsAttributes = new HashMap<String, MessageAttributeValue>();
		sendSMSMessage(snsClient, message, phoneNumber, smsAttributes);
		return otp;
	}

	public static void sendSMSMessage(AmazonSNSClient snsClient, String message, String phoneNumber,
			Map<String, MessageAttributeValue> smsAttributes) {
		PublishResult result = snsClient.publish(new PublishRequest().withMessage(message).withPhoneNumber(phoneNumber)
				.withMessageAttributes(smsAttributes));
		// .withMessageAttributes(smsAttributes);
		System.out.println(result.getMessageId()); // Prints the message ID.
	}

}
