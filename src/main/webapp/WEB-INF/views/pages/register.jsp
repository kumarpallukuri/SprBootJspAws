  <script src="static/js/app/login/register.js"></script>
  <div id="register-form" ng-app="myApp" ng-controller="validateCtrl">
      <div class="row">
          <div class="col-xs-offset-4 col-xs-4">
              <div class="well">
                  <form id="registerForm" method="POST" action="/register/">
                       <div class="form-group">
                          <label for="profName" class="control-label">Name</label>
                          <input type="text" class="form-control" id="profName" name="profName" value="" required="true" title="Please enter your profile name">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="mobileNum" class="control-label">Mobile Number</label>
                           <div class="input-group">
                          	<span class="input-group-addon">+91</span>
                          	<input type="tel" pattern="^\d{10}$"  maxlength="10" class="form-control" id="mobileNum" name="mobileNum" value="" required="true" title="Please enter your mobile number">
                          </div>
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="username" class="control-label">Username</label>
                          <input type="text" class="form-control" id="username" name="username" value="" required="true" title="Please enter you username">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="password" class="control-label">Password</label>
                          <input type="password" class="form-control" id="password" name="password" value="" required="true" title="Please enter your password">
                          <span class="help-block"></span>
                      </div>
                      <li type="submit" id="registerSubmitButton" class="btn btn-default btn-primary center-block" ng-click="register()" >Register</li>
                  </form>
              </div>
          </div>
      </div>
  </div>