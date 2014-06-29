<%@ include file="/WEB-INF/views/includes.jsp"%>
<html>
<head>
<script src="${appPath}//js/jquery-1.7.1.min.js" type="text/javascript"></script>
  
</head>
<body >
<c:url var="logout" value="/logout.htm"/>


<table align="center" border="1" width="100%" height="100%" > 

	<tbody align="center" valign="center" >
		<tr>
			<security:authorize ifAllGranted="ROLE_USER">
				<td width="20%">
				<div id="user">USER</div>
				</td>
			</security:authorize>
			
			<security:authorize ifAllGranted="ROLE_ADMIN">
				<td width="20%">
				<div id="admin">ADMIN</div>
				</td>
			</security:authorize>
			<td><spring:message code="changeLanguage" /> <a
				href="?locale=en" title="English">EN</a> <a href="?locale=pl"
				title="Polish">PL</a></td>
	
			
 
		
		
		</tr>
	</tbody>
</table>

</body>
</html>
