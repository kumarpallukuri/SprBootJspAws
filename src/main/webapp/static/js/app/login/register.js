var app = angular.module('myApp', []);
app.controller('validateCtrl', [ '$scope', '$http', function($scope, $http) {
	$scope.register = function() {
		var workerName = $("#profName").val();
		var mobileNum = $("#mobileNum").val();
		var username = $("#username").val();
		var password = $("#password").val();
		alert(workerName + mobileNum+username+password)
		var loginDetailsForm = 
        {           
        	'phoneNumber': mobileNum,
        	'password': password,
        	'userName;': username,
        	'workerName':workerName
        	
        	};
		alert(loginDetailsForm)
		$http.post('/registerUser',loginDetailsForm).success(function(response){
			 //$scope.contact = response;
				alert("Details Added sucessfully..!")
				//refresh();
			});

	}
} ]);