  <script src="static/js/app/login/register.js"></script>
  
  <div id="register-form" ng-app="wtApp" ng-controller="registrationController">
      <div class="row">
          <div class="col-xs-offset-4 col-xs-4">
              <div class="well">
                  <form id="registerForm" name="registerForm" novalidate ng-submit="register();">
                       <div class="form-group" ng-show="!alreadyRegistered">
                          <label for="profName" class="control-label">Name
	                          <span class="help-block displayInline">
	                          	<span ng-show="registerForm.$submitted || registerForm.profName.$touched">
	                          		<span class="errorText" ng-show="registerForm.profName.$error.required"> - REQUIRED</span> 
	                          	</span>
	                          </span>
                          </label>
                          <input type="text" class="form-control" id="profName" name="profName" ng-model="user.profileName" required title="Please enter your profile name">
                      </div>
                      <div class="form-group">
                          <label for="mobileNum" class="control-label">Mobile Number
                          	<span class="help-block displayInline">
	                          	<span ng-show="registerForm.$submitted || registerForm.mobileNum.$touched">
	                          		<span class="errorText" ng-show="registerForm.mobileNum.$error.required"> - REQUIRED</span> 
	                          	</span>
                          	</span>
                          </label>
                           <div class="input-group">
                          	<span class="input-group-addon">+91</span>
                          	<input type="tel" pattern="^\d{10}$"  maxlength="10" minlength="10" onkeypress='return event.charCode >= 48 && event.charCode <= 57'
                          	class="form-control" id="mobileNum" ng-model="user.mobileNum" name="mobileNum" required title="Please enter your mobile number">
                          </div>
                          <span class="help-block">
	                          	<span ng-show="registerForm.$submitted || registerForm.mobileNum.$touched">
	                          		<span class="errorText" ng-show="registerForm.mobileNum.$error.minlength">Should contain 10 digits.</span> 
	                          	</span>
                          	</span>
                      </div>
                      <div class="form-group">
                          <label for="username" class="control-label">Username
                          	<span class="help-block displayInline">
	                          	<span ng-show="registerForm.$submitted || registerForm.username.$touched">
	                          		<span class="errorText" ng-show="registerForm.username.$error.required"> - REQUIRED</span> 
	                          	</span>
                          	</span>
                          </label>
                          <input type="text" class="form-control" id="username" name="username" ng-model="user.userName" 
                          minlength="4" maxlength="20" ng-pattern="/^[a-zA-Z0-9]+[@#_-.]?[a-zA-Z0-9]*$/" required title="Please enter you username">
                          <span class="help-block">
	                          	<span ng-show="registerForm.$submitted || registerForm.username.$touched">
	                          		<span class="errorText" ng-show="registerForm.username.$error.pattern">Should contain only letters, numbers and @,#,-,.,_ characters.</span>
	                          		<span class="errorText displayBlock" ng-show="registerForm.username.$error.minlength">Should contain atleast 4 characters.</span>  
	                          	</span>
                          	</span>
                      </div>
                      <div class="form-group" ng-show="!alreadyRegistered">
                          <label for="password" class="control-label">Password
                          	<span class="help-block displayInline">
	                          	<span ng-show="registerForm.$submitted || registerForm.password.$touched">
	                          		<span class="errorText" ng-show="registerForm.password.$error.required"> - REQUIRED</span> 
	                          	</span>
                          	</span>
                          </label>
                          <input type="password" class="form-control" id="password" name="password" ng-model="user.password" minlength="6"
                          ng-pattern="/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])/" required title="Please enter your password">
                          <span class="help-block">
	                          	<span ng-show="registerForm.$submitted || registerForm.password.$touched">
	                          		<span class="errorText" ng-show="registerForm.password.$error.minlength">Should contain minimum of 6 characters.</span>
	                          		<span class="errorText displayBlock" ng-show="registerForm.password.$error.pattern">Should contain atleast one capital letter, one small letter and a number.</span> 
	                          	</span>
                          	</span>
                      </div>
                      <button type="submit" id="registerSubmitButton" class="btn btn-default btn-primary center-block" ng-show="!alreadyRegistered" title="Register"
                      ng-disabled="registerForm.username.$error.required || registerForm.password.$error.required || registerForm.profName.$error.required 
                      || registerForm.mobileNum.$error.required">Register</button>
                      
                      <button type="submit" id="requestOTPButton" class="btn btn-default btn-primary center-block" ng-show="alreadyRegistered" title="Request One Time Password (OTP)"
                      ng-disabled="registerForm.username.$error.required || registerForm.mobileNum.$error.required">Request OTP</button>
                      
                       <a id="alreadyRegistered" href="javascript:void(0);" ng-click="alreadyRegistered = true" ng-show="!alreadyRegistered">
                      	<span class="anchorText">Already Registered ?</span>
                      </a>
                  </form>
              </div>
          </div>
      </div>
  </div>