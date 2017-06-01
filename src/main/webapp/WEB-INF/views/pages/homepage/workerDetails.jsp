<script src="static/js/app/homepage/workerDetails.js"></script>

<div ng-app="myApp" ng-controller="AppCtrl">

<!-- 	<div style ="display:inline-block;">
		<li style ="display:inline-block;"><a  class="btn btn-info" href="/addWorkerDetails">Add workerDetails.. </a></li>
		<li style ="display:inline-block;"><a  class="btn btn-info" href="/registartionSucess">Update/Delete workerDetails.. </a></li>
		<li style ="display:inline-block;"><a  class="btn btn-info" href="/locateWorkers">Locate Workers</a></li>
	</div> -->

<!-- 	<div id="filter">
	
	 	Filter By:   <select id="filterDropDown" ng-model="filter" ></select>
	 	<input type ="text" ng-model="filterValue"  id="filterTextValue"/> 
	 	
	 	<li style ="display:inline-block;"><a  class="btn btn-warning"  ng-click="filterDetails()">Filter workerDetails.. </a></li>
	 	<li style ="display:inline-block;"><a  class="btn btn-info"  ng-click="reset()">Reset.. </a></li>
	 	<li style ="display:inline-block;"><a  class="btn btn-info"  ng-click="loginUser()">Login.. </a></li>
 	
    </div> -->

	<table class="table">
		<thead>
			<tr>
				<th>Worker Name</th>
				<th>Email</th>
				<th>Phone number</th>
				<th>Profession</th>
				<th>City</th>
				
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