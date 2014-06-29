<%@ include file="/WEB-INF/views/includes.jsp"%>

<html>

<body>
<spring:message var="user.title" code="user.title"/>
<spring:message var="user.firstName" code="user.firstname"/>
<spring:message var="user.lastName" code="user.lastname"/>
<spring:message var="user.login" code="user.login"/>
<spring:message var="user.address.city" code="address.city"/>
<spring:message var="user.address.street" code="address.street"/>
<spring:message var="user.address.zip" code="address.zip"/>
<spring:message var="user.phone" code="user.phone"/>
<spring:message var="user.email" code="user.email"/>
<h3>${user.title}</h3>

<table>
    <thead>
               <tr>
					<th>${user.firstName}</th>
					<th>${user.lastName}</th>
					<th>${user.login}</th>
					<th>${user.address.city}</th>
					<th>${user.address.street}</th>
					<th>${user.address.zip}</th>
					<th>${user.phone}</th>
					<th>${user.email}</th>
				</tr>
    </thead>
  <tbody></tbody>
  <tfoot></tfoot>
  

</table>
</body>
</html>