<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
.btn {
	margin-top: 5%;
}

.jump {
	margin-top: 5%;
	background: rgba(255, 255, 255, 0.75);
	box-shadow: 0 5px 15px rgba(0, 0, 0, .5);
}

body{
margin-top: 7%;
}

table {
  border-collapse: collapse;
   width: 60%;
  margin-left:auto;
  margin-right:auto;
}

 tr:hover {background-color: #ddd;}

th,tr {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  }
  
  .button,th{
  background:linear-gradient(rgba(247, 16, 16, 0.712),rgb(12, 11, 11));
  color: white;}
 

  
</style>



<div class="container">
	<div class="col-6"
		style="width: 600px; margin-left: 250px; margin-top: 50px;">



		<c:if test="${success}">
			<div class="alert alert-success">
				<strong>Success!</strong>${message}
			</div>
		</c:if>
		<c:if test="${error1}">
			<div class="alert alert-danger">
				<strong>Danger!</strong>${message}
			</div>
		</c:if>

		<c:if test="${error2}">
			<div class="alert alert-warning">
				<strong>Warning!</strong>${message}
			</div>
		</c:if>

		<div class="jumbotron jump">

			<h2 class="text-center">CATEGORIES</h2>
			<h3 class="text-center">Add your category here!!</h3>
			<hr>
			<c:if test="${edit}">
				<c:set var="url" value="${cr}/admin/updatecategory"></c:set>
			</c:if>
			<c:if test="${!edit}">
				<c:set var="url" value="${cr}/admin/addcategory"></c:set>
			</c:if>
			<form:form action="${url}" method="post"
				modelAttribute="categoryobject">
				<c:if test="${edit}">
					<form:hidden class="form-control" placeholder="Category Name"
						path="cat_Id" />
				</c:if>


				<label> Category Name</label>



				<form:input type="text" class="form-control"
					placeholder="Category Name" path="cat_Name" />
				<form:errors path="cat_Name" cssStyle="color:Red"></form:errors>


				<input type="submit" class="btn btn-block button" value="Submit">




			</form:form>
		</div>
	</div>
</div>

<!-- --To fetch The Data -->

<div class="row" style="margin-bottom: 3%; padding: 8%">
	
		<table class ="  table-borderless table-striped">
			<thead class="dark-row">
				<tr class="movie-table-head">
					<th>Category Id</th>
					<th>Category Name</th>
					<th>Edit/Delete</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="c" items="${categorylist}">
					<tr>
						<td>${c.cat_Id}</td>
						<td>${c.cat_Name}</td>
						<td class="text-center">
							<div class="row" style="margin-top: 2%">
										<div class="col-12">

									<a href="${cr}/admin/deletecategory?catname=${c.cat_Name}"
										class="btn btn-info ">Delete</a>
										</div>
								</div>
								<div class="row" style="margin-top: 2%">
										<div class="col-12">
									<a href="${cr}/admin/getdatatoedit?catname=${c.cat_Name}"
										class="btn btn-danger">Edit</a>
								</div>
							</div>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	
</div>

</body>

</html>