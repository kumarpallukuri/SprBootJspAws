<html>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.15/angular-ui-router.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>

<script language="Javascript" src="/js/common/jquery.js"></script>
<script type="text/JavaScript" src='/js/details/state.js'></script>
<script type="text/JavaScript" src='/js/details/workersProfession.js'></script>
<script src="/js/details/addDetails.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
<body>

	<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Add worker Details
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h2>

	<form ng-app="myApp" ng-controller="validateCtrl" name="myForm"
		novalidate>

		<p>
			&nbsp;Name <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="text" name="user" ng-model="user" required
				ng-change="buttonEnableValidation()"> <span
				style="color: red"
				ng-show="myForm.user.$dirty && myForm.user.$invalid"> <span
				ng-show="myForm.user.$error.required">Username is required.</span>
			</span>
		</p>
		<p>
			&nbsp;Proffession <br>
		<div id="selection">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="proffession"
				ng-model="proffession" ng-click="showInputTextBox()"></select>
		</div>
		<div id="otherInput" ng-show="otherInputTextBox">
			<p>
				&nbsp; other:<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="text" name="proffessionOther" ng-model="proffessionOther"
					placeholder="Enter proffession here.."
					ng-change="buttonEnableValidation()"  ng-pattern="/^[a-zA-Z]$/" required>
				<span style="color: red" ng-show="myForm.proffessionOther.$error.required">Proffession
					is required.</span>
					<span style="color: red" ng-show="myForm.proffessionOther.$error.pattern">Enter characters or numbers only.</span>
			</p>
		</div>
		</div>

		</p>
		<p>
			&nbsp;Email Addresss<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="email" name="email" ng-model="email"
				ng-change="buttonEnableValidation()" required> <span
				style="color: red"
				ng-show="myForm.email.$dirty && myForm.email.$invalid"> <span
				ng-show="myForm.email.$error.required">Email is required.</span> <span
				ng-show="myForm.email.$error.email">Invalid email address.</span>
			</span>
		</p>

		<p>
			&nbsp;Mobile Number<br>
		<div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				placeholder="+91-636-78658" name="phone" ng-pattern="phoneNumbr"
				ng-model="phone" ng-change="buttonEnableValidation()" /> <span
				style="color: red"
				ng-show="myForm.phone.$dirty && myForm.phone.$error.required">Required!</span>
			<span style="color: red" ng-show="myForm.phone.$error.minlength">Phone
				no not less that 10 char.</span> <span style="color: red"
				ng-show="myForm.phone.$error.maxlength">Phone no not more
				than 11 char.</span> <span style="color: red"
				ng-show="myForm.phone.$error.pattern">Please match pattern
				[+91-036-78658 || 91-036-78658]</span>
		</div>
		</p>
		<p>
			&nbsp; Address<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="text" ng-model="address" ng-change="buttonEnableValidation()"/>
		</p>
		<p>
			&nbsp; City<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="text" name="city" ng-model="city" 
				ng-click="buttonEnableValidation()"  ng-pattern="/^[a-zA-Z]$/" />
				
				 <span style="color: red"
				ng-show="myForm.city.$error.pattern">Do not enter any numbers
				or special characters.</span>
		</p>
		</p>
		&nbsp;State:
		<div id="selection">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select id="listBox"
				onchange='selct_district(this.value)' ng-model="state"></select>
		</div>
		</div>

		</p>
		<p id="districtlist" style="display: none">
			&nbsp;District: :<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select
				id='secondlist' ng-model="district"
				ng-click="buttonEnableValidation()"></select>
		</p>

		<p>
			&nbsp;Rate:<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="number" name="input" ng-model="rate" min="1" max="1000"
				ng-change="buttonEnableValidation()" required>
				 <span
				style="color: red;" ng-show="myForm.input.$error.number"> Not
				valid number! or Enter numbers only..</span>

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span> <select
				id='rateDropdown' ng-model="rateDropdown" ng-change="buttonEnableValidation()"></select></span>
		<p>
		<p>&nbsp;Availabilty:
		<div id="selection">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select id="workersavailabilty"
				data-ng-model="availabilty"></select>
		</div>
		</div>

		</p>



		<p>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
				ng-click="addDetails()" class="btn btn-warning"
				id="addDetailsButtonId" />
		<div style="display: inline-block;">
			<li style="display: inline-block;"><a class="btn btn-primary"
				href="/register">Home/Worker Details .. </a></li>
		</div>
		</p>

	</form>
	<!-- <div class="form-group" show-errors> -->
	<!--   <input type="text" -->
	<!--     name="username" -->
	<!--     placeholder="Username" -->
	<!--     class="form-control" -->
	<!--     ng-model="credentials.username" -->
	<!--     ng-minlength=5 -->
	<!--     required -->
	<!--     ng-unique="{key: 'users', property: 'username'}" -->
	<!--     ng-pattern="/^[a-zA-Z0-9]*$/" -->
	<!--     autofocus /> -->
	<!--   <span class="glyphicon glyphicon-ok form-control-icon success"></span> -->
	<!--   <p class="help-block" ng-show="signup_form.username.$error.required">Username is required.</p> -->
	<!--   <p class="help-block" ng-show="signup_form.username.$error.pattern">Username must be letters and numbers only.</p> -->
	<!--   <p class="help-block" ng-if="signup_form.username.$error.minlength">Must be at least 5 characters.</p> -->
	<!--   <p class="help-block" ng-show="signup_form.username.$error.unique">Username is already taken.</p> -->
	<!-- </div> -->


</body>
</html>