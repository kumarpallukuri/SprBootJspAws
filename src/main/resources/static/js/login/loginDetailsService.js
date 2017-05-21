////var app = angular.module('myApp', []);
//myApp.service('loginSevice', function ()  {
//
//	$scope.addDetails = function() {
//
////		console.log("user -->" + $scope.user)
////		console.log("email -->" + $scope.email)
////		console.log("phone -->" + $scope.phone)
////		console.log("proffession -->" + $scope.proffession)
////		console.log("city -->" + $scope.city)
////
////		var worker = {
////			'workerName' : $scope.user,
////			'workerEmail' : $scope.email,
////			'workerPhoneNumber' : $scope.phone,
////			'workerProffession' : $scope.proffession,
////			'workerCity' : $scope.city,
////			'workerAvailablity' : $scope.availabilty,
////			'workerAddress' : $scope.address,
////			'workerDistrict' : $scope.district,
////			'workerState' : $scope.state,
////			'workerRate' : $scope.rate,
////
////		};
//
//		
//		
//		 this.save = function (loginDetails) {
//			 alert(loginDetails)
////		        if (loginDetails.workerId == null) {
////		            //if this is new contact, add it in contacts array
////		        	$http.post('/login', loginDetails).success(function(response) {
////		    			$scope.contact = response;
////		    			alert("Details Added sucessfully..!")
////		    			//refresh();
////		    		});
////		        } 
//
//		    }
//
//	}
//
//} );
myApp.service('loginService', function ($http) {
    
    //save method create a new contact if not already exists
    //else update the existing object
    this.login = function (contact) {
    	alert("sss")
    			var loginDetailsForm = {
			'emailID' : "ksware3@gmail.com",
			'fullProfile' : "No",
			'password' : "kumarTest",
			'phoneNumber' : 8939933393
			

		};
	$http.post('/login', loginDetailsForm).success(function(response) {
	//$scope.contact = response;
	alert("Details Added sucessfully..!")
	//refresh();
});
    }

    //simply search contacts list for given id
    //and returns the contact object if found
    this.get = function (id) {
        for (i in contacts) {
            if (contacts[i].id == id) {
                return contacts[i];
            }
        }

    }
    
    //iterate through contacts list and delete 
    //contact if found
    this.delete = function (id) {
        for (i in contacts) {
            if (contacts[i].id == id) {
                contacts.splice(i, 1);
            }
        }
    }

    //simply returns the contacts list
    this.list = function () {
        return contacts;
    }
});

//var CalculatorService = angular.module('CalculatorService', [])
//.service('Calculator', function () {
//    this.square = function (a) { return a*a};
//
//});


