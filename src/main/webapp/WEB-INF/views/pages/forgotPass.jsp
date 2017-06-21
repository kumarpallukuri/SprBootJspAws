  <script src="static/js/app/login/register.js"></script>
  
  <div id="register-form" ng-app="wtApp" ng-controller="registrationController">
      <div class="row">
          <div class="col-xs-offset-4 col-xs-4">
              <div class="well">
                  <form id="registerForm" name="registerForm" novalidate ng-submit="forgotPass();">
                      <div class="form-group" ng-class="{ 'has-error' : registerForm.mobileNum.$invalid && !registerForm.mobileNum.$pristine }">
                          <label for="mobileNum" class="control-label">Mobile Number
                          	<span class="help-block displayInline">
	                          	<span class="errorText" ng-show="registerForm.mobileNum.$error.required && !registerForm.mobileNum.$pristine"> - REQUIRED</span> 
                          	</span>
                          </label>
                           <div class="input-group">
                          	<span class="input-group-addon">+91</span>
                          	<input type="tel" pattern="^\d{10}$"  maxlength="10" minlength="10" onkeypress='return event.charCode >= 48 && event.charCode <= 57'
                          	class="form-control" id="mobileNum" ng-model="user.mobileNum" name="mobileNum" required title="Please enter your mobile number">
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
                          <input type="text" class="form-control" id="username" name="username" ng-model="user.userName" 
                          minlength="4" maxlength="20" ng-pattern="/^[a-zA-Z0-9]+[@#_\-.]?[a-zA-Z0-9]*$/" required title="Please enter you username">
                          <span class="help-block">
                          		<span class="errorText" ng-show="registerForm.username.$error.pattern">Should contain only letters, numbers and @,#,-,.,_ characters.</span>
                          		<span class="errorText displayBlock" ng-show="registerForm.username.$error.minlength">Should contain atleast 4 characters.</span>  
                          	</span>
                      </div>
                      <button type="submit" id="registerSubmitButton" class="btn btn-default btn-primary center-block" title="Request OTP"
                      ng-disabled="registerForm.$invalid">Request OTP</button>
                  </form>
              </div>
          </div>
      </div>
  </div>