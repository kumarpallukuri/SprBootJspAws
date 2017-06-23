package com.basic.proto.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.basic.proto.config.ApplicationSessionObject;
import com.basic.proto.form.AppSessionForm;
import com.basic.proto.form.LoginCodeForm;
import com.basic.proto.form.LoginDetailsForm;
import com.basic.proto.form.UserLoginSessionForm;
import com.basic.proto.util.OTPNumberGeneration;

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
	
	Logger logger = LoggerFactory.getLogger(this.getClass());


	@RequestMapping(value = "/registartionSucess")
	public String welcome() throws Exception {
		System.out.println("update / delete page...");
		return "editDeleteDetails";
	}

	@RequestMapping(value = "/login")
	public String userLogin(@ModelAttribute LoginDetailsForm loginDetailsForm,
			@RequestParam(value = "firstLogin", required = false) String firstLogin, HttpServletRequest request)
			throws Exception {
		logger.info("login page...");
		
		LoginDetailsForm userDetailsForm = null;
		if (firstLogin != null && !"".equals(firstLogin)) {
			if (firstLogin.equals("true")) {
				request.setAttribute("otpRequired", true);
			}
		}
		if (loginDetailsForm.getUserName() != null) {

			 HttpSession httpSession = request.getSession();
			if (loginDetailsForm.getOtp() == 0) {
				userDetailsForm = loginDetailsDataService.getUserDetails(loginDetailsForm.getUserName());
				if ((loginDetailsForm.getUserName().equals(userDetailsForm.getUserName()))
						&& (loginDetailsForm.getPassword().equals(userDetailsForm.getPassword()))) {
					
//					 if((loginDetailsForm.getUserName().equals("SuperUser")) &&
//					 (loginDetailsForm.getPassword().equals("Superappforever"))){
//					 userLoginSessionForm.setDisplayEdit(true);
//					 }
					 userLoginSessionForm.setUserLogin(true);
//					 httpSession.setAttribute("userLoginSessionForm",
//					 userLoginSessionForm);
					return "home";
				} else {
					return "login";
				}
			} else {
				LoginCodeForm usersLoginCodes = ApplicationSessionObject.getApplicationSessionObject()
						.getUsersLoginCodes().get(loginDetailsForm.getUserName());
				if(usersLoginCodes != null){
					if ((loginDetailsForm.getOtp() == usersLoginCodes.getOtp())) {
						 userLoginSessionForm.setUserLogin(true);
						 httpSession.setAttribute("userLoginSessionForm",
						 userLoginSessionForm);
						return "home";
					} 
				}else {
					request.setAttribute("otpRequired", true);
					return "login";
				}
			}
		}
		return "login";
	}

	@RequestMapping(value = "/registerUser")
	@ResponseBody
	public String register(@RequestBody LoginDetailsForm loginDetailsForm, HttpServletRequest request)
			throws Exception {
		logger.info("login page..." + loginDetailsForm.getPhoneNumber());
		// int otp =
		// generateOTPService.generateOTP(Long.toString(loginDetailsForm.getPhoneNumber()));
		AppSessionForm appSessionForm = ApplicationSessionObject.getApplicationSessionObject();
		long workerId = loginDetailsDataService.addItem(loginDetailsForm);
		// return "login";
		Map<String, LoginCodeForm> usersLoginCodes = appSessionForm.getUsersLoginCodes();
		LoginCodeForm loginCodeForm = new LoginCodeForm();
		loginCodeForm.setGeneratedTime(Calendar.getInstance().getTimeInMillis());
		int otp = generateOTPService.generateOTP(loginDetailsForm.getPhoneNumber());
		loginCodeForm.setOtp(otp);
		loginCodeForm.setPhoneNumber(loginDetailsForm.getPhoneNumber());
		loginCodeForm.setWorkerId(workerId);
		usersLoginCodes.put(loginDetailsForm.getUserName(), loginCodeForm);
		ApplicationSessionObject.getApplicationSessionObject().setUsersLoginCodes(usersLoginCodes);
		return "";
	}

	@RequestMapping(value = "/generateOTP/{mobileNumber}")
	public void generateOTP(@PathVariable("mobileNumber") String mobileNumber) throws Exception {
		logger.info("generateOTP...");
		// int otp = generateOTPService.generateOTP(mobileNumber);
		// System.out.println(otp);

		// To do construct appsession object here and
		// return "login";
	}

	@RequestMapping(value = "/logout")
	public String userLogout(@ModelAttribute LoginDetailsForm loginDetailsForm, HttpServletRequest request)
			throws Exception {
		logger.info("userLogout");
//		HttpSession httpSession = request.getSession();
//		UserLoginSessionForm userLogout = (UserLoginSessionForm) request.getAttribute("userLoginSessionForm");
		userLoginSessionForm.setUserLogin(false);
		userLoginSessionForm.setDisplayEdit(false);
	//	httpSession.setAttribute("userLoginSessionForm", userLogout);
		return "login";
	}
	
	@RequestMapping(value = "/verifyUserName/{userName}")
	public @ResponseBody boolean userNameVerification(@PathVariable("userName") String userName)
			throws Exception {
		logger.info("verifyUserName");
		boolean isUserNameExists = false;
		LoginDetailsForm loginDetailsForm =loginDetailsDataService.getUserDetails(userName);
		if(loginDetailsForm != null){
			isUserNameExists = true;
		}
		return isUserNameExists;
	}
	
	@RequestMapping(value = "/verifyOTP/{userName}/{phonenumber}/{otp}")
	@ResponseBody
	public String verifyOTP(@PathVariable("userName") String userName,@PathVariable("phonenumber") long phonenumber,@PathVariable("otp") int otp)
			throws Exception {
		logger.info("verifyOTP..." );
		// int otp =
		// generateOTPService.generateOTP(Long.toString(loginDetailsForm.getPhoneNumber()));
		AppSessionForm appSessionForm = ApplicationSessionObject.getApplicationSessionObject();
		Map<String, LoginCodeForm> usersLoginCodes = appSessionForm.getUsersLoginCodes();
		LoginCodeForm loginCodeForm  = usersLoginCodes.get(userName);
		if(loginCodeForm != null){
			LoginDetailsForm loginDetailsForm = loginDetailsDataService.getUserWorkerDetailsbyID(loginCodeForm.getWorkerId());
			if((loginCodeForm.getOtp() == otp) && (loginCodeForm.getPhoneNumber() == phonenumber)){
				loginDetailsForm.setOtpVerification("done");
				loginDetailsDataService.updateUserRegistrationDetails(loginDetailsForm);
				 userLoginSessionForm.setUserLogin(true);
				 if(loginDetailsForm.getFullProfile().equals("yes")){
					 userLoginSessionForm.setFullProfile(true);
				 }else{
					 userLoginSessionForm.setFullProfile(false);
				 }
				return "/home";
			}
		}else{
			return "/error";
		}
//		long workerId = loginDetailsDataService.addItem(loginDetailsForm);
//		// return "login";
//		Map<String, LoginCodeForm> usersLoginCodes = appSessionForm.getUsersLoginCodes();
//		LoginCodeForm loginCodeForm = new LoginCodeForm();
//		loginCodeForm.setGeneratedTime(Calendar.getInstance().getTimeInMillis());
//		int otp = generateOTPService.generateOTP(loginDetailsForm.getPhoneNumber());
//		loginCodeForm.setOtp(otp);
//		loginCodeForm.setPhoneNumber(loginDetailsForm.getPhoneNumber());
//		loginCodeForm.setWorkerId(workerId);
//		usersLoginCodes.put(loginDetailsForm.getUserName(), loginCodeForm);
//		ApplicationSessionObject.getApplicationSessionObject().setUsersLoginCodes(usersLoginCodes);
		return "";
	}

}