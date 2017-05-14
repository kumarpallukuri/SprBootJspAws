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
</head>
  
<body>
		<!-- header -->
        <header id="header" class="custom-header">
            <tiles:insertAttribute name="header" />
        </header>
         
         <!-- main body content -->
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
         
         <!-- footer -->
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
</body>
</html>