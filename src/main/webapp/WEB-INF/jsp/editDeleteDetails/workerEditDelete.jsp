<!DOCTYPE html>
<html ng-app="myApp">
<head>
	<title>WorkerDetails</title>
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
<body>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.15/angular-ui-router.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>
<script src="/js/editDeleteDetails/workerEditDelete.js"></script>


<div class="container" ng-controller="AppCtrl">

	<h1>Workers Edit or Delete Details</h1>
	<div style ="display:inline-block;"> 
	<li style ="display:inline-block;"><a  class="btn btn-primary"  href="/addWorkerDetails" >Add Contact.. </a></li>
	<li style ="display:inline-block;"><a  class="btn btn-primary" href="/register">Home/Worker Details .. </a></li>
	</div>
	
	<div id="editValue"  ng-show ="showAll">		
			<table>
					<tr>
						<td> Name</td> &nbsp;&nbsp;
						<td><input class="form-control" ng-model="workerName"></td>
					</tr>
					<tr>
						<td>Proffession</td> &nbsp;&nbsp;
						<td><input class="form-control" ng-model="workerProffession"></td>
					</tr>
					
					<tr>
						<td>Email Address</td>&nbsp;&nbsp;
						<td><input class="form-control" ng-model="workerEmail"></td>
						
					</tr>
					<tr>
						<td>Mobile Number</td>&nbsp;&nbsp;
						<td><input class="form-control" ng-model="workerPhoneNumber"></td>
					</tr>
					<tr>
						<td> Address</td>&nbsp;&nbsp;
						<td><input class="form-control" ng-model="workerAddress"> </td>
					</tr>
					
					<tr>
						<td>City</td>&nbsp;&nbsp;
						<td><input class="form-control" ng-model="workerCity"> </td>
					</tr>
					
					<tr>
						<td>District</td>&nbsp;&nbsp;
						<td><input class="form-control" ng-model="workerDistrict"></td>
					</tr>
					<tr>
						<td>State</td>&nbsp;&nbsp;
						<td><input class="form-control" ng-model="workerState"> </td>
					</tr>
					<tr>
						<td>Rate</td>&nbsp;&nbsp;
						<td><input class="form-control" ng-model="workerRate"> </td>
					</tr>
					<tr>
						<td>Availablity</td>&nbsp;&nbsp;
						<td><input class="form-control" ng-model="workerAvailablity"> </td>
					</tr>
				
				</table>
				
			<button class="btn btn-info"  ng-click="update(workerName,workerEmail,workerPhoneNumber,workerProffession,
			workerCity,workerAvailablity,workerAddress,workerDistrict,workerState,workerRate)" >update</button> 
			
			<button class="btn btn-info"  ng-click="clear()" >Clear</button> 
			<button class="btn btn-info"  ng-click="close()" >Close</button> 
	</div>
	
	<table class="table">
		<thead>
			<tr>
				<th>Worker Name</th>
				<th>Email </th>
				<th> Phone number </th>
				<th> Proffession </th>
				<th> City </th>
				<th>&nbsp</th>
				<th>&nbsp</th>
			 </tr>
		</thead>
		<tbody>
		
			<tr ng-repeat="worker in Workers">
					<td>{{worker.workerName}}</td>
					<td>{{worker.workerEmail}}</td>
					<td>{{worker.workerPhoneNumber}}</td>
					<td>{{worker.workerProffession}}</td>
					<td>{{worker.workerCity}}</td>
					<input type="hidden" value={worker} id="workerObject"/>
					<td><button class="btn btn-danger"  ng-click="remove(worker.workerId,worker.workerPhoneNumber)" ng-model="contact.name">Remove</button> </td>
					<td>	<li><a  class="btn btn-warning" ng-click="edit(worker,worker.workerId,worker.workerName,worker.workerEmail,worker.workerPhoneNumber,worker.workerProffession,worker.workerCity)">Edit Details </a></li></td>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>