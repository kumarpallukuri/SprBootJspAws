<div ng-app="mapsApp" ng-controller="MapCtrl">
	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">Find Workers near you</h3>
	  </div>
	  <div class="panel-body">
	     <div class="form-group">
	         <input type="text" class="form-control" id="cityName" name="cityName" value="" required="true" placeholder="Enter city name .." title="Please enter the city name to locate workers">
	         <span class="help-block"></span>
	     </div>
	     <div class="inline-buttons">
		     <button id="locateSubmitButton" class="btn btn-default btn-primary center-block" ng-click="locateMe()">Search</button>
		     <button id="locateResetButton" class="btn btn-default btn-primary center-block pull-right" ng-click="reset()">Reset</button>
	     </div>
	  </div>
	</div>
	
	<div id="worker_search_results" class="panel panel-default hidden">
	  <div class="panel-heading">
	    <h3 class="panel-title">Workers Found</h3>
	  </div>
	  <div class="panel-body">
	  	<ul class="list-group" id="worker_results_list"></ul>
	  </div>
	</div>
</div>


