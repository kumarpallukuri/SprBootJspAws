var myApp = angular.module('myApp', []);
myApp.controller('AppCtrl', [ '$scope', '$http', function($scope, $http) {
	//$('.news').hide();
	$scope.showAll = false;
	$scope.id ="";
	$scope.workerName = "";
	$http.get("/workerDetails").success(function(response) {
		// alert(JSON.stringify(response));
		$scope.Workers = response;
	}).error(function(response, status, headers, config) {
		alert('cannot find resource');
//		console.log(response);
//		console.log(status);
//		console.log(headers);
//		console.log(confiq);
	});
	
	$scope.edit = function(id,workerName,workerEmailID,workerPhoneNumber,workerField){
		$scope.showAll = true;
		$scope.id = id;
//		alert(id+"d"+name);
//	//	$("editValue").prop('disabled', true);
//		// $("#displayPanel div").removeClass('someClass');
//		//$('.news').show();
		//$scope.showAll = true;
		$scope.workerName = workerName;
		$scope.workerName = workerName;
		$scope.workerEmailID = workerEmailID;
		$scope.workerPhoneNumber = workerPhoneNumber;
		$scope.workerField = workerField;
//		$http.get('/workerDetail/'+ id).success(function(response){
//			 $scope.contact = response;
//				console.log(response);
//				//refresh();
//			});
	}
	
	$scope.update = function(workerName,workerEmailID,workerPhoneNumber,workerField){
		alert(workerName);
		var id  = $scope.id;
	//	$("editValue").prop('disabled', true);
		// $("#displayPanel div").removeClass('someClass');
		//$('.news').show();
		//$scope.showAll = true;
		var workers = 
            { 'workerName':workerName,
            	'workerEmailID':workerEmailID,
            	'workerPhoneNumber':workerPhoneNumber,
            	'workerField':workerField}
            			                    				                    	
            ;
		
		$http.post('/workerDetail',workers).success(function(response){
			 $scope.contact = response;
				console.log(response);
				//refresh();
			});
	}
	$scope.close = function(){
		$scope.showAll = false;
	}
	$scope.add = function(){
		$scope.showAll = true;
	}

} ]);
