var myApp = angular.module('myApp', []);
myApp.controller('AppCtrl', [ '$scope', '$http', function($scope, $http) {
	$http.get("/workerDetails").success(function(response) {
		// alert(JSON.stringify(response));
		$scope.Workers = response;
	}).error(function(response, status, headers, config) {
		alert('cannot find resource');
		console.log(response);
		console.log(status);
		console.log(headers);
		console.log(confiq);
	});
	
	$scope.edit = function(id){
		alert(id);
		$http.get('/workerDetail/'+ id).success(function(response){
			 $scope.contact = response;
				console.log(response);
				refresh();
			});
	}

} ]);
