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
<body>



	<div class="container">

		<div class="starter-template">
<!-- 			<h1>Registration Form for Marthon</h1> -->
			<h2>Please Enter Details of </h2>
<li><a  class="btn btn-default" href="/register">Back. </a></li>
			<form:form modelAttribute="registartionDetailsForm"
				action="/addWorkerDetailsValues">
				<%--     <form:hidden path="id"/>  --%>
				<table>
					<tr>
						<td>First Name</td> &nbsp;
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><form:input path="lastName" /></td>
					</tr>
					
					<tr>
						<td>Email Address</td>
						<td><form:input path="emailAdress" /></td>
					</tr>
					<tr>
						<td>Mobile Number</td>
						<td><form:input path="mobileNumber" /></td>
					</tr>
					<tr>
						<td>Worker Type</td>
						<td><form:input path="workerType" /></td>
					</tr>
					
					<tr>
						<td>Experience</td>
						<td><form:input path="experience" /></td>
					</tr>
					<tr>
						<td>Rate</td>
						<td><form:input path="rate" /></td>
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
