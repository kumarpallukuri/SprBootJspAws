<!DOCTYPE html>
<html ng-app="myApp">

<body>

<script src="static/js/app/homepage/workerDetails.js"></script>

<div class="" ng-controller="AppCtrl">
<script src="/js/login/loginDetailsService.js"></script>

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
 	<li style ="display:inline-block;"><a  class="btn btn-warning"  ng-click="filterDetails()">Filter workerDetails.. </a></li>
 	&nbsp; &nbsp; <li style ="display:inline-block;"><a  class="btn btn-info"  ng-click="reset()">Reset.. </a></li>
 	&nbsp; &nbsp; <li style ="display:inline-block;"><a  class="btn btn-info"  ng-click="loginUser()">Login.. </a></li>
    </div>

	<br>
	<br>
	<table class="table">
		<thead>
			<tr>
				<th>Worker Name</th>
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