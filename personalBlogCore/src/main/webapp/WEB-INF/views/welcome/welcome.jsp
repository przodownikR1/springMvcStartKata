<%@ include file="/WEB-INF/views/includes.jsp"%>
<html>


<body>

<spring:eval expression="@applicationProps['application.version']" var="applicationVersion"/>
 
 <c:out value="${applicationVersion}"/>
<c:set var="browser" value="${header['User-Agent']}" scope="session" />
Your Browser User Agent is : <c:out value="${browser}"/>

<div class="container">  
	<h1>
		<fmt:message key="application.title"/>
		
	</h1>
	<br/>
		
		Spring message: <spring:message code="application.title"/>
		
		
	<p>
		Locale = ${pageContext.response.locale}
	</p>
	<hr>	
	<ul>
		<li> <a href="?locale=en_us">en</a> |  <a href="?locale=pl">pl</a>  </li>
	</ul>
</div>
</body>
</html>