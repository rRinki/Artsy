<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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



<!DOCTYPE html>

<head>
<title>Products</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<style>
td{
    max-width: 100px;
    
}

body {
margin-top: 7%;
}

 .button,th{
  background:linear-gradient(rgba(247, 16, 16, 0.712),rgb(12, 11, 11));
  color: white;}
  
 .table{
  border-bottom: 1px solid #ddd;}
</style>

<body>
	<div class="container">

		<c:if test="${success}">
			<div class="alert alert-success">
				<strong>Success!</strong>${message}
			</div>
		</c:if>
		<c:if test="${error1}">
			<div class="alert alert-danger">
				<strong>Error!</strong>${message}
			</div>
		</c:if>

		<c:if test="${error2}">
			<div class="alert alert-warning">
				<strong>Warning!</strong>${message}
			</div>
		</c:if>



		<div class="col-md-6 mx-auto">

			<div class="jumbotron" style="margin-top: 10%; padding: 5%">
				<h3 class="text-center">PRODUCT DETAILS</h3>
				<hr>



				<c:if test="${edit}">
					<c:set var="url" value="${cr}/admin/updateproduct"></c:set>
				</c:if>
				<c:if test="${!edit}">
					<c:set var="url" value="${cr}/admin/addproducts"></c:set>
				</c:if>
				<form:form action="${url}" method="post" modelAttribute="productobject" enctype="multipart/form-data">

					<c:if test="${edit}">
						<form:hidden id="product_id" placeholder="Product Id" name="product_id" path="pro_id" />
					</c:if>

					<div class="form-group">
						<label>Product Name</label>
						<form:input type="text" class="form-control"
							placeholder="Product Name" path="pro_name" />
						<form:errors path="pro_name" cssStyle="color:Red"></form:errors>
						<br>

					</div>



					<div class="form-group">
						<label>Product Description</label>

						<form:textarea class="form-control" rows="5"
							placeholder="Write something... " path="pro_description"></form:textarea>

						<form:errors path="pro_description" cssStyle="color:Red"></form:errors>
						<br>
					</div>

					<div class="form-group">
						<label>Stock</label>
						<form:input type="text" class="form-control" placeholder="Stock"
							path="pro_stock" />

						<form:errors path="pro_stock" cssStyle="color:Red"></form:errors>
						<br>


					</div>

					<div class="form-group">
						<label>Price</label>
						<form:input type="text" class="form-control" placeholder="Price"
							path="pro_price" />
						<form:errors path="pro_price" cssStyle="color:Red"></form:errors>
						<br>

					</div>

					<div class="form-group">
						<form:select id="cat_Name" class="form-control"
							placeholder="Category Name" path="pro_Category.cat_Id">
						

							<c:forEach items="${catlist}" var="c">
								<option value="${c.cat_Id}">${c.cat_Name}</option>
							</c:forEach>
						</form:select>
						
						<form:input type ="file" path ="pro_images"/>
						
						<br>
					</div>

					<div class="form-group">
						<button class="btn btn-dark btn-block button">SUBMIT</button>

					</div>
				</form:form>
			</div>
		</div>

		<!-- --To fetch The Data -->
		<div class="row" style="margin-bottom: 3%;">
			<div class="table-responsive table-borderless movie-table">
				<table class="table table-striped">
					<thead class="dark-row">
						<tr class="movie-table-head">
							<th>Product Id</th>
							<th>Product Name</th>
							<th>Product Description</th>
							<th>Product Stock</th>
							<th>Product Price</th>
							<th>Product Category</th>
							<th>Images</th>
							<th>Edit/Delete</th>

						</tr>
					</thead>

					<tbody>
						<c:forEach var="p" items="${productlist}">
							<tr>
								<td>${p.pro_id}</td>
								<td>${p.pro_name}</td>
								<td>${p.pro_description}</td>
								<td>${p.pro_stock}</td>
								<td>${p.pro_price}</td>
								<td>${p.pro_Category.cat_Name}</td>
								<td><img src="${cr}/pimg/${p.pro_id}.jpg" height="50px"></td>
								<td class="text-center">
									<div class="row" style="margin-top: 2%">
										<div class="col-12">
										
											<a href="${cr}/admin/deleteproduct?proid=${p.pro_id}"
												class="btn btn-info"><span
												class="glyphicon glyphicon-edit"></span>Delete</a>
												</div>
												</div>
												<div class="row" style="margin-top: 2%">
												<div class="col-12">
										
											<a href="${cr}/admin/getproducttoedit?proid=${p.pro_id}"
												class="btn btn-danger"><span
												class="glyphicon glyphicon-remove"></span>Edit</a>
												</div>
												</div>
										
									
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>