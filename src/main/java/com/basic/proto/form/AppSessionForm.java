package com.basic.proto.form;

import java.io.Serializable;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class AppSessionForm implements Serializable{
	
	private Map<String, LoginCodeForm> usersLoginCodes;

	/**
	 * @return the usersLoginCodes
	 */
	public Map<String, LoginCodeForm> getUsersLoginCodes() {
		return usersLoginCodes;
	}

	/**
	 * @param usersLoginCodes the usersLoginCodes to set
	 */
	public void setUsersLoginCodes(Map<String, LoginCodeForm> usersLoginCodes) {
		this.usersLoginCodes = usersLoginCodes;
	}
	
	

}
