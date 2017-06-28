package com.basic.proto.util;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppUtil {
	/** Get the logger **/
	static Logger logger = (Logger) LoggerFactory.getLogger(AppUtil.class);
	public static String maskPhoneNumber(long phoneNumber){
		String phoneNum = Long.toString(phoneNumber);
		String maskPhoneNumber = phoneNum.replace(phoneNum.substring(0, 7), "XXXXXXX");
		logger.info("maskPhoneNumber" + maskPhoneNumber);
		return maskPhoneNumber;
		
	}
	public static boolean otpVerifiedInTime(Date generatedTime){
		boolean isOTPVerifiedInTime = true;
		Date currentTime = new Date(System.currentTimeMillis());
		long diffMs = currentTime.getTime() - generatedTime.getTime() ;
		long diffSec = diffMs / 1000;
		long min = diffSec / 60;
		logger.info("The difference is " + min + " minutes");
		if(min > 10){
			isOTPVerifiedInTime = false;
		}
		return isOTPVerifiedInTime;
	}

}
