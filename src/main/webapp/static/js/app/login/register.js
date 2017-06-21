wtApp.controller('registrationController', [ '$scope','$http', function($scope,$http) {
	
	$scope.register = function() {
			var registrationForm =  {  
										phoneNumber : $scope.user.mobileNum, 
										password : $scope.user.password,
										userName :  $scope.user.userName, 
										workerName : $scope.user.profileName 
									};
			$http.post('/registerUser',registrationForm,{headers:{'Accept': 'application/json','Content-Type': 'application/json'}}).success(function(response){
					window.location = "/login.uri?firstLogin=true";
				});
	}
	
	$scope.forgotPass = function(){
		var requestOTPForm =  {  
				phoneNumber : $scope.user.mobileNum, 
				userName :  $scope.user.userName
			};
		$http.post('/requestOTP',requestOTPForm,{headers:{'Accept': 'application/json','Content-Type': 'application/json'}}).success(function(response){
			window.location = "/login.uri?firstLogin=true";
		});
	}
} ]);