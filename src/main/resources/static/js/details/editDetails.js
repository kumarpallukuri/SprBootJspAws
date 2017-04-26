var myApp = angular.module('myApp', []);
myApp.controller('AppCtrl', [ '$scope', '$http', function($scope, $http) {
	alert("sss")
	$scope.update = function(){
		//var workerId  = $scope.workerName;
			                    				                    	
            alert($("#user").val())
		
//		$http.post('/workerDetail',worker).success(function(response){
//			 $scope.contact = response;
//				console.log(response);
//				$scope.showAll = false;
//				refresh();
//			});
	}


} ]);
