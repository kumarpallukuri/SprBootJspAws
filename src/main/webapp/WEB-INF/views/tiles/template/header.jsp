<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<c:set var="room"><tiles:getAsString name="room" /></c:set>

<nav class="navbar navbar-default navbar-static-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/register">
      	<!-- <img id="logo" src="/static/images/Logo.png" alt="Select to go to the Scopus main search page"> -->
      </a>
    </div>
    <div id="navbar" class="navbar-collapse collapse pull-right">
      <ul class="nav navbar-nav">
        <li  class="<c:if test="${room == 1}">active</c:if>">
        	<a href="/register">
        		<span class="anchorText">Home</span>
        	</a>
        </li>
        <li class="<c:if test="${room == 2}">active</c:if>">
        	<a href="/about">
        		<span class="anchorText">About</span>
        	</a>
        </li>
         <li class="<c:if test="${room == 3}">active</c:if>">
         	<a href="/login">
         		<span class="anchorText">Login/Register</span>
         	</a>
         </li>
      </ul>
    </div>
  </div>
</nav>