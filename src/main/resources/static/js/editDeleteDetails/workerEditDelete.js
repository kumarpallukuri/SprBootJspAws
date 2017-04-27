var myApp = angular.module('myApp', []);
myApp.controller('AppCtrl', [ '$scope', '$http', function($scope, $http) {
	$scope.showAll = false;
	$scope.workerId ="";
	$scope.workerName = "";
	$scope.Workers = [];
	$scope.Worker = "";
	$http.get("/workerDetails").success(function(response) {
		$scope.Workers = response;
	}).error(function(response, status, headers, config) {
		alert('cannot find resource');

	});
	var refresh = function(){
		$http.get("/workerDetails").success(function(response) {
			$scope.Workers = response;
		}).error(function(response, status, headers, config) {
			alert('cannot find resource');

		});
	};
	
	$scope.edit = function(worker,workerId,workerName,workerEmail,workerPhoneNumber,workerProffession,workerCity){
		$scope.showAll = true;
		$scope.worker = worker;
		$scope.workerId = workerId;
		$scope.workerName = workerName;
		$scope.workerEmail = workerEmail;
		$scope.workerPhoneNumber = workerPhoneNumber;
		$scope.workerProffession = workerProffession;
		$scope.workerCity = workerCity;
		$scope.workerAvailablity = worker.workerAvailablity;
		$scope.workerAddress = worker.workerAddress;
		$scope.workerDistrict = worker.workerDistrict;
		$scope.workerState = worker.workerState;
		$scope.workerRate = worker.workerRate;
	}
	$scope.remove =  function(workerId,workerPhoneNumber){
		$http.get('/workerDetailRemove/'+workerId+'/'+workerPhoneNumber).success(function(response){
			 $scope.contact = response;
				console.log(response);
				refresh();
			});
	}
	
	$scope.update = function(workerName,workerEmail,workerPhoneNumber,workerProffession,
			workerCity,workerAvailablity,workerAddress,workerDistrict,workerState,workerRate){
		var workerId  = $scope.workerId;
		var worker = 
            { 
				'workerId':workerId,           
            	'workerName':workerName,
            	'workerEmail':workerEmail,
            	'workerPhoneNumber':workerPhoneNumber,
            	'workerProffession':workerProffession,
            	'workerCity':workerCity,
            	'workerAvailablity':workerAvailablity,
            	'workerAddress':workerAddress,
            	'workerDistrict':workerDistrict,
            	'workerState':workerState,
            	'workerRate':workerRate,
            	
            	}
            			                    				                    	
            ;
		
		$http.post('/workerDetail',worker).success(function(response){
			 $scope.contact = response;
				console.log(response);
				$scope.showAll = false;
				refresh();
			});
	}
	$scope.close = function(){
		$scope.showAll = false;
	}
	$scope.add = function(){
		$scope.showAll = true;
	}

} ]);
