<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="myApp">
<head>




<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.15/angular-ui-router.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>
<script src="/js/details/editDetails.js"></script>


<div class="container" ng-controller="AppCtrl">

		<table>
					<tr>
						<td> Name</td> &nbsp;&nbsp;
						<td><input type="text" value=${workerName}  id="workerName"/></td>
					</tr>
					<tr>
						<td>Proffession</td> &nbsp;&nbsp;
						<td><input type="text" value=${workerProffession} id="workerProffession"/></td>
					</tr>
					
					<tr>
						<td>Email Address</td>&nbsp;&nbsp;
					<td>	<input type="email"  value=${workerEmail} id="workerEmail" /></td>
						
					</tr>
					<tr>
						<td>Mobile Number</td>&nbsp;&nbsp;
						<td><input type="text" value=${workerPhoneNumber}  id="workerPhoneNumber"/></td>
					</tr>
					<tr>
						<td> Address</td>&nbsp;&nbsp;
						<td><input type="text"value=${workerAddress}  id="workerAddress"/></td>
					</tr>
					
					<tr>
						<td>City</td>&nbsp;&nbsp;
						<td><input type="text" value=${workerCity} id="workerCity" /></td>
					</tr>
					
					<tr>
						<td>District</td>&nbsp;&nbsp;
						<td><input type="text" value=${workerDistrict} id="workerDistrict" /></td>
					</tr>
					<tr>
						<td>State</td>&nbsp;&nbsp;
						<td><input type="text" value=${workerState} id="workerState" /></td>
					</tr>
					<tr>
						<td>Rate</td>&nbsp;&nbsp;
						<td><input type="text" value=${workerRate} id="workerRate" /></td>
					</tr>
					<tr>
						<td>Availablity</td>&nbsp;&nbsp;
						<td><input type="text" value=${workerAvailablity} id="workerAvailablity" /></td>
					</tr>
					<tr>
					<td><button class="btn btn-danger"  ng-click="update()">Update</button> </td>
					</tr>
				</table>
			<input type="hidden" value=${workerId}  id="workerId"/>
	</div>
<li><a  class="btn btn-default" href="/register">Back. </a></li>
	
</body>

</html>
