 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 <script src="static/js/app/login/loginController.js"></script>
  
 <div id="login-form" ng-app="wtApp" ng-controller="loginController">
      <div class="row">
          <div class="col-xs-offset-4 col-xs-4">
              <div class="well">
                  <form name="loginform" id="loginForm" novalidate ng-submit="submitForm();" method="post" action="/login">
                      <div class="form-group" ng-class="{ 'has-error' : loginform.userName.$invalid && !loginform.userName.$pristine }">
                          <label for="username" class="control-label">Username
                          <span class="help-block displayInline">
                          		<span class="errorText" ng-show="loginform.userName.$error.required && !loginform.userName.$pristine"> - REQUIRED</span> 
                          </span>
                          </label>
                          <input type="text" class="form-control" id="userName" name="userName" ng-model="username" required title="Please enter you username">
                      </div>
                      <c:if test="${not otpRequired}">
	                      <div class="form-group" ng-class="{ 'has-error' : loginform.password.$invalid && !loginform.password.$pristine }">
	                          <label for="password" class="control-label">Password
	                          	<span class="help-block displayInline">
		                          	<span class="errorText" ng-show="loginform.password.$error.required && !loginform.password.$pristine"> - REQUIRED</span> 
		                        </span>
	                          </label>
	                          <input type="password" class="form-control" id="password" name="password" ng-model="password" required title="Please enter your password">
	                      </div>
                      </c:if>
                      <c:if test="${ otpRequired}">
                      	<div class="form-group" ng-class="{ 'has-error' : loginform.otp.$invalid && !loginform.otp.$pristine }">
                          <label for="otp" class="control-label">OTP
                          	<span class="help-block displayInline">
                          		<span class="errorText" ng-show="loginform.otp.$error.required && !loginform.otp.$pristine"> - REQUIRED</span> 
                          	</span>
                          </label>
                          <input type="text" class="form-control" id="otp" name="otp" ng-model="otp" required title="Please enter your One Time Password(OTP)">
                      </div>
                      </c:if>
                      <div id="loginErrorMsg" class="alert alert-error hide">Wrong username/password</div>
                      
                      <button type="submit" id="loginSubmitButton" class="btn btn-default btn-primary center-block" 
                      	ng-disabled="loginform.$invalid">
                      	Login
                      </button>
					    
                      <c:if test="${not otpRequired}">
	                      <a id="forgotPass" href="#">
	                      	<span class="anchorText">forgot password ?</span>
	                      </a>
                      </c:if>
                      <c:if test="${otpRequired}">
	                      <a id="resentOTP" href="#">
	                      	<span class="anchorText">Resend OTP</span>
	                      </a>
                      </c:if>
                  </form>
              </div>
          </div>
      </div>
  </div>