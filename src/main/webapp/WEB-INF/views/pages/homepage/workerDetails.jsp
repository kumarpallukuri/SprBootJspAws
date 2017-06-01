<script src="static/js/app/homepage/workerDetails.js"></script>

<div ng-app="myApp" ng-controller="AppCtrl" class="table-responsive">

	<button class="btn btn-default btn-primary center-block pull-left marginB16" onclick="window.location.href='/locateWorkers'">Locate Workers</button>
	<table class="table table-bordred table-striped">
		<thead class="table-inverse">
			<tr>
				<th>#</th>
				<th>Profession</th>
				<th>Worker Details</th>
				<th></th>
				<!-- <th>Email</th> -->
				<!-- <th>Phone number</th>
				<th>City</th> -->
				
			 </tr>
		</thead>
		<tbody>
			<tr ng-repeat="worker in Workers">
					<td>{{ $index+1 }}</td>
					<td><strong>{{worker.workerProffession}}</strong></td>
					<td>
						<div>{{worker.workerName}}</div>
						<div class="smallFont">{{worker.workerPhoneNumber}}</div>
						<div class="smallFont">{{worker.workerCity}}</div>
					</td>
					<td><a class="smallFont" href="/fullWorkerDetail/{{worker.workerId}}"><span class="anchorText">View full details</span></a></td>
					<!-- <td>{{worker.workerEmail}}</td> -->
					<!-- <td>{{worker.workerPhoneNumber}}</td>
					<td>{{worker.workerCity}}</td> -->
			</tr>
		</tbody>
	</table>
</div>



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