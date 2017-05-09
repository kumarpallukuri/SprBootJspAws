<!DOCTYPE html >
<html >
    <script src="http://maps.googleapis.com/maps/api/js?key="></script>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="Simple Map">
<meta name="keywords" content="ng-map,AngularJS,center">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <title>Worker Details</title>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
    height:420px;
    width:600px;
    aligin:left;
    padding:100px,200px,300px,0px;
}
.infoWindowContent {
    font-size:  14px !important;
    border-top: 1px solid #ccc;
    padding-top: 10px;
}
h2 {
    margin-bottom:0;
    margin-top: 0;
}
    </style>
  </head>
  
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.15/angular-ui-router.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>
	
	<script src="/js/workerdetailmap/workerdetailmap.js"></script>
  <body>
    <br>
    <br>
 <div ng-app="mapsApp" ng-controller="MapCtrl">
    <div id="map"></div>
    <div id="markerIdDiv">
<!--          <a href="#" ng-click="openInfoWindow($event, marker)">{{marker.title}}</a> -->
    </div>
    
    <p>
    Enter your  City Name to locate Workers near you
			<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="text" name="city" ng-model="city" id="cityName"
				ng-click="buttonEnableValidation()"  ng-pattern="/^[a-zA-Z]$/" />
				
				 <span style="color: red"
				ng-show="myForm.city.$error.pattern">Do not enter any numbers
				or special characters.</span>
		</p>
    
    <li style ="display:inline-block;"><a  class="btn btn-warning" href="#" ng-click="locateMe()">Locate me.. </a></li>
     <li style ="display:inline-block;"><a  class="btn btn-warning" href="#" ng-click="reset()">Reset. </a></li>
</div>

    <script>
     
    </script>

  </body>
</html>