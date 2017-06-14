wtApp.controller('homePageController', [ '$scope', '$http', function($scope, $http) {
	$scope.profession = '';
	$scope.city = '';
	$scope.searchForWorkers = function(){
		if($scope.profession === '' || $scope.city === ''){
			return false;
		}else{
			alert("submit");
		}
	}
	
}]);