package com.basic.proto.form;

public class LoginCodeForm {
	
	private int otp;
	
	private long workerId;
	
	private long generatedTime;

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