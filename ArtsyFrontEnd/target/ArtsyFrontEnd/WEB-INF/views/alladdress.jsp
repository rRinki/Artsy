<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
body {
	margin-top: 15%;
}
</style>
<body>
	<div class="container">

		<c:if test="${empty addresslist}">
			<div class="jumbotron">Please Add Address To Continue</div>
		</c:if>
		<c:if test="${not empty addresslist}">
			<div class="row">
			<c:if test="${info}">
				<div class="alert alert-success">
					<strong>Success!</strong>${message}
				</div>
			</c:if>
				<c:forEach items="${addresslist}" var="p">

					<div class="col-3">
						<div class="card">
							<img src="${cr}/img/4.jpg" class="card-img-top" />
							<div class="card-body">
								<div class="col-12">
									<p class="card-title" data-toggle="tooltip" title="${p.name}">${p.name}</p>
								</div>
								<div class="col-12">
									<p class="card-text">
										<span class="mytext"> ${p.line1}</span>
									</p>
								</div>
								<div class="col-12">

									<p class="card-text">
										<span class="mytext"> ${p.line2}</span>
									</p>
								</div>

								<div class="col-12">

									<p class="card-text">
										<span class="mytext"> ${p.area}</span>
									</p>
								</div>


								<div class="col-12">

									<p class="card-text">
										<span class="mytext"> ${p.pincode}</span>
									</p>
								</div>
								<div>
								<div class="row" style="margin-top: 2%">
									<div class="col-6">
										<a href="${cr}/user/editaddress?addressid=${p.address_Id}"
											class="btn btn-success" type="submit"><i
											class="fa fa-edit"></i> Edit Address</a>
									</div>

									<div class="col-6">
										<a href="${cr}/user/deleteaddress?addressid=${p.address_Id}"
											class="btn btn-warning"> <i class="fa fa-trash"></i>
											Delete Address
										</a>
									</div>
									<div class="row" style="margin-top:2%";>
										<a href="" class="btn btn-success"> <i class="fa fa-truck"></i>
											Ship Here
										</a>
									</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>

	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModalCenter">Add New Address</button>

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Address</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<div class="container">
						<form action="addaddress" method="post">

							<div class="form-group col-md-12">
								<label>Customer Name</label> <input type="text"
									class="form-control" placeholder="Name**" name="name" id="name" />
							</div>

							<div class="form-group col-md-12">
								<label>Address Line1</label> <input type="text"
									class="form-control" placeholder="Line1**" name="line1"  id="line1"/>

							</div>

							<div class="form-group col-md-12">
								<label>Address Line2</label> <input type="text"
									class="form-control" placeholder="Line2**" name="line2" id="line2" />

							</div>

							<div class="form-group col-md-12">
								<label>Area</label> <input type="text" class="form-control"
									placeholder="Area**" name="area"  id="area"/>

							</div>
							<div class="form-group col-md-12">
								<label>Pincode</label> <input type="text" class="form-control"
									placeholder="Pincode**" name="pincode"  id="pincode"/>
							</div>
							<a href=""></a>
							<button type="submit" class="btn btn-primary">Save
								changes</button>


						</form>
					</div>

				</div>
			
			<div class="modal-footer">
				<button type=button class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
			</div>
		</div>
	</div>
	

	<c:if test="${edit}">
		<div class="container">
			<form action="updateaddress" method="post">
				<div class="form-group">
					<input type="hidden" class="form-group" id="addressid"
						name="addressid" required="required"
						value="${addressobject.address_Id}">
				</div>

				<div class="form-group">
					<input type="hidden" class="form-group" id="addressid"
						name="addressid" required="required"
						value="${addressobject.address_Id}">
				</div>

				<div class="form-group col-md-12">
					<label>Customer Name</label> <input type="text"
						class="form-control" placeholder="Name**"
						value="${addressobject.name}" />
				</div>

				<div class="form-group col-md-12">
					<label>Address Line1</label> <input type="text"
						class="form-control" placeholder="Line1**"
						value="${addressobject.line1}" />

				</div>

				<div class="form-group col-md-12">
					<label>Address Line2</label> <input type="text"
						class="form-control" placeholder="Line2**"
						value="${addressobject.line2}" />

				</div>

				<div class="form-group col-md-12">
					<label>Area</label> <input type="text" class="form-control"
						placeholder="Area**" value="${addressobject.area}" />

				</div>
				<div class="form-group col-md-12">
					<label>Pincode</label> <input type="text" class="form-control"
						placeholder="Pincode**" value="${addressobject.area}" />

				</div>
				<button type="submit" class="btn btn-primary">Save changes</button>
				<button type="submit" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</form>

		</div>

	</c:if>





</body>
</html>