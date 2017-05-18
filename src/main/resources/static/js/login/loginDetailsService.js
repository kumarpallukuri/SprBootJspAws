var app = angular.module('myApp', []);
app.service('loginSevice', function ()  {

	$scope.addDetails = function() {

//		console.log("user -->" + $scope.user)
//		console.log("email -->" + $scope.email)
//		console.log("phone -->" + $scope.phone)
//		console.log("proffession -->" + $scope.proffession)
//		console.log("city -->" + $scope.city)
//
//		var worker = {
//			'workerName' : $scope.user,
//			'workerEmail' : $scope.email,
//			'workerPhoneNumber' : $scope.phone,
//			'workerProffession' : $scope.proffession,
//			'workerCity' : $scope.city,
//			'workerAvailablity' : $scope.availabilty,
//			'workerAddress' : $scope.address,
//			'workerDistrict' : $scope.district,
//			'workerState' : $scope.state,
//			'workerRate' : $scope.rate,
//
//		};

		
		
		 this.save = function (loginDetails) {
		        if (loginDetails.workerId == null) {
		            //if this is new contact, add it in contacts array
		        	$http.post('/login', loginDetails).success(function(response) {
		    			$scope.contact = response;
		    			alert("Details Added sucessfully..!")
		    			//refresh();
		    		});
		        } 

		    }

	}

} );

$(document).ready(function() {

	//	$("#addDetailsButtonId").attr("disabled", true);
});
