wtApp.controller('registrationController', [ '$scope', '$http', function($scope, $http) {
	$scope.register = function() {
		var workerName = $("#profName").val();
		var mobileNum = $("#mobileNum").val();
		var username = $("#username").val();
		var password = $("#password").val();
		alert(workerName + mobileNum+username+password)
		var loginDetailsForm =  {  
									phoneNumber : mobileNum, 
									password : password,
									userName : username, 
									workerName : workerName 
								};
		$http.post('/registerUser',loginDetailsForm,{headers:{'Accept': 'application/json','Content-Type': 'application/json'}}).success(function(response){
				window.location = "/login.uri?firstLogin=true";
			});
	}
} ]);