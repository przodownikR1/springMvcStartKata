<%@ include file="/WEB-INF/views/includes.jsp"%>

<html>
<head>
<script src="${appPath}//js/jquery-1.7.1.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<spring:url value="/carJpaData/find" var="search">
</spring:url>
<table border="1" >
<tr><td>Name</td><td>cena</td><td>Edit</td><td>Delete</td></tr>
<c:forEach var="car" items="${cars}">
<spring:url value="/car/edit/{id}" var="carEdit">
   <spring:param name="id" value="${car.id}"></spring:param>
</spring:url>
<spring:url value="/car/remove/{id}" var="carRemove">
			<spring:param name="id" value="${car.id}"></spring:param>
		</spring:url>


 <tr><td><c:out value="${car.name}"/></td>
 <td><c:out value="${car.price}"/></td>
 <td><a href="${carEdit}">Edit</a></td>
<td>
<form:form method="DELETE" action="${carRemove}">
    <input type="submit" value="delete" name="delete"/>
</form:form> 
</td>

</tr>
</c:forEach>
</table>

<a href="${search}" >Find by name</a>
Time :  ${handlingTime}
</body>
<script type="text/JavaScript">
 
</script>


</html>