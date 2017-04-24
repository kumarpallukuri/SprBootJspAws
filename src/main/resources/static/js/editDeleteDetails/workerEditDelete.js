var myApp = angular.module('myApp', []);
myApp.controller('AppCtrl', [ '$scope', '$http', function($scope, $http) {
	$scope.showAll = false;
	$scope.workerId ="";
	$scope.workerName = "";
	$scope.Workers = [];
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
	
	$scope.edit = function(workerId,workerName,workerEmail,workerPhoneNumber,workerProffession,workerCity){
		$scope.showAll = true;
		$scope.workerId = workerId;
		$scope.workerName = workerName;
		$scope.workerEmail = workerEmail;
		$scope.workerPhoneNumber = workerPhoneNumber;
		$scope.workerProffession = workerProffession;
		$scope.workerCity = workerCity;
	}
	$scope.remove =  function(workerId,workerPhoneNumber){
		$http.get('/workerDetailRemove/'+workerId+'/'+workerPhoneNumber).success(function(response){
			 $scope.contact = response;
				console.log(response);
				refresh();
			});
	}
	$scope.update = function(workerName,workerEmail,workerPhoneNumber,workerProffession,workerCity){
		alert(workerCity);
		var workerId  = $scope.workerId;
		var worker = 
            { 
				'workerId':workerId,           
            	'workerName':workerName,
            	'workerEmail':workerEmail,
            	'workerPhoneNumber':workerPhoneNumber,
            	'workerProffession':workerProffession,
            	'workerCity':workerCity,
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
