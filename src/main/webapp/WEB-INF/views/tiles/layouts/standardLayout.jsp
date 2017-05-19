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
		<!-- header -->
        <header id="header" class="col-md-12 custom-header">
            <tiles:insertAttribute name="header" />
        </header>
         
         <!-- main body content -->
        <main id="site-content">
        	<div class="col-md-3">
            	<tiles:insertDefinition name="sidebar" />
            </div>
        	<div id="content" class="col-md-9">
        		<div id="body">
            		<tiles:insertAttribute name="body" />
            		<%-- <%@ include file="/WEB-INF/views/pages/testBody.jsp" %> --%>
            	</div>
            </div>
        </main>
         
         <!-- footer -->
        <footer id="footer"  class="col-md-12">
            <tiles:insertAttribute name="footer" />
        </footer>
</body>
</html>