<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBbdjQPGY-cOqdoZkPl5WNodYOWQEQ3E_8"></script>
<script src="static/js/app/workerdetailmap/workerDetailMap.js"></script>


 <div ng-app="mapsApp" ng-controller="MapCtrl">
 	<button id="WorkerDetailsBackButton" onclick="window.location.href='/register'" class="btn btn-default btn-primary center-block pull-left">Back to Worker Details</button>
    <div id="map"></div>
    <div id="markerIdDiv">
<!--          <a href="#" ng-click="openInfoWindow($event, marker)">{{marker.title}}</a> -->
    </div>
</div>