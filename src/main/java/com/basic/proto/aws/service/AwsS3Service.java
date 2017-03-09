package com.basic.proto.aws.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

@Component
public class AwsS3Service {

	@Value("${cloud.aws.credentials.accessKey}")
	private String accessKey;

	@Value("${cloud.aws.credentials.secretKey}")
	private String secretKey;

	public void test() {
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		AmazonS3Client s3Client = new AmazonS3Client(credentials);
		// create bucket - name must be unique for all S3 users
		try {
			for (Bucket bucket : s3Client.listBuckets()) {
				System.out.println(" - " + bucket.getName());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}