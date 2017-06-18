package com.basic.proto.util;

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

}
