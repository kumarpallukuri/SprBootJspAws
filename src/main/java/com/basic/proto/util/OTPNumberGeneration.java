package com.basic.proto.util;

import java.util.Random;


public class OTPNumberGeneration{
	
	public static final int numberGeneration(){
	    //note a single Random object is reused here
	    Random randomGenerator = new Random();
	      int randomInt = randomGenerator.nextInt(10000);
	      log("Generated : " + randomInt);
	    return randomInt;
	  }
	  
	  private static void log(String aMessage){
	    System.out.println(aMessage);
	  }
	
	

}
