var myApp = angular.module('myApp', []);
myApp.controller('AppCtrl', ['$scope', '$http', function($scope, $http) {
	alert("hii")
	$scope.contactsArr = [];
	 refresh();
function(){
	   alert("hi2")
	   console.log("get called")
		$http.get('/user').success(function(response){
			$scope.contactlist = response;
			$scope.contactsArr = response;
			alert($scope.contactsArr);
		});
   };
//   refresh();
//	$scope.addContact = function(){
//		console.log($scope.contact);
//		$http.post('/contactlist',$scope.contact).success(function(response){
//			console.log(response);
//			$scope.contactsArr.push($scope.contact);
//			refresh();
//		});
//		$scope.contact =  "";
//	}
//	$scope.remove = function(id){
//		console.log(id);
//		$http.delete('/contactlist/'+ id).success(function(response){
//				console.log(response);
//				refresh();
//			$scope.removeFromArr(id);
//			});
//	}
//	$scope.edit = function(id){
//		console.log(id);
//		$http.get('/contactlist/'+ id).success(function(response){
//			 $scope.contact = response;
//				console.log(response);
//				refresh();
//			});
//	}
//	
//	$scope.email = function(){
//		$http.get('/contactlist/email').sucess(function(response){
//			console.log("mail sent sucessfully")
//		});
//	}
//   
//   $scope.update = function(){
//		console.log($scope.contact._id);
//		$http.put('/contactlist/'+ $scope.contact._id,$scope.contact).success(function(response){
//				console.log(response);
//				$scope.contactsArr = response;
//			refresh();
//			});
//			$scope.contact =  "";
//	}
//	$scope.clear = function(){
//		$scope.contact =  "";
//	}
//	
//	//removes a specific contact from the list that is scope bound
//	$scope.removeFromArr = function(id){
//		angular.forEach($scope.contactsArr,function(contact){
//			if(id===contact._id){
//				var index = $scope.contactsArr.indexOf(contact);
//				$scope.contactsArr.splice(index, 1);
//			}
//		})
//	}
   
   }]);
