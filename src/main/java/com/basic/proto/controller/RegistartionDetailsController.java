package com.basic.proto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.Request;
import com.basic.proto.aws.service.GenerateOTPService;
import com.basic.proto.aws.service.LoginDetailsDataService;
import com.basic.proto.form.LoginDetailsForm;
import com.basic.proto.form.UserLoginSessionForm;

@Controller
public class RegistartionDetailsController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	@Autowired
	UserLoginSessionForm userLoginSessionForm;
//	
	@Autowired
		private GenerateOTPService generateOTPService;
	@Autowired
	private LoginDetailsDataService loginDetailsDataService;
	
	@RequestMapping(value ="/registartionSucess")
	public String welcome() throws Exception {
		System.out.println("update / delete page...");
		return "editDeleteDetails";
	}
	
	@RequestMapping(value ="/login")
	public String userLogin(@ModelAttribute LoginDetailsForm loginDetailsForm,@RequestParam( value = "firstLogin" , required = false) String firstLogin,HttpServletRequest request) throws Exception {
		System.out.println("login page...");
//		HttpSession httpSession = request.getSession();
//		if((loginDetailsForm.getUserName().equals("SuperUser")) &&
//				(loginDetailsForm.getPassword().equals("Superappforever"))){
//			userLoginSessionForm.setDisplayEdit(true);
//		}
//		userLoginSessionForm.setUserLogin(true);
//		httpSession.setAttribute("userLoginSessionForm", userLoginSessionForm);
		if(firstLogin != null && !"".equals(firstLogin)){
			if(firstLogin.equals("true")){
				request.setAttribute("otpRequired",true);
			}
		}
			return "login";
	}
	
	@RequestMapping(value ="/registerUser")
	@ResponseBody
	public String register(@RequestBody LoginDetailsForm loginDetailsForm,HttpServletRequest request) throws Exception {
		System.out.println("login page..."+loginDetailsForm.getPhoneNumber());
		//int otp = generateOTPService.generateOTP(Long.toString(loginDetailsForm.getPhoneNumber()));
		//loginDetailsDataService.addItem(loginDetailsForm);
		//return "login";
		String otp = "234";
		return otp;
	}
	
	@RequestMapping(value ="/generateOTP/{mobileNumber}")
	public void generateOTP(@PathVariable("mobileNumber") String mobileNumber) throws Exception {
		System.out.println("generateOTP...");
		int otp = generateOTPService.generateOTP(mobileNumber);
		System.out.println(otp);
		
		//To do construct appsession object here and 
			//return "login";
	}
	
	@RequestMapping(value ="/logout")
	public String userLogout(@ModelAttribute LoginDetailsForm loginDetailsForm,HttpServletRequest request) throws Exception {
		System.out.println("userLogout");
		HttpSession httpSession = request.getSession();
		UserLoginSessionForm userLogout= (UserLoginSessionForm) request.getAttribute("userLoginSessionForm");
		userLogout.setUserLogin(false);
		userLogout.setDisplayEdit(false);
		httpSession.setAttribute("userLoginSessionForm", userLogout);
			return "login";
	}

}