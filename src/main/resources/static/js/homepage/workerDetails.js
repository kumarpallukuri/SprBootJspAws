var myApp = angular.module('myApp', []);


myApp.controller('AppCtrl', [ '$scope', '$http', function($scope, $http) {
	//$('.news').hide();
	$scope.Workers = [];
	$scope.showAll = false;
	$scope.id ="";
	$scope.workerName = "";
	$http.get("/workerDetails").success(function(response) {
		// alert(JSON.stringify(response));
		$scope.Workers = response;
	}).error(function(response, status, headers, config) {
		alert('cannot find resource');
	});
	
	$scope.reset =  function(){
		$http.get("/workerDetails").success(function(response) {
			// alert(JSON.stringify(response));
			$scope.Workers = response;
		}).error(function(response, status, headers, config) {
			alert('cannot find resource');
		});
	}
	
	$scope.filterDetails =  function(filterString){
		$http.get('/filterDetails/'+filterString).success(function(response){
			 $scope.Workers = response;
				console.log(response);
				//refresh();
			});
	}



} ]);

