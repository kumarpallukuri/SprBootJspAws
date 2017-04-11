<!DOCTYPE html>
<html ng-app="myApp">
<head>
	<title>Contact list app</title>
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
<body>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
<script src="/js/controllers.js"></script>

<div class="container" ng-controller="AppCtrl">

<!-- 	<h1>Worker details</h1> -->
	<button class="btn btn-primary"  ng-click="/register" >Add Contacts.. </button>
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
		<tr>
<!-- 			<td><input class="form-control" ng-model="contact.name"> </td> -->
<!-- 			<td><input class="form-control" ng-model="contact.email"> </td> -->
<!-- 			<td><input class="form-control" ng-model="contact.number"> </td> -->
<!-- 			<td><button class="btn btn-primary"  ng-click="addContact()" >Add Contacts.. </button> </td> -->
<!-- 			<td><button class="btn btn-info"  ng-click="update()" >Update</button> </td> -->
<!-- 			<td><button class="btn btn-info"  ng-click="clear()" >Clear</button> </td> -->
			<tr ng-repeat="worker in Workers">
					<td>{{worker.workerName}}</td>
					<td>{{worker.workerName}}</td>
					<td>{{worker.workerEmailID}}</td>
					<td>{{worker.workerPhoneNumber}}</td>
					<td>{{worker.workerField}}</td>
					<td><button class="btn btn-danger"  ng-click="remove(contact._id)" ng-model="contact.name">Remove</button> </td>
					<td><button class="btn btn-warning"  ng-click="edit(worker.workertID)" >Edit</button> </td>
			</tr>
		</tbody>
		
	</table>
</div>
</body>
</html>