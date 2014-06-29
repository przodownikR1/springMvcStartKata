<%@ include file="/WEB-INF/views/includes.jsp"%>


<form:errors path="*" />


<c:choose>
	<c:when test="${successful ne true}">

		<form:form modelAttribute="upload" enctype="multipart/form-data"
			method="post">
			<table>

				<tr>
					<th><label for="name">name</label></th>
					<td><input name="name" />
				</tr>
				<tr>
					<th><label for="file">File</label></th>
					<td><input name="file" type="file" />
				</tr>

				<tr>
					<th></th>
					<td><input name="commit" type="submit"</td>
				</tr>


			</table>

		</form:form>
	</c:when>
	<c:otherwise>
  Zapisany
</c:otherwise>


</c:choose>
