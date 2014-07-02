<%@ include file="/WEB-INF/views/includes.jsp"%>


 <spring:url value="/invoice" var="invoiceAdd"/>
           
    <a href ="${invoiceAdd}">Dodaj rekord</a>
    <br/>

<table border="1">
	<tr bgcolor="yellow">
		<th>id</th>
		<th>name</th>
		<th>payed</th>
		<th>creataDate</th>
		<th>user</th>
		<th>amount</th>
		<th>type</th>
		<th>edit</th>
	</tr>
	<c:forEach var="invoice" items="${invoices}">
	    <spring:url value="/invoice/edit/{id}" var="invoiceEdit">
           <spring:param name="id" value="${invoice.id}"></spring:param>
       </spring:url>
		<tr>
		  
			<td><c:out value="${invoice.id}" /></td>
			<td><c:out value="${invoice.name}" /></td>
			<td><c:out value="${invoice.payed}" /></td>
			<td>
		      	 <c:out value="${invoice.creataDate}" />
			<%-- <fmt:formatDate value="${invoice.creataDate}" pattern="yyyy-MM-dd HH:mm" /> --%>
			</td>
			<td><c:out value="${invoice.user}" /></td>
			<td><c:out value="${invoice.amount}" /></td>
			<td><c:out value="${invoice.type}" /></td>
			<td><a href="${invoiceEdit}">Edit</a></td>
		</tr>
	</c:forEach>

</table>