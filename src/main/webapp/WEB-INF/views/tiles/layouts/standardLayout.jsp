<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title" /></title>   
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
        
    <!-- include css and js files -->
	<%@ include file="/WEB-INF/views/tiles/template/cssInclude.jsp" %>
	<%@ include file="/WEB-INF/views/tiles/template/jsInclude.jsp" %>
	
	<!-- include fonts  -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	
</head>
  
<body>

		<c:set var="room"><tiles:getAsString name="room"/></c:set>
		<c:set var="sidebar"><tiles:getAsString name="sidebar"/></c:set>
		<c:set var="sidebarActive">
			<c:if test="${sidebar != ''}">true</c:if>
			<c:if test="${sidebar == ''}">false</c:if>
		</c:set>
	
		<div class="wrapper">
			
			<!-- header -->
	        <header id="header" class="col-md-12 custom-header">
	            <tiles:insertAttribute name="header">
	            	 <tiles:putAttribute name="room" value="${room}" />
	            </tiles:insertAttribute>
	        </header>
	         
	         <!-- main body content -->
	        <main class="row" id="site-content">
	        	<div class='<c:if test="${sidebarActive }">col-md-3</c:if><c:if test="${not sidebarActive }">hidden</c:if>'>
	            	<tiles:insertAttribute name="sidebar" />
	            </div>
	        	<div id="content" class='<c:if test="${sidebarActive }">col-md-9</c:if><c:if test="${not sidebarActive }">col-md-12</c:if>'>
	        		<div id="body">
	            		<tiles:insertAttribute name="body" />
	            	</div>
	            </div>
	        </main>
	         
	         <!-- footer -->
	        <footer id="footer"  class="col-md-12 well row">
	            <tiles:insertAttribute name="footer" />
	        </footer>
         </div>
</body>
</html>