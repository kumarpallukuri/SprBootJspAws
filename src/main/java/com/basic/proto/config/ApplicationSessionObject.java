package com.basic.proto.config;

import com.basic.proto.form.AppSessionForm;

public class ApplicationSessionObject {
	private static AppSessionForm appSessionForm = null;
	public static synchronized AppSessionForm getApplicationSessionObject(){
		if(appSessionForm == null){   
			appSessionForm = new  AppSessionForm();
			//appSessionForm.
		}
		return appSessionForm;
		
	}

}
