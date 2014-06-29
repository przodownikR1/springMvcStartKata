<%@ include file="/WEB-INF/views/includes.jsp"%>
<html>
<head>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>
<body>
<h3>Faktura</h3>
	<div class="span-12 last">	
		<form:form modelAttribute="faktura"  method="post">
		<form:errors path="*"/>
		  	<fieldset>		
				<legend>Faktura update</legend>
				<p>
					<form:label	for="name" path="name">Name</form:label><br/>
					<form:input path="name" /> <form:errors path="name" cssClass="error" element="div" />	
				</p>
				<p>	
					<form:label for="amount" path="amount">Amount</form:label><br/>
					<form:input path="amount" /> <form:errors path="amount" cssClass="error" element="div" />
				</p>
				
				<p>
					<form:label	for="mail" path="mail">mail</form:label><br/>
					<form:input path="mail" /> <form:errors path="mail" cssClass="error" element="div" />	
				</p>
				<p>	
					<form:label for="lowerCaseName" path="lowerCaseName">lowerCaseName</form:label><br/>
					<form:input path="lowerCaseName" /> <form:errors path="lowerCaseName" cssClass="error" element="div" />
				</p>
				<p>	
					<form:label for="futureDate" path="futureDate">futureDate</form:label><br/>
					<form:input path="futureDate" /> <form:errors path="futureDate" cssClass="error" element="div" />
				</p>
				<p>
				
				
				</p>
			</fieldset>
			<table>
			<tr>
				<td>User roles:</td>
				<td>
				
				<form:checkboxes path="yoursChoose" items="${userRoles}"/>

				</td>
				</tr>
				<tr>
					<td>Favourite Word:</td>
					<td>
					<%-- Approach 3: Property is of type java.lang.Object --%>
					something: <form:checkbox path="magic" value="something"/>
					</td>
			   </tr>
				<tr>
					<td>My solution</td>
					<td>
					<form:select path="operations">
					   <form:options items="${operations}"  itemValue="label" itemLabel="value"/>
					</form:select>
					 
					  
					</td>
			   </tr>
				
				
				
			</table>
			    <p>	
					<input type="submit" />
				</p>
		</form:form>
	<hr>	
</div>
</body>
</html>