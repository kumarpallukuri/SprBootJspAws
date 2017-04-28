<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="/js/details/addDetails.js">
</script>
<script src="/js/details/state.js">
</script>
<script src="/js/details/workersProffession.js">
</script>
<script type="text/javascript" src="/js/details/jquery.js">
</script>
<body>

<h2>Validation Example</h2>

<form  ng-app="myApp"  ng-controller="validateCtrl"
name="myForm" novalidate>

<p>Username:<br>
  <input type="text" name="user" ng-model="user" required>
  <span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
  <span ng-show="myForm.user.$error.required">Username is required.</span>
  </span>
</p>

<p>Email:<br>
  <input type="email" name="email" ng-model="email" required>
  <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
  <span ng-show="myForm.email.$error.required">Email is required.</span>
  <span ng-show="myForm.email.$error.email">Invalid email address.</span>
  </span>
</p>

<p>   <div>Phone No. :</div>
    <div>
      <input type="text" placeholder="+91-636-78658" name="phone" ng-pattern="phoneNumbr" ng-model="phone" />
      <span style="color:red" ng-show="myForm.phone.$dirty && myForm.phone.$error.required">Required!</span>
      <span style="color:red" ng-show="myForm.phone.$error.minlength">Phone no not less that 10 char.</span>
      <span style="color:red" ng-show="myForm.phone.$error.maxlength">Phone no not more than 11 char.</span>
      <br><span style="color:red" ng-show="myForm.phone.$error.pattern">Please match pattern [+91-036-78658 || 91-036-78658]</span>
    </div>
       </p>


<p>
  <input type="submit"
  ng-disabled="myForm.user.$dirty && myForm.user.$invalid ||
  myForm.email.$dirty && myForm.email.$invalid" ||myForm.phone.$dirty && myForm.phone.$error.required >
</p>

</form>



</body>
</html>