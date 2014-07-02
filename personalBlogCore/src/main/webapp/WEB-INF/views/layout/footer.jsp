<%@ include file="/WEB-INF/views/includes.jsp"%>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style type="text/css">
  </style>
  <c:url value="/j_spring_security_logout" var="logoutUrl"/>
 
  
</head>
<body>
   
   <ul>
    <li><a href="${logoutUrl}">Log Out</a></li>
    <li><div id="footer">${numUsers} user(s) are logged in!</div></li>
   </ul>
   
   
<security:authentication property="authorities" var="authorities" />
<ul>
<c:forEach items="${authorities}" var="authority">
<li>${authority.authority}</li>
</c:forEach>
</ul>

Rendering time : <c:out value="${handlingTime}"/>

</body>

</html>