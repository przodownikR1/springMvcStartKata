<%@ include file="/WEB-INF/views/includes.jsp"%>

<html>
<body>
<table>
<tr><td>Name</td><td>Kwota</td><td>Email</td>
<td>lowerCaseName</td>
<td>date</td>
<td>flag</td>
<td>choose</td>
<td>operation</td>
<td>Edycja</td></tr>
<c:forEach var="faktura" items="${faktury}">
<spring:url value="/faktura/{fakturaId}" var="fakturaEdit">
   <spring:param name="fakturaId" value="${faktura.id}"></spring:param>
</spring:url>
 <tr><td><c:out value="${faktura.name}"/></td>
 <td><c:out value="${faktura.amount}"/></td>
 <td><c:out value="${faktura.mail}"/></td>
 <td><c:out value="${faktura.lowerCaseName}"/></td>
 <td><c:out value="${faktura.futureDate}"/></td>
 <td><c:out value="${faktura.mustBeTrue}"/></td>
 <td><c:out value="${faktura.choose}"/></td>
 <td><c:out value="${faktura.operation}"/></td>
 <td><a href="${fakturaEdit}">Edit</a></td></tr>

</c:forEach>
</table>
Time :  ${handlingTime}
</body>
</html>