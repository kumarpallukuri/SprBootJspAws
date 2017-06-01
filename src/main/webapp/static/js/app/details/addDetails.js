var app = angular.module('myApp', []);
app.controller('validateCtrl', [ '$scope', '$http',function($scope, $http) {
    $scope.user = '';
    $scope.email = '';
   $scope.phoneNumbr = /^\+?\d{2}[- ]?\d{5}[- ]?\d{5}$/;
    $scope.otherInputTextBox = false;
    $scope.buttonEnable = false;
    $scope.disabled= false;
    $scope.MyButton = true;
    $scope.addDetails = function(){
    	var isValidSubmission = $scope.buttonEnableValidation();
    	alert(isValidSubmission);
    	if (isValidSubmission) {
    		alert("values corrected")
    		$scope.state = $("#workerState").val();
    		$scope.district = $("#workerDistrict").val();
    		$scope.availabilty = $("#workersavailabilty").val();
    		 $("#rateDropdown").val();
    		 $scope.city = $("#workerCity").val();
    		 if($scope.rate == ""){
    			 $scope.rate = 100;
    		 }
    		 if(($("#proffession").val())== "Other"){
    			 $scope.proffession =$("#otherInputbox").val();
    		 }
    		 $scope.modeOfPayment = $("#workersPaymentMode").val();
    		 $scope.workerWebsite = $("#workerWebsite").val();
    		 $scope.pincode = $("#pincode").val();
    		 
    		 
    		 
    		 console.log("user -->"+$scope.user)
    		  console.log("email -->"+$scope.email)
    		   console.log("phone -->"+$scope.phone)
    		    console.log("proffession -->"+$scope.proffession)
    		     console.log("city -->"+$scope.city)
    		      console.log("availabilty -->"+$scope.availabilty)
    		       console.log("address -->"+$scope.address)
    		        console.log("district -->"+$scope.district)
    		         console.log("state -->"+$scope.state)
    		          console.log("rate -->"+$scope.rate)
		var worker = 
            {           
            	'workerName': $scope.user,
            	'workerEmail': $scope.email,
            	'workerPhoneNumber': $scope.phone,
            	'workerProffession': $scope.proffession,
            	'workerCity': $scope.city,
            	'workerAvailablity': $scope.availabilty,
            	'workerAddress': $scope.address,
            	'pincode': $scope.pincode,
            	'workerDistrict': $scope.district,
            	'workerState': $scope.state,
            	'workerRate': $scope.rate,
            	'websiteUrl' : $scope.workerWebsite,
            	'workerexperience': $scope.workerExp,
            	'modeofPayment': $scope.modeOfPayment
            	};
		
		$http.post('/addworkerDetail',worker).success(function(response){
			 $scope.contact = response;
				alert("Details Added sucessfully..!");
				 location.reload();
				//refresh();
			});
				
				
		
    	}
	}
    $scope.handleButtonClick = function() {
        $scope.buttonClicks++;
    }; 
    $scope.showInputTextBox = function(){
    	if($scope.proffession === "Other"){
    		$scope.otherInputTextBox =  true;
    	}else{
    		$scope.otherInputTextBox =  false;
    	}
    }
    $scope.buttonEnableValidation = function(){/*
    	if(($("#userName").val().length) == 0){
    		alert("please enter username..!")
    		$("#userNameErrorSpan").show();
    		return false;
    	}
    	
    	if(($("#proffession").val())== "SELECT Proffession"){
    		alert("please Select Proffession..!")
    		return false;
    	}
    	if(($("#proffession").val())== "Other"){
    		var str = $("#otherInputbox").val();
    		if(($("#otherInputbox").val().length) == 0){
    			 alert("please enter Proffession..!")
    			 return false;
    		
    		}else{
    			var str2 = "sex";
    		//	
//    			if(str.includes("sex")){
//    			    alert("This Proffession is not accepted..!");
//        			return false;
//    			}
    			
    		}
    	}
    		
    	
    	if(($("#emailAddress").val().length )== 0){
    		alert("please enter  emailAddress..!")
    	
    		return false;
    	}else{
    		  if(($scope.myForm.email.$error.email)){
    			 alert("please enter valid Email Addresss")
    			 return false;
    		  }
    	}
    	
    	if(($("#phoneNumber").val().length )== 0){
    			alert("please enter Phone Number..!")
    			return false;
    	}else{
    		if((($scope.myForm.phone.$error.pattern))){
    			alert("Please enter valid phone number");
    			return false;
       	 	}
    	}
    	if(($("#workerAddress").val().length )== 0){
    		$("#workerAddress").val("Address not available");
    		//return false;
    	}
    	if(($("#workerCity").val().length )== 0){
    		alert("Please enter City..!")
    		return false;
    	}else{
    		var workerCity = $("#workerCity").val();
    		var matches = workerCity.match(/^[a-zA-Z]*$/);
    		if (matches == null) {
    		    alert('Please do not enter any numeric charcters or special charcters');
    		    return false;
    		}
    	}
    	if(($("#workerState").val() )== "SELECT STATE"){
    		alert("Please select State..!")
    		return false;
    	}*/
    	return true;
}
}]);

$(document).ready(function() {
	
//	$("#addDetailsButtonId").attr("disabled", true);
});

