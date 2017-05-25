
    <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBbdjQPGY-cOqdoZkPl5WNodYOWQEQ3E_8"></script>
  <head>
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

	<script src="static/js/app/workerdetailmap/workerDetailMap.js"></script>
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
     	<li style ="display:inline-block;"><a  class="btn btn-primary" href="/register">Home/Worker Details .. </a></li>
</div>


  </body>
