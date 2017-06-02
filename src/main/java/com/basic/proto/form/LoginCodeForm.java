package com.basic.proto.form;

public class LoginCodeForm {
	
	private int otp;
	
	private long workerId;
	
	private long generatedTime;
	
	private long phoneNumber;
	
	private String userName;
	
	
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the otp
	 */
	public int getOtp() {
		return otp;
	}

	/**
	 * @param otp the otp to set
	 */
	public void setOtp(int otp) {
		this.otp = otp;
	}

	/**
	 * @return the workerId
	 */
	public long getWorkerId() {
		return workerId;
	}

	/**
	 * @param workerId the workerId to set
	 */
	public void setWorkerId(long workerId) {
		this.workerId = workerId;
	}

	/**
	 * @return the generatedTime
	 */
	public long getGeneratedTime() {
		return generatedTime;
	}

	/**
	 * @param generatedTime the generatedTime to set
	 */
	public void setGeneratedTime(long generatedTime) {
		this.generatedTime = generatedTime;
	}
	
	

}
