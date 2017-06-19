wtApp.controller('homePageController', [ '$scope', '$http', function($scope, $http) {
	$scope.profession = '';
	$scope.city = '';
	$scope.searchForWorkers = function(){
		if($scope.profession === '' || $scope.city === '' || $scope.profession == undefined || $scope.city == undefined){
			return false;
		}else{
			window.location = "/homeFilterDetails/"+$scope.profession+"_"+$scope.city;
		}
	}
	
}]);