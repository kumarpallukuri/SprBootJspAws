<!DOCTYPE html>
<html ng-app="myApp">
<head>
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
<body>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.15/angular-ui-router.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>
<script src="/js/homepage/workerDetails.js"></script>
<script language="Javascript" src="/js/common/jquery.js"></script>

<div class="container" ng-controller="AppCtrl">

<!-- 	<h1>Worker details</h1> --> 
	<div style ="display:inline-block;">
		<li style ="display:inline-block;"><a  class="btn btn-info" href="/addWorkerDetails">Add workerDetails.. </a></li>
		<li style ="display:inline-block;"><a  class="btn btn-info" href="/registartionSucess">Update/Delete workerDetails.. </a></li>
		<li style ="display:inline-block;"><a  class="btn btn-info" href="/locateWorkers">Locate Workers</a></li>
	</div>
	<br>
	<br>
	<div id="filter">
	
 	&nbsp;Filter By:   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select id="filterDropDown" ng-model="filter" ></select>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
 	<input type ="text" ng-model="filterValue"  id="filterTextValue"/> &nbsp; &nbsp; 
 	<li style ="display:inline-block;"><a  class="btn btn-warning" href="#" ng-click="filterDetails()">Filter workerDetails.. </a></li>
 	&nbsp; &nbsp; <li style ="display:inline-block;"><a  class="btn btn-info" href="#" ng-click="reset()">Reset.. </a></li>
    </div>

	<br>
	<br>
	<table class="table">
		<thead>
			<tr>
				<th>Worker Name </th>
				<th> Email </th>
				<th> Phone number </th>
				<th> Proffession </th>
				<th> City </th>
				
			 </tr>
		</thead>
		<tbody>
		
			<tr ng-repeat="worker in Workers">
					<td><a  href="/fullWorkerDetail/{{worker.workerId}}">{{worker.workerName}}</a></td>
					<td>{{worker.workerEmail}}</td>
					<td>{{worker.workerPhoneNumber}}</td>
					<td><b>{{worker.workerProffession}}</b></td>
					<td>{{worker.workerCity}}</td>
			</tr>
		</tbody>
	</table>
</div>


</body>
</html>