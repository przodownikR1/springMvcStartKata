<%@ include file="/WEB-INF/views/includes.jsp"%>

<html>
<head>
<title>Login page</title>
<c:url var="actionUrl" value="/j_spring_security_check" />
<c:url var="logoutUrl" value="/logout" />
</head>
<body>

	<div id="errorClass">
		<c:if test="${not empty param.error}">
			<c:out value="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION}" />

		</c:if>
	</div>
       <c:out value="${appPath}"/>
	<form action="${actionUrl}" class="signin" method="POST">

		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="username_or_email">Username or Email</label></th>
					<td><input name="j_username" type="text" maxlength="50"
						id="username_or_email" size="25" autocomplete="on" /> Username field</td>
				</tr>
				<tr>
					<th><label for="password">Password</label></th>
					<td><input name="j_password" type="password" maxlength="50"
						id="j_password" size="25" /> <small><a
							href="/account/resend_password">Forgot?</a></small></td>
				</tr>
				<tr>
					<th></th>
					<td><input id="remember_me"
						name="_spring_security_remember_me" type="checkbox" />Remember-me
						box <label for="remember_me" class="inline">Remember me</label></td>
				</tr>
				<tr>
					<th></th>
					<td><input name="commit" type="submit" value="Sign In" /></td>
				</tr>
				<tr>
					<th><label for="home">home</label></th>
					<td><a href="<spring:url value="/" htmlEscape="true" />">Home</a>
					</td>
				</tr>

			</table>
		</fieldset>

	</form>
	 <script type="text/javascript">
        document.getElementById('username_or_email').focus();
     </script>
	
	<p class="message">${message}</p>
	<a href="${logoutUrl}" >Logout</a>
</body>
</html>
