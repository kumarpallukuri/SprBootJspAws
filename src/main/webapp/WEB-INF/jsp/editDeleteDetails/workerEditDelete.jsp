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

	<h1>Worker detailsss</h1> 
	<li><a  class="btn btn-primary"  href="/addWorkerDetails" >Add Contact.. </a></li>
	<li><a  class="btn btn-primary" href="/register">Home/Worker Details .. </a></li>
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
		<tr id="editValue"  ng-show ="showAll">
		<td><input class="form-control" ng-model="workerName" value="Bob" text ="ddf"> </td> 
			<td><input class="form-control" ng-model="workerEmail"> </td> </br>
			<td><input class="form-control" ng-model="workerPhoneNumber"> </td> </br>
			<td><input class="form-control" ng-model="workerProffession"> </td> </br>
			<td><input class="form-control" ng-model="workerCity"> </td> </br>
			<td><button class="btn btn-info"  ng-click="update(workerName,workerEmail,workerPhoneNumber,workerProffession,workerCity)" >update</button> </td> 
			
			<td><button class="btn btn-info"  ng-click="clear()" >Clear</button> </td> 
			<td><button class="btn btn-info"  ng-click="close()" >Close</button> </td> 
			</tr>
			<tr ng-repeat="worker in Workers">
					<td>{{worker.workerName}}</td>
					<td>{{worker.workerEmail}}</td>
					<td>{{worker.workerPhoneNumber}}</td>
					<td>{{worker.workerProffession}}</td>
					<td>{{worker.workerCity}}</td>
					<input type="hidden" value={worker} id="workerObject"/>
					<td><button class="btn btn-danger"  ng-click="remove(worker.workerId,worker.workerPhoneNumber)" ng-model="contact.name">Remove</button> </td>
					<td>	<li><a  class="btn btn-warning" href="/editDetails/{{worker.workerId}}">Edit Details </a></li></td>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>