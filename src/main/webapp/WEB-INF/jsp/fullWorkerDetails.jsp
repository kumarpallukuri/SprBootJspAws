<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			Registration Sucess for below User..! </br> Details: ${FirstName}</br>
			${LastName} </br> ${EmailAdress} </br> ${MobileNumber} </br> ${WorkerType} </br> ${Rate} </br>

		</div>
	</div>
<li><a  class="btn btn-default" href="/register">Back. </a></li>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
