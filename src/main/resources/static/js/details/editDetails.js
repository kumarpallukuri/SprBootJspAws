var myApp = angular.module('myApp', []);
myApp.controller('AppCtrl', [ '$scope', '$http', function($scope, $http) {
	$scope.update = function(){
		//var workerId  = $scope.workerName;
			                    				                    	
//            alert($("#workerId").val())
//            alert($("#workerName").val())
//            alert($("#workerPhoneNumber").val())
//            alert($("#workerProffession").val())
//            
//            alert($("#workerRate").val())
//            alert($("#workerCity").val())
//            alert($("#workerDistrict").val())
//            alert($("#workerState").val())
//            alert($("#workerAddress").val())
//            alert($("#workerAvailablity").val())
		// workerId (N) workerAddress (S) workerAvailablity (S) workerCity (S)
	// workerDistrict (S)
	// workerEmail (S) workerName (S) workerPhoneNumber (N) workerProffession
	// (S) workerRate (N) workerState (S)
            $scope.update = function(){
        		
        		var worker = 
                    { 
        				'workerId':$("#workerId").val(),           
                    	'workerName':$("#workerName").val(),
                    	'workerEmail':$("#workerEmail").val(),
                    	'workerPhoneNumber':$("#workerPhoneNumber").val(),
                    	'workerProffession':$("#workerProffession").val(),
                    	'workerRate':$("#workerRate").val(),
                    	'workerCity':$("#workerCity").val(),
                    	'workerDistrict':$("#workerDistrict").val(),
                    	'workerState':$("#workerState").val(),
                    	'workerAddress':$("#workerAddress").val(),
                    	'workerAvailablity':$("#workerAvailablity").val(),
                    	
                    	};
                    			                    				                    	
        		alert(worker)
        		$http.post('/addEditedWorkerDetails',worker).success(function(response){
        				console.log(response);
        				alert("added successfully")
        			});
        	}
	}


} ]);
