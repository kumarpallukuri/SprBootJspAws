<script type="text/JavaScript" src='static/js/app/details/state.js'></script>
<script type="text/JavaScript" src='static/js/app/details/workersProfession.js'></script>
<script src="static/js/app/details/addDetails.js"></script>
	
	  <div id="addDetails-form" ng-app="myApp" ng-controller="validateCtrl">
      <div class="row">
          <div class="col-xs-offset-4 col-xs-4">
          	  <h2>Add your details !!</h2>
              <div class="well">
                  <form id="addDetailsForm">
                       <div class="form-group">
                          <label for="profName" class="control-label">Name</label>
                          <input type="text" class="form-control" id="profName" name="profName" value="" required="true" title="Please enter your profile name">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="email" class="control-label">Email</label>
                          	<input type="email" class="form-control" id="email" name="email" value="" required="true" title="Please enter your email address">
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
                          <label for="address" class="control-label">Address</label>
                          <textarea class="form-control" id="address" name="username" value="" required="true" title="Please enter you address"></textarea>
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="city" class="control-label">City</label>
                          <input type="text" class="form-control" id="city" name="city" value="" required="true" title="Please enter your city">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="workerState" class="control-label">State</label>
                           <select id="workerState" onchange='selct_district(this.value)' ng-model="state"></select>
                          <span class="help-block"></span>
                      </div>
                    <div class="form-group">
                          <label for="rate" class="control-label">Rate</label>
                          <div class="input-group">
	                      	<input type="number" class="form-control" id="rate" name="rate" value="" required="true" title="Please enter your rate">
	                      	<span class="input-group-addon">rupees</span>
	                      </div>
                          <span class="help-block"></span>
                      </div>
                       <div class="form-group">
                          <label for="rateDropdown" class="control-label">Rate per</label>
                          <select id='rateDropdown' ng-model="rateDropdown" ></select>
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="workersavailabilty" class="control-label">Availability</label>
                          <select id="workersavailabilty" data-ng-model="availabilty"></select>
                          <span class="help-block"></span>
                      </div>
                  </form>
              </div>
          </div>
      </div>
  </div>