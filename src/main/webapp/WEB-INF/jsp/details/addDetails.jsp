<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.15/angular-ui-router.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>
  <script src="/js/details/addDetails.js"></script>
<body>



	<div class="container" ng-controller="AppCtrl">

		<div class="starter-template">
<!-- 			<h1>Registration Form for Marthon</h1> -->
			<h2>Please Enter Details of </h2>
			<li><a  class="btn btn-default" href="/register">Home page/Worker details. </a></li>
			<form:form modelAttribute="registartionDetailsForm"
				action="/addWorkerDetailsValues">
				<table>
					<tr>
						<td> Name</td> &nbsp;&nbsp;
						<td><form:input path="workerName"/></td>
					</tr>
					<tr>
						<td>Proffession</td> &nbsp;&nbsp;
						<td><form:input path="workerProffession" /></td>
					</tr>
					
					<tr>
						<td>Email Address</td>&nbsp;&nbsp;
					<td>	<input type="email" ng-model="$scope.emailAddress" name="newEmailAddress" email/></td>
						
					</tr>
					<tr>
						<td>Mobile Number</td>&nbsp;&nbsp;
						<td><form:input path="workerPhoneNumber" /></td>
					</tr>
					<tr>
						<td> Address</td>&nbsp;&nbsp;
						<td><form:input path="workerAddress" /></td>
					</tr>
					
					<tr>
						<td>City</td>&nbsp;&nbsp;
						<td><form:input path="workerCity" /></td>
					</tr>
					
					<tr>
						<td>District</td>&nbsp;&nbsp;
						<td><form:input path="workerDistrict" /></td>
					</tr>
					<tr>
						<td>State</td>&nbsp;&nbsp;
						<td><form:input path="workerState" /></td>
					</tr>
					<tr>
						<td>Rate</td>&nbsp;&nbsp;
						<td><form:input path="workerRate" /></td>
					</tr>
					<tr>
						<td>Availablity</td>&nbsp;&nbsp;
						<td><form:input path="workerAvailablity" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Add/Edit Person" />
						</td>
					</tr>
				</table>
			</form:form>
		</div>

		<!-- <a href="http://localhost:8080/test3">Register</a> -->
	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
