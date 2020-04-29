<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>


	<c:if test="${info}">
		<div class="alert">
			<h3>${message}</h3>
		</div>
	</c:if>

	<div class="container" style="margin-top: 15%">
		<form:form action="addcategory" method="POST"
			modelAttribute="categoryobject">
			<h2 class="text-center">Categories</h2>
			<h3 class="text-center">Add your category here!!</h3>
			<hr>

			<label> Category Name</label>
			<form:input type="text" class="form-control"
				placeholder="Category Name" path="cat_Name" />
			<input type="submit" class="btn btn-dark form-control" value="Submit">


		</form:form>
	</div>
</body>

</html>