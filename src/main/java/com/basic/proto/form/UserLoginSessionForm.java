package com.basic.proto.form;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserLoginSessionForm {
	
	private boolean isUserLogin;
	
	private boolean isFullProfile;
	
	private boolean isDisplayEdit;
	
	private boolean isAccountActivated;

	/**
	 * @return the isAccountActivated
	 */
	public boolean isAccountActivated() {
		return isAccountActivated;
	}

	/**
	 * @param isAccountActivated the isAccountActivated to set
	 */
	public void setAccountActivated(boolean isAccountActivated) {
		this.isAccountActivated = isAccountActivated;
	}

	/**
	 * @return the isUserLogin
	 */
	public boolean isUserLogin() {
		return isUserLogin;
	}

	/**
	 * @param isUserLogin the isUserLogin to set
	 */
	public void setUserLogin(boolean isUserLogin) {
		this.isUserLogin = isUserLogin;
	}

	/**
	 * @return the isFullProfile
	 */
	public boolean isFullProfile() {
		return isFullProfile;
	}

	/**
	 * @param isFullProfile the isFullProfile to set
	 */
	public void setFullProfile(boolean isFullProfile) {
		this.isFullProfile = isFullProfile;
	}

	/**
	 * @return the isDisplayEdit
	 */
	public boolean isDisplayEdit() {
		return isDisplayEdit;
	}

	/**
	 * @param isDisplayEdit the isDisplayEdit to set
	 */
	public void setDisplayEdit(boolean isDisplayEdit) {
		this.isDisplayEdit = isDisplayEdit;
	}
	
	

}
