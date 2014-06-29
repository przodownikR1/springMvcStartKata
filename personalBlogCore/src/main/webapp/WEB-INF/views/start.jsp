<%@ include file="/WEB-INF/views/includes.jsp"%>
<html>


<body>
<div class="container">  
	<h1>
		<fmt:message key="application.title"/>
	</h1>
	<p>
		Locale = ${pageContext.response.locale}
	</p>
	<hr>	
	<ul>
		<li> <a href="?locale=en_us">en</a> |  <a href="?locale=pl">pl</a>  </li>
	</ul>

</div>
</body>
</html>