<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

<style>
.btn {
	
	margin-top: 5%;
}

.jump{
margin-top:5%;
 background: rgba(255, 255, 255, 0.75);
 box-shadow: 0 5px 15px rgba(0, 0,0,.5);
      padding:10%;

}
</style>

<c:if test="${info}">
				<div class ="alert" role="alert">
				<h3>${message}</h3>
				</div>
			</c:if>

<div class="container">
<div class="col-6" style="width:600px;margin-left:250px;margin-top:50px;">
 <div class="jumbotron jumbotron-fluid jump">
		<form:form action="addcategory" method="POST" modelAttribute="categoryobject">
			<h2 class="text-center">CATEGORIES</h2>
			<h3 class="text-center">Add your category here!!</h3>
			<hr>

			<label> Category Name</label>
			<form:input type="text" class="form-control"
				placeholder="Category Name" path="cat_Name" />
			<input type="submit" class="btn btn-dark form-control" value="Submit">


		</form:form>
	</div>
	</div>
	</div>
</body>

</html>