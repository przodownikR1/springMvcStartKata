<%@ include file="/WEB-INF/views/includes.jsp"%>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style type="text/css">
  </style>
  
</head>
<body>
<h1>Access Denied</h1>
<p>
Access to the specified resource has been denied for
the following reason: <strong>${errorDetails}</strong> . to <strong>${path}</strong> for user <strong>${user}</strong>   
</p>


<c:url value="/loginForm" var="loginForm"/>
<a href="${loginForm}" >Login Page</a>

</body>
</html>