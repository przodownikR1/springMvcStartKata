<%@ include file="/WEB-INF/views/includes.jsp"%>
	
	<form:form modelAttribute="invoice"  method="post">
	  <form:hidden path="id"/>
      <fieldset>		
				<legend>Invoice Fields</legend>
				<p>
					<form:label	for="name" path="name">Name</form:label><br/>
					<form:input path="name" />		
					<form:errors path="name" cssClass="errorMessage"/>
				</p>
				
				<p>	
					<form:label for="amount" path="amount">Amount</form:label><br/>
					<form:input path="amount" />
					<form:errors path="amount" cssClass="errorMessage"/>
				</p>
				
				<p>
					<form:label for="createDate" path="creataDate">CreateDate</form:label><br/>
					<form:input path="creataDate" />
					<form:errors path="creataDate" cssClass="errorMessage"/>
				</p>
				
				<p>
					<form:label for="payDate" path="payDate">payDate</form:label><br/>
					<form:input path="payDate" />
					<form:errors path="payDate" cssClass="errorMessage"/>
				</p>
	
				<p>
					<form:label for="payed" path="payed">Payed</form:label><br/>
					<form:checkbox path="payed" value="payed" />
					<form:errors path="payed" cssClass="errorMessage"/>
				</p>
				
				<p>
					<form:label for="description" path="description">Descrption</form:label><br/>
					<form:input path="description" />
					<form:errors path="description" cssClass="errorMessage"/>
				</p>
				
			   <p>
					<form:label for="user" path="user">user</form:label><br/>
					<form:input path="user" />
					<form:errors path="user" cssClass="errorMessage"/>
				</p>
				
				 <p>
					<form:label for="type" path="type">type</form:label><br/>
					<form:input path="type" />
				</p>
				 
			</fieldset>  
			 
             <input type="submit" value="Save Changes" />
    </form:form>	
	
	