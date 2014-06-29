<%@ include file="/WEB-INF/views/includes.jsp"%>
<html>


<body>

<spring:eval expression="@applicationProps['application.version']" var="applicationVersion"/>
 
 <c:out value="${applicationVersion}"/>

<br/>
Message : <spring:message  code="user.firstname"/>

</body>
</html>