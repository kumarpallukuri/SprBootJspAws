wtApp.controller('registrationController', [ '$scope','$http', function($scope,$http) {
	
	$scope.register = function() {
			var registrationForm =  {  
										phoneNumber : $scope.mobileNum, 
										password : $scope.password,
										userName :  $scope.userName, 
										workerName : $scope.profileName 
									};
			$http.post('/registerUser',registrationForm,{headers:{'Accept': 'application/json','Content-Type': 'application/json'}}).success(function(response){
					window.location = "/login.uri?firstLogin=true";
				});
	}
	
	$scope.forgotPass = function(){
		var requestOTPForm =  {  
				phoneNumber : $scope.mobileNum, 
				userName :  $scope.userName
			};
		$http.post('/requestOTP',requestOTPForm,{headers:{'Accept': 'application/json','Content-Type': 'application/json'}}).success(function(response){
			window.location = "/login.uri?firstLogin=true";
		});
	}
	
	$scope.usernameTaken = false;
	
	$scope.$watch(function(scope) { return scope.userName },
            function() {
				if($scope.userName){
					$http.get('/verifyUserName/'+$scope.userName).success(function(response){
							$scope.usernameTaken = response;
					});
				}
			}
           );
} ]);