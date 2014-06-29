<%@ include file="/WEB-INF/views/includes.jsp"%>

<html>
<body>
<h1>Performance Monitor</h1>


<table border="1">
    <tr><th>Url</th><th>ilosc uderzen</th><th>sredni czas</th><th>sumaryczny czas</th></tr>
    <c:forEach var="entry" items="${result}" varStatus="status">
    <tr>      
      <td>${entry.key}</td>
      <td>${entry.value.requestCount}</td>
      <td>${entry.value.averageRespTime}</td>
      <td>${entry.value.sumRespTime}</td>
    </tr>
    </c:forEach>
</table>


</body>


</html>