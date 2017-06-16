package com.basic.proto.aws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

@Component
public class AwsS3Service {
	 static Logger logger = LoggerFactory.getLogger(AwsS3Service.class);
	@Autowired
	AwsIntializerService awsIntializerService;
	public void test() {
		AmazonS3Client s3Client = new AmazonS3Client(awsIntializerService.credentialsForAwsClients());
		// create bucket - name must be unique for all S3 users
		try {
			for (Bucket bucket : s3Client.listBuckets()) {
				logger.info(" - " + bucket.getName());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

}