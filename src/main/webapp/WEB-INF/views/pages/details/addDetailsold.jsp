<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


  <script src="static/js/app/details/addDetails.js"></script>
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

</body>