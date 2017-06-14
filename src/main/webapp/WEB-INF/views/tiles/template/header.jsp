<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="true" %>

<c:set var="room"><tiles:getAsString name="room" /></c:set>
<c:set var="userIsLoggedIn"><c:out value="${sessionScope['scopedTarget.userLoginSessionForm'].isUserLogin()}"/></c:set>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="row headerContainer">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/home">
      	<img id="logo" src="/static/images/wtLogo.png">
      </a>
    </div>
    <div id="navbar" class="navbar-collapse collapse pull-right">
      <ul class="nav navbar-nav">
        <li  class="<c:if test="${room == 1}">active</c:if>">
        	<a href="/home">
        		<span class="anchorText">Home</span>
        	</a>
        </li>
        <li class="<c:if test="${room == 2}">active</c:if>">
        	<a href="/about">
        		<span class="anchorText">About</span>
        	</a>
        </li>
        <c:if test="${not userIsLoggedIn}">
	         <li class="<c:if test="${room == 3}">active</c:if>">
	         	<a href="/register">
	         		<span class="anchorText">Register</span>
	         	</a>
	         </li>
	         <li class="<c:if test="${room == 4}">active</c:if>">
	         	<a href="/login">
	         		<span class="anchorText">Login</span>
	         	</a>
	         </li>
         </c:if>
         <c:if test="${userIsLoggedIn}">
	         <li>
	         	<a href="/logout">
	         		<span class="anchorText">Logout</span>
	         	</a>
	         </li>
         </c:if>
      </ul>
    </div>
  </div>
</nav>