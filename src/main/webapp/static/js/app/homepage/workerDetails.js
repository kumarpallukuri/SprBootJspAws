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
	
	$scope.filterDetails =  function(){
		var filterString = $("#filterDropDown").val()+"_"+$("#filterTextValue").val();
		$http.get('/filterDetails/'+filterString).success(function(response){
			 $scope.Workers = response;
				console.log(response);
				//refresh();
			});
	}



} ]);

var filterValues = ["workerProffession","workerCity"];


$(function() {
	  var options = '';
	  for (var i = 0; i < filterValues.length; i++) {
	      options += '<option value="' + filterValues[i] + '">' + filterValues[i] + '</option>';
	  }
	  $('#filterDropDown').html(options);
	});

