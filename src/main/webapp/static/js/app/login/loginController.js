var wtApp = angular.module('wtApp', []);

wtApp.controller('loginController', [ '$scope', '$http', function($scope, $http) {
	//submit the form
	$scope.submitForm =  function(){
		document.loginform.submit();
	}
} ]);