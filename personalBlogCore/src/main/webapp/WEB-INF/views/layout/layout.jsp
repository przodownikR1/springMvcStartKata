<%@ include file="/WEB-INF/views/includes.jsp"%>

<html>
<head>
<title><tiles:getAsString name="title" /></title>
</head>
<body >
  <table align="center" border="1" width="100%" height="100%" > 
  <tbody >
    <tr height="9%">
      <td><tiles:insertAttribute name="header" /></td>
    </tr>
    <tr height="90%">
      <td><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr height="1%">
      <td ><tiles:insertAttribute name="footer" /></td>
    </tr>
  </tbody>
</table>
</body>

</html>
