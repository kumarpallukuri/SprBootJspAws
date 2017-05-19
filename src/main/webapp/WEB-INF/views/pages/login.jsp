<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="login-panel">

	<form:form class="form-signin">
		

		<!-- <input id="inputEmail" class="form-control" placeholder="School Id" required="true" autofocus="" value="" />  -->
		<%-- <form:errors  class="control-label" /> --%>

		<input id="inputEmail" class="form-control" placeholder="Username" required="true" autofocus="" /> 
		<%-- <form:errors class="control-label" /> --%>
		
		<input type="password" id="inputPassword" class="form-control" placeholder="Password" required="true"/>
		<%-- <form:errors class="control-label" /> --%>
		
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		
	</form:form>

</div>