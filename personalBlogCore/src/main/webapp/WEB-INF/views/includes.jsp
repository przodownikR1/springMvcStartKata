<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<% pageContext.setAttribute("now", new org.joda.time.DateTime()); %>
<%request.setAttribute("appPath", request.getContextPath()); %>

 
	<head>
	
	   <!-- jquery core -->
	
	    <spring:url value="/js/jquery-1.8.0.min.js" var="jquery_url"/>
		<script src="${jquery_url}" type="text/javascript"><jsp:text/></script>
		
		<spring:url value="/js/json.min.js" var="jquery_json_url"/>
		<script src="${jquery_json_url}" type="text/javascript"><jsp:text/></script>
		
	
	    <!-- ui -->
	    
		<spring:url value="/js/jqueryui/1.8.3/jquery-ui-1.8.23.custom.min.js" var="jquery_ui_url" />
		<script src="${jquery_ui_url}" type="text/javascript"><jsp:text/></script>
			
		
		<spring:url value="/js/jqueryui/1.8.3/themes/base/jquery.ui.all.css" var="jquery_ui_all_css" />
		<link rel="stylesheet" type="text/css" media="screen" href="${jquery_ui_all_css}" />
		
		
		<spring:url value="/js/jqueryui/1.8.3/ui/i18n/jquery.ui.datepicker-pl.js" var="jquery_ui_datepicker" />
		<script src="${jquery_ui_datepicker}" type="text/javascript"><jsp:text/></script>
		
		<!-- grid -->
		
		<spring:url value="/js/jqGrid/jquery.jqGrid.min.js" var="jqGrid_url" />
		<script src="${jqGrid_url}" type="text/javascript"><jsp:text/></script>
		
		<spring:url value="/js/jqGrid/css/ui.jqgrid.css" var="jqGrid_url_css" />
		<link rel="stylesheet" type="text/css" media="screen" href="${jqGrid_url_css}" />
		
		<spring:url value="/js/jqGrid/i18n/grid.locale-pl.js"var="jqgrid_locale_url" />
    	<script src="${jqgrid_locale_url}" type="text/javascript"><jsp:text/></script>		
    	
    	<!-- wygwig -->
    	
    	
		
		<!-- my -->
		 
    	<link href="<c:url value="/css/main.css" />" rel="stylesheet"  type="text/css" />
    	
    			
   	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 
  </head>
  
  
  