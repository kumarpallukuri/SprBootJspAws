package com.basic.proto.aws.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

@Component
public class AwsIntializerService {
	
	@Value("${cloud.aws.credentials.accessKey}")
	private String accessKey;

	@Value("${cloud.aws.credentials.secretKey}")
	private String secretKey;
	
	//
	public AWSCredentials credentialsForAwsClients(){
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		return credentials;
	}

}
