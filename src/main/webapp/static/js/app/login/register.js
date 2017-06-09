wtApp.controller('registrationController', [ '$scope', '$http', function($scope, $http) {
	$scope.register = function() {
		var loginDetailsForm =  {  
									phoneNumber : $scope.user.mobileNum, 
									password : $scope.user.password,
									userName :  $scope.user.userName, 
									workerName : $scope.user.profileName 
								};
		$http.post('/registerUser',loginDetailsForm,{headers:{'Accept': 'application/json','Content-Type': 'application/json'}}).success(function(response){
				window.location = "/login.uri?firstLogin=true";
			});
	}
} ]);