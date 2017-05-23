package com.basic.proto.form;

import org.springframework.stereotype.Component;

@Component
public class LoginDetailsForm {
	
	private long workerId;
	
	private String emailID;
	
	private String fullProfile;
	
	private String password;
	
	private long phoneNumber;
	
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

	private String userName;

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
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * @param emailID the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	/**
	 * @return the fullProfile
	 */
	public String getFullProfile() {
		return fullProfile;
	}

	/**
	 * @param fullProfile the fullProfile to set
	 */
	public void setFullProfile(String fullProfile) {
		this.fullProfile = fullProfile;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

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
	
	

}