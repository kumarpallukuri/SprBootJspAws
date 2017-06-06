var myApp = angular.module('myApp', []);

//https://patrickgrimard.io/2014/05/16/pagination-with-spring-data-and-hateoas-in-an-angularjs-app/
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
	
	$scope.filterChange =  function(){
		//alert("filter change "+$scope.filter);
		if($scope.filter === "----Select----"){
			$("#filterTextValueDiv").addClass("hidden");
		}else{
			if($("#filterTextValueDiv").hasClass("hidden")){
				$("#filterTextValueDiv").removeClass("hidden");
			}
		}
	}



} ]);

var filterValues = ["----Select----","Proffession","City"];


$(function() {
	  var options = '';
	  for (var i = 0; i < filterValues.length; i++) {
	      options += '<option value="' + filterValues[i] + '">' + filterValues[i] + '</option>';
	  }
	  $('#filterDropDown').html(options);
	});

