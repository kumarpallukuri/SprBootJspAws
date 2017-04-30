var app = angular.module('myApp', []);
app.controller('validateCtrl', [ '$scope', '$http',function($scope, $http) {
    $scope.user = '';
    $scope.email = '';
    $scope.phoneNumbr = /^\+?\d{2}[- ]?\d{3}[- ]?\d{5}$/;
    $scope.otherInputTextBox = false;
    $scope.buttonEnable = false;
    $scope.disabled= false;
    $scope.MyButton = true;
    $scope.addDetails = function(){
		var worker = 
            {           
            	'workerName': $scope.user,
            	'workerEmail': $scope.email,
            	'workerPhoneNumber': $scope.phone,
            	'workerProffession': $scope.proffession,
            	'workerCity': $scope.city,
            	'workerAvailablity': $scope.availabilty,
            	'workerAddress': $scope.address,
            	'workerDistrict': $scope.district,
            	'workerState': $scope.state,
            	'workerRate': $scope.rate,
            	
            	};
		
		
		$http.post('/addworkerDetail',worker).success(function(response){
			 $scope.contact = response;
				alert("Details Added sucessfully..!")
				//refresh();
			});
		location.reload();
//		 $scope.user="";
//		 $scope.email="";
//		 $scope.phone="";
//		 $scope.proffession="";
//		 $scope.city="";
//		 $scope.availabilty="";
//		 $scope.address="";
//		 $scope.district="";
//		 $scope.state="";
//			 $scope.rate="";
	}
    $scope.handleButtonClick = function() {
        $scope.buttonClicks++;
    };
    $scope.buttonEnableValidation = function(){
//		if(( $scope.user != null) &&
//		( $scope.email != null) &&
//		( $scope.phone != null) &&
//		 ($scope.proffession != null) &&
//		( $scope.city != null) &&
//		( $scope.availabilty != null) &&
//		( $scope.address != null) &&
//		( $scope.district != null) &&
//		( $scope.state != null) &&
//			( $scope.rate!= null)){
//			$scope.buttonEnable = true;
//			 }
//    	alert("ss");
//    	if(( $scope.user != null) &&
//   			( $scope.email != null) ){
//    		$scope.buttonEnable = true;
//    	}else{
//    		$scope.buttonEnable = false;
//    	}
    }
    $scope.showInputTextBox = function(){
    	if($scope.proffession === "Other"){
    		$scope.otherInputTextBox =  true;
    	}else{
    		$scope.otherInputTextBox =  false;
    	}
    }
}]);
