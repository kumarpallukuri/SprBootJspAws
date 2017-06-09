wtApp.controller('loginController', [ '$scope', function($scope) {
	//submit the form
	$scope.submitForm =  function(){
		document.loginform.submit();
	}
} ]);