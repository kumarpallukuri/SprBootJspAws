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
	



} ]);

