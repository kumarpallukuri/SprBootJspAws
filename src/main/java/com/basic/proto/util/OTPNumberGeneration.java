package com.basic.proto.util;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OTPNumberGeneration{
	static Logger logger = LoggerFactory.getLogger(OTPNumberGeneration.class);
	public static final int numberGeneration(){
	    //note a single Random object is reused here
	    Random randomGenerator = new Random();
	      int randomInt = randomGenerator.nextInt(10000);
	      log("Generated : " + randomInt);
	    return randomInt;
	  }
	  
	  private static void log(String aMessage){
		  logger.info(aMessage);
	  }
	
	

}
