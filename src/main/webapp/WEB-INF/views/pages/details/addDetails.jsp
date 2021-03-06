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
                          <input type="text" class="form-control" id="profName" name="profName" ng-model="user" required="true" title="Please enter your profile name">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="profession" class="control-label">Profession</label>
                          <div id="selection">
                          	<select id="proffession" ng-model="proffession" ng-click="showInputTextBox()" required="true"></select>
                          </div>
                          <span class="help-block"></span>
                      </div>
                      <div id="otherInput" ng-show="otherInputTextBox">
                      	<div class="form-group">
                    		 <label for="otherInputbox" class="control-label">Other</label>
                    		 <input type="text" class="form-control" id="otherInputbox" name="otherInputbox" value="" ng-model="proffessionOther" required="true" title="Please enter your profession">
                        	 <span class="help-block"></span>
                      	</div>
					  </div>
                      <div class="form-group">
                          <label for="email" class="control-label">Email</label>
                          	<input type="email" class="form-control" id="email" name="email" ng-model="email" required="true" title="Please enter your email address">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="mobileNum" class="control-label">Mobile Number</label>
                           <div class="input-group">
                          	<span class="input-group-addon">+91</span>
                          	<input type="tel" pattern="^\d{10}$"  maxlength="10" class="form-control" id="mobileNum" name="mobileNum" ng-model="phone" required="true" title="Please enter your mobile number">
                          </div>
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="address" class="control-label">Address</label>
                          <textarea class="form-control" id="address" name="username" ng-model="address" required="true" title="Please enter you address"></textarea>
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="pincode" class="control-label">PIN code</label>
                          <input type="text" class="form-control" id="pincode" name="pincode" ng-model="pincode" max-length="6" required="true" title="Please enter you pin code">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="workerCity" class="control-label">City</label>
                          <input type="text" class="form-control" id="workerCity" name="workerCity" ng-model="city" required="true" title="Please enter your city">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="workerState" class="control-label">State</label>
                           <select id="workerState" onchange='selct_district(this.value)' ng-model="state" required="true"></select>
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group hidden" id="districtlist">
                          <label for="workerDistrict" class="control-label">District</label>
                           <select id="workerDistrict" ng-model="district"></select>
                          <span class="help-block"></span>
                      </div>
                    <div class="form-group">
                          <label for="rate" class="control-label">Rate</label>
                          <div class="input-group">
	                      	<input type="number" class="form-control" id="rate" name="rate" ng-model="rate" required="true" title="Please enter your rate">
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
                      <div class="form-group">
                          <label for="workerWebsite" class="control-label">Website</label>
                          <input type="url" class="form-control" id="workerWebsite" name="workerWebsite" ng-model="workerWebsite" title="Please enter your website URL (if available)">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="workerExp" class="control-label">Experience (in years)</label>
                          <input type="number" class="form-control" id="workerExp" name="workerExp" ng-model="workerExp" required="true" title="Please enter your experience">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="workersPaymentMode" class="control-label">Mode of Payment</label>
                          <select id="workersPaymentMode" data-ng-model="modeofPayment"></select>
                          <span class="help-block"></span>
                      </div>
                      <button id="addDetailsButtonId" ng-click="addDetails()" class="btn btn-default btn-primary center-block">Submit</button>
                  </form>
              </div>
          </div>
      </div>
  </div>