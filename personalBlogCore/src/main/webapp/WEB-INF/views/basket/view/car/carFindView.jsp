<%@ include file="/WEB-INF/views/includes.jsp"%>
<html>
<head>
 <head> 

  </head>

</head>
<body>
	<h3>Car</h3>
	<h4>car2</h4>
	<div class="span-12 last">
		<form:form modelAttribute="car" method="post">
			<form:errors path="*" />
			<fieldset>
				<legend>car update</legend>
				<p>
					<form:label for="name" path="name">Name</form:label>
					<br />
					<form:input path="name" />
					<form:errors path="name" cssClass="error" element="div" />
				</p>
				
			</fieldset>
			<p>	
					<input type="submit" />
				</p>
		</form:form>
	</div>
	<div class="success">
	    <h5>slawek</h5>
	 </div>
	 <div>
	    <h5>slawek2</h5>
	 </div>
</body>


</html>