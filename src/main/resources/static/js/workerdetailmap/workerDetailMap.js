//Data
var cities = [
    
];
var latNew = "";
var lngNewv ="";
//Angular App Module and Controller
angular.module('mapsApp', [])
.controller('MapCtrl', [ '$scope', '$http',function ($scope, $http) {

    var mapOptions = {
        zoom: 4,
        center: new google.maps.LatLng(40.0000, -98.0000),
        mapTypeId: google.maps.MapTypeId.TERRAIN
    }

    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);

    $scope.markers = [];
    
    var infoWindow = new google.maps.InfoWindow();
	$scope.locateMe =  function(){
//		$http.get("/workerDetails").success(function(response) {
//			// alert(JSON.stringify(response));
//			console.log(JSON.stringify(response))
//			$scope.cities = response;
//			
//		}).error(function(response, status, headers, config) {
//			alert('cannot find resource');
//		});
		var cities = [
		    {
		        workerCity : 'tirupathi',
		        workerProffession : 'www.google.com',
		       lat : 43.7000,
		        long : -79.4000
		    }
		    ]
		 var geocoder =  new google.maps.Geocoder();
	      
		  geocoder.geocode( { 'address': 'tirupathi, india'}, function(results, status) {
              if (status == google.maps.GeocoderStatus.OK) {
           	   latNew = results[0].geometry.location.lat();
           	lngNewv = results[0].geometry.location.lng();
                console.log("location : " + results[0].geometry.location.lat() + " " +results[0].geometry.location.lng()); 
                createMarker(cities[0]);
              } else {
            	  console.log("Something got wrong " + status);
              }
            });
	}
    
    var createMarker = function (info){
        console.log("info" +info.workerProffession)
    	
       
         console.log("infooo " + latNew, lngNewv);
        var marker = new google.maps.Marker({
            map: $scope.map,
            position: new google.maps.LatLng(latNew, lngNewv),
            title: info.workerCity
        });
        marker.content = '<div class="infoWindowContent">' + info.workerProffession + '</div>';
        
       
        
        google.maps.event.addListener(marker, 'click', function(){
            infoWindow.setContent('<h2>' + marker.title + '</h2>' + marker.content);
            infoWindow.open($scope.map, marker);
        });
        
        $scope.markers.push(marker);
        
    }  
    
    for (i = 0; i < cities.length; i++){
        createMarker(cities[i]);
    }

    $scope.openInfoWindow = function(e, selectedMarker){
        e.preventDefault();
        google.maps.event.trigger(selectedMarker, 'click');
    }

}]);