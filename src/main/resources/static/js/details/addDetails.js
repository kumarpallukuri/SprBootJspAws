var myApp = angular.module('myApp', []);


myApp.controller('AppCtrl', [ '$scope', '$http', function($scope, $http) {
	//$('.news').hide();
	$scope.Workers = [];
	$scope.showAll = false;
	$scope.id ="";
	$scope.workerName = "";
	$scope.emailAddress=";"
	$scope.phoneNumbr = /^\+?\d{2}[- ]?\d{3}[- ]?\d{5}$/;
	function email() {
		return {
		    restrict: 'A',
		    require: 'ngModel',
		    link: function (scope, elem, attrs, ctrl) {
		        if (!ctrl) {
		            return false;
		        }

		        function isValidEmail(value) {
		            if (!value) {
		                return false;
		            }
		            // Email Regex used by ASP.Net MVC
		            var regex = /^[\w-]+(\.[\w-]+)*@([a-z0-9-]+(\.[a-z0-9-]+)*?\.[a-z]{2,6}|(\d{1,3}\.){3}\d{1,3})(:\d{4})?$/i;
		            return regex.exec(value) != null;
		        }

		        scope.$watch(ctrl, function () {
		            ctrl.$validate();
		        });

		        ctrl.$validators.email = function (modelValue, viewValue) {
		            return isValidEmail(viewValue);
		        };
		    }
		};
		}


} ]);

