<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<script src="static/js/app/homepage/workerDetails.js"></script>

<div ng-app="myApp" ng-controller="AppCtrl" class="table-responsive">

	<button class="btn btn-default btn-primary center-block pull-left marginB16" onclick="window.location.href='/locateWorkers'">Locate Workers</button>
	
<!-- 	<div class="filterSection pull-right displayInline">
		 Filter By:&nbsp;
		 <select id="filterDropDown" class="displayInline" ng-model="filter" ng-change="filterChange();"></select>
        <div id="filterTextValueDiv" class="input-group displayInlineFlex hidden">
	      <input type="text" class="form-control" ng-model="filterValue" id="filterTextValue" title="Please enter your search" placeholder="Enter your search..">
	      <span class="input-group-btn">
	        <button class="btn btn-default glyphicon glyphicon-search btn-primary center-block cityFilterSearch" type="button" ng-click="filterDetails();"></button>
	      </span>
	    </div>
	</div> -->
	 	
	<table class="table table-bordred table-striped">
		<thead class="table-inverse">
			<tr>
				<th>#</th>
				<th>Profession</th>
				<th>Worker Details</th>
				<th></th>
			 </tr>
		</thead>
		<tbody>
			<c:forEach items="${workers}" var="worker" varStatus="index"> 
				<tr>
					<td>${index.index}</td>
					<td><strong>${worker.workerProffession}</strong></td>
					<td>
						<div class="smallFont">${worker.workerName}</div>
						<div class="smallFont">${worker.workerPhoneNumber}</div>
						<div><strong>${worker.workerCity}</strong></div>
					</td>
					<td><a class="smallFont" href="/fullWorkerDetail/${worker.workerId}"><span class="anchorText">View full details</span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- 
	<div id="filter">
	

	 	
	 	<li style ="display:inline-block;"><a  class="btn btn-warning"  ng-click="filterDetails()">Filter workerDetails.. </a></li>
	 	<li style ="display:inline-block;"><a  class="btn btn-info"  ng-click="reset()">Reset.. </a></li>
	 	<li style ="display:inline-block;"><a  class="btn btn-info"  ng-click="loginUser()">Login.. </a></li>
 	
    </div> -->