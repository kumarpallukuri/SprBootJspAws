<!DOCTYPE html>
<html ng-app="myApp">
<head>
	<title>WorkerDetails</title>
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

Optional theme 
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
<script src="/js/controllers.js"></script>


<div class="container" ng-controller="AppCtrl">

	<h1>Worker detailsss</h1> 
	<li><a  class="btn btn-primary"  href="/addWorkerDetails" >Add Contact.. </a></li>
	<li><a  class="btn btn-primary" href="/register">Back. </a></li>
	<table class="table">
		<thead>
			<tr>
				<th>First Name </th>
				<th>Last Name </th>
				<th> Email </th>
				<th> Phone number </th>
				<th> WorkerField </th>
				<th>&nbsp</th>
				<th>&nbsp</th>
			 </tr>
		</thead>
		<tbody>
		<tr id="editValue"  ng-show ="showAll">
		<td><input class="form-control" ng-model="workerName" value="Bob" text ="ddf"> </td> 
			<td><input class="form-control" ng-model="workerName"> </td> 
			<td><input class="form-control" ng-model="workerEmailID"> </td> 
			<td><input class="form-control" ng-model="workerPhoneNumber"> </td> 
			<td><input class="form-control" ng-model="workerField"> </td> 
			<td><button class="btn btn-info"  ng-click="update(workerName,workerEmailID,workerPhoneNumber,workerField)" >update</button> </td> 
			<td><button class="btn btn-info"  ng-click="clear()" >Clear</button> </td> 
			<td><button class="btn btn-info"  ng-click="close()" >Close</button> </td> 
			</tr>
			<tr ng-repeat="worker in Workers">
					<td>{{worker.workerName}}</td>
					<td>{{worker.workerName}}</td>
					<td>{{worker.workerEmailID}}</td>
					<td>{{worker.workerPhoneNumber}}</td>
					<td>{{worker.workerField}}</td>
					<td><button class="btn btn-danger"  ng-click="remove(worker.workertID)" ng-model="contact.name">Remove</button> </td>
					<td><button class="btn btn-warning"  ng-click="edit(worker.workertID,worker.workerName,worker.workerEmailID,worker.workerPhoneNumber,worker.workerField)" >Edit</button> </td>
			</tr>
		</tbody>
		
	</table>
</div>
</body>
</html>