  <script src="static/js/app/login/register.js"></script>
  
  <div id="register-form" ng-app="wtApp" ng-controller="registrationController">
      <div class="row">
          <div class="col-xs-offset-4 col-xs-4">
              <div class="well">
                  <form id="registerForm" name="registerForm" novalidate ng-submit="register();">
                       <div class="form-group" ng-class="{ 'has-error' : registerForm.profName.$invalid && !registerForm.profName.$pristine }">
                          <label for="profName" class="control-label">Name
	                          <span class="help-block displayInline">
	                          		<span class="errorText" ng-show="registerForm.profName.$error.required && !registerForm.profName.$pristine"> - REQUIRED</span> 
	                          </span>
                          </label>
                          <input type="text" class="form-control" id="profName" name="profName" ng-model="profileName" required title="Please enter your profile name">
                      </div>
                      <div class="form-group" ng-class="{ 'has-error' : registerForm.mobileNum.$invalid && !registerForm.mobileNum.$pristine }">
                          <label for="mobileNum" class="control-label">Mobile Number
                          	<span class="help-block displayInline">
	                          	<span class="errorText" ng-show="registerForm.mobileNum.$error.required && !registerForm.mobileNum.$pristine"> - REQUIRED</span> 
                          	</span>
                          </label>
                           <div class="input-group">
                          	<span class="input-group-addon">+91</span>
                          	<input type="tel" pattern="^\d{10}$"  maxlength="10" minlength="10" onkeypress='return event.charCode >= 48 && event.charCode <= 57'
                          	class="form-control" id="mobileNum" ng-model="mobileNum" name="mobileNum" required title="Please enter your mobile number">
                          </div>
                          <span class="help-block">
	                          	<span class="errorText" ng-show="registerForm.mobileNum.$error.minlength && !registerForm.mobileNum.$pristine">Should contain 10 digits.</span> 
                          	</span>
                      </div>
                      <div class="form-group" ng-class="{ 'has-error' : registerForm.username.$invalid && !registerForm.username.$pristine }">
                          <label for="username" class="control-label">Username
                          	<span class="help-block displayInline">
	                          	<span class="errorText" ng-show="registerForm.username.$error.required && !registerForm.username.$pristine"> - REQUIRED</span> 
                          	</span>
                          </label>
                          <input type="text" class="form-control" id="username" name="username" ng-model="userName" 
                          minlength="4" maxlength="20" ng-pattern="/^[a-zA-Z0-9]+[@#_\-.]?[a-zA-Z0-9]*$/" required title="Please enter you username">
                          <span class="help-block">
                          		<span class="errorText" ng-show="registerForm.username.$error.pattern">Should contain only letters, numbers and @,#,-,.,_ characters.</span>
                          		<span class="errorText displayBlock" ng-show="registerForm.username.$error.minlength">Should contain atleast 4 characters.</span>  
                          		<span class="errorText displayBlock" ng-show="usernameTaken && !registerForm.username.$invalid">Username already taken. Please try another one.</span>  
                          	</span>
                      </div>
                      <div class="form-group" ng-class="{ 'has-error' : registerForm.password.$invalid && !registerForm.password.$pristine }">
                          <label for="password" class="control-label">Password
                          	<span class="help-block displayInline">
	                          	<span class="errorText" ng-show="registerForm.password.$error.required && !registerForm.password.$pristine"> - REQUIRED</span> 
                          	</span>
                          </label>
                          <input type="password" class="form-control" id="password" name="password" ng-model="password" minlength="6"
                          ng-pattern="/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])/" required title="Please enter your password">
                          <span class="help-block">
                          		<span class="errorText" ng-show="registerForm.password.$error.minlength">Should contain minimum of 6 characters.</span>
                          		<span class="errorText displayBlock" ng-show="registerForm.password.$error.pattern">Should contain atleast one capital letter, one small letter and a number.</span> 
                          	</span>
                      </div>
                      <div class="marginB8 smallFont">
						  <span>By clicking register, you agree to our <a href="/privacyPolicy"><span class="anchorText">Privacy policy</span></a> and <a href="/termsAndConditions"><span class="anchorText">Terms and conditions</span></a></span>
					   </div>
                      <button type="submit" id="registerSubmitButton" class="btn btn-default btn-primary center-block" title="Register"
                      ng-disabled="registerForm.$invalid || usernameTaken">Register</button>
                      
                       <a id="alreadyRegistered" href="/login">
                      	<span class="anchorText">Already Registered ?</span>
                      </a>
                  </form>
              </div>
          </div>
      </div>
  </div>