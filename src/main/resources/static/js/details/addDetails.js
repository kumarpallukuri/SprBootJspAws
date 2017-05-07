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
    	//alert(myForm.user.$invalid)
    	console.log("started...>");
    	 if((!($scope.myForm.user.$error.required)) ){
    		 console.log("user sucess");
    	 }
    	 
    	 if((!($scope.myForm.proffessionOther.$error.required)) && 
    			 (!($scope.myForm.proffessionOther.$error.pattern)) ){
    		 console.log("proffessionOther");
    	 }
    	
    	 
    	 if((!($scope.myForm.email.$error.required))&&
    			 (!($scope.myForm.email.$error.email))){
    		 console.log("email sucess");
    	 }
    	 
    	 if((!($scope.myForm.phone.$error.required))&&
    			 (!($scope.myForm.phone.$error.minlength))&&
    			 (!($scope.myForm.phone.$error.maxlength))&&
    			 (!($scope.myForm.phone.$error.pattern))){
    		 console.log("phone sucess");
    	 }
    	 
    	 if((!($scope.myForm.city.$error.pattern))){
    		 console.log("city sucess");
    	 }
    	 console.log("ended...>");
//    	 if(($scope.myForm.user.$error.required) == true){
//    		 console.log("user sucess");
//    	 }
//    	 
//    	 if(($scope.myForm.city.$error.pattern)  == true){
//    		 console.log("city enteree");
//    	 }
            
    	
//    	$("#addDetailsButtonId").attr("disabled", false);
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
//				$("#addDetailsButtonId").attr("disabled", false);
//			 }
//    	else{
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

$(document).ready(function() {
	
	$("#addDetailsButtonId").attr("disabled", true);
});

