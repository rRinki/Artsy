<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>

.card {
	margin-top: 3%;
	height: 350px;
}

.mytext
{
color: red;
font-style: oblique;
}

.card-text
{
   margin-top: 2%;
}

.card-img-top {
	height: 150px;
	widht: 150px;
}

.card-title {
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;

}

</style>
</head>
<body>


	<div class="container">

		<div class="row">
			<c:forEach items="${orderlist}" var="p">
				<div class="col-12">
			
					<div class="card-body">
					<div class="row">
								<div class="col-3">
						<img src="${cr}/pimg/${p.pro_Detail.pro_id}.jpg" class="card-img-top" />
						</div>
						<div class="col-3">
								<p class="card-title" data-toggle="tooltip"
									title="${p.pro_Detail.pro_name}">${p.pro_Detail.pro_name}</p>
							</div>
							
							<div class="col-3">
								<p class="card-text">
									Price: <span class="mytext">&#8377
										${p.pro_Detail.pro_price}</span>
								</p>
							</div>
							<div class="col-3">
							<a href ="${cr}/user/viewdetails?oid=${p.order_Id}" class="btn btn-danger"><i class="fa fa-info-circle"></i>View Details</a>
							</div>
							
							<div class="col-12">
								<p class="card-text">
									OrderDate: <span class="mytext"> ${p.order_date}</span>
								</p>
							</div>
						</div>
					</div>
				</div>
			
			</c:forEach>
		</div>

	</div>


</body>
</html>