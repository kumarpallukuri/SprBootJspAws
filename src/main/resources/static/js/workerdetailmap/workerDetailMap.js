//Data
var latNew = "";
var lngNewv ="";
 var cities =[];
//Angular App Module and Controller
angular.module('mapsApp', [])
.controller('MapCtrl', [ '$scope', '$http',function ($scope, $http) {
	
    var mapOptions = {
        zoom: 5,
        center: new google.maps.LatLng(21.7679, 78.8718),
        mapTypeId: google.maps.MapTypeId.TERRAIN
    }

    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);
    $scope.markers = [];
    var infoWindow = new google.maps.InfoWindow();
    $scope.reset =  function(){
    	console.log("reset...")
    	$( ".markersLink" ).remove();
    	$( ".markersLinkBreak").remove();
            for(i=0; i<$scope.markers.length; i++){
            	$scope.markers[i].setMap(null);
            }
    }
	$scope.locateMe =  function(){
		var workers = [];
		var json ="";
		$http.get("/workerDetails").success(function(response) {
			workers = response;
			 json = JSON.stringify(response);
			 json = angular.toJson(response);
			
			for( i=0;i<workers.length;i++){
				constructCitiArray(workers[i]);
			}
			
		}).error(function(response, status, headers, config) {
			alert('cannot find resource');
		});
		console.log("ss"+json[0]);
		$( ".markersLink" ).remove();
    	$( ".markersLinkBreak").remove();
	
    
    var createMarker = function (info,indexValue){
      //  console.log("info" +info)
    	
       
        // console.log("infooo " + latNew, lngNewv);
        var marker = new google.maps.Marker({
            map: $scope.map,
            position: new google.maps.LatLng(latNew, lngNewv),
           // url: 'http://www.google.com/',
            title: info.workerProffession
        });
        var idValue = "infoWindowContent"+indexValue;
       // marker.content = '<div class="infoWindowContent">' + info.workerProffession + '</div>';
        marker.url = 'http://localhost:8080/fullWorkerDetail/'+info.workerId;
        console.log("indexValueaa"+indexValue)
   
        //$("#marker").append('<a href="' + $(this).html() + '">'+$(this).html()+'</a>');
      
        
        google.maps.event.addListener(marker, 'click', function(){
            infoWindow.setContent('<h2>' + marker.title + '</h2>' + marker.content);
            infoWindow.open($scope.map, marker);
            window.location.href = marker.url;
            //window.open(this.url, '_blank');
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
    function constructCitiArray(workers){
    	console.log(workers.workerProffession)
		
		//for (i = 0; i < cities.length; i++){
	       var url ='http://localhost:8080/fullWorkerDetail/'+workers.workerId;
			  $("#markerIdDiv").append('<a style="width:200px;height:200px;" class="markersLink"  href="' +url + '">' + workers.workerProffession + '</a><br class="markersLinkBreak">');
              
			 var geocoder =  new google.maps.Geocoder();
		      var cityAddress = workers.workerCity+","+"india";
		   //   console.log(cityAddress);
		      var indexValue = i;
			  geocoder.geocode( { 'address': cityAddress}, function(results, status) {
	              if (status == google.maps.GeocoderStatus.OK) {
	           	   latNew = results[0].geometry.location.lat();
	           	lngNewv = results[0].geometry.location.lng();
	               // console.log("location : " + results[0].geometry.location.lat() + " " +results[0].geometry.location.lng());
	               // console.log("cities" +cities[indexValue])
	                createMarker(workers,indexValue);
	               // var id="test"+
	                console.log("testttt")
	              
	              } else {
	            	  console.log("Something got wrong " + status);
	              }
	            });
		  
		//}
	}
    }

}]);