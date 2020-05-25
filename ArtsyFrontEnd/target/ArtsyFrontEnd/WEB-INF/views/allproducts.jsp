<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
<style>
.mytext {
	color: red;
	font-style: oblique;
}

.card {
	margin-top: 12%;
	max-height: 360px;

	
}

.card-img-top {
	max-height: 120px;
	max-width: :110px;
}

.card-title {
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
}
body{
margin-top:7%;
}
</style>
<body>
<div class="container">
	<div class="row">
		<c:forEach items="${productlist}" var="p">
			<div class="col-3">
				<div class="card">
					<img src="${cr}/pimg/${p.pro_id}.jpg" class="card-img-top" />
					<div class="card-body">
						<div class="col-12">
							<p class="card-title" data-toggle="tooltip"
								title="${p.pro_name}">${p.pro_name}</p>
						</div>
						<div class="col-12">
							<p class="card-text">
								Price: <span class="mytext">&#8377 ${p.pro_price}</span>
							</p>
						</div>
						<div class="col-12">
							<c:if test="${p.pro_stock > 5}">
								<p class="card-text">
									Stock:<span class="mytext"> In Stock</span>
								</p>
							</c:if>
							<c:if test="${p.pro_stock < 5 }">
								<p class="card-text">
									Stock:<span class="mytext"> Only ${p.pro_stock}
										Available</span>
								</p>
							</c:if>
						</div>

						<div class="row" style ="margin-top:2%">
							<div class="col-6">
              <a href="${cr}/addtocart?productid=${p.pro_id}"  class="btn btn-success"><i class="fa fa-shopping-cart"></i> Add to Cart </a>
            </div>
								
							
							<div class="col-6">
							<a href="${cr}/oneproduct?pro_id=${p.pro_id}"  class="btn btn-warning">
              <i class="fa fa-shopping-basket"></i> View Details </a>
           
								
							</div>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
			</div>
	</div>
</body>
