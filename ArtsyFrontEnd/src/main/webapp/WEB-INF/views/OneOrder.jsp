<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<style>
body
 {
 	margin-top: 7%;
	margin-bottom: 3%;
}

input[type=text], input[type=number], textarea, select {
	width: 100%;
	padding: 2px;
	margin: 2px 0 8px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	font-size: 90%;
}

input[type=text]:focus, input[type=number]:focus, textarea:focus, select:focus
	{
	background-color: #ddd;
	outline: none;
}

.tabledisplay {
     font-family:calibri;
     font-size:25px;
	border-collapse: collapse;
	text-align: center;
	padding: 5px;
}

div.box{
  padding: 15px;
  width: 100%;
  
  margin-top: 20px;
}
</style>
<div class="container">

<div class="row">


		<div class="box" >

			<c:forEach items="${orderlist}" begin="0" end="0" var="o">
			
				<div class="colspan-8">
					<h5>order Id :${o.order_Id}</h5>
					<h5>order Date :${o.order_date}</h5>

				</div>
				<div class="colspan-2" >
					<div class="col-12">
						<h3 class="card-title" data-toggle="tooltip"
							title="${o.address.name}">${o.address.name}</h3>

					</div>
					<div class="col-12" >
						<p class="card-text">
							<span class="mytext"> ${o.address.line1}</span>
						</p>
					</div>
					<div class="col-12">
						<p class="card-text">
							<span class="mytext"> ${o.address.line2}</span>
						</p>
					</div>

					<div class="col-12">
						<p class="card-text">
							<span class="mytext"> ${o.address.area}</span>
						</p>
					</div>

					<div class="col-12">
						<p class="card-text">
							<span class="mytext"> ${o.address.pincode}</span>
						</p>
					</div>

				</div>
			</c:forEach>


			<c:forEach items="${orderlist}" var="o">
				<c:set var="subtotal"
					value="${o.prodqty*o.pro_Detail.pro_price}"></c:set>
				<c:set var="total"
					value="${o.prodqty*o.pro_Detail.pro_price}"></c:set>

				<table class="tabledisplay">
					<thead>
						<tr>
							<td style="width: 130px;" class="tabledisplay">
								<img
								src="${cr}/pimg/${o.pro_Detail.pro_id}.jpg"
								style="margin: 10px; width: 80px; height: 80px;"></td>

							<td style="width: 230px;" class="tabledisplay">${o.pro_Detail.pro_name}</td>

							<td style="width: 130px; text-align: left;" class="tabledisplay"><span>

									&#x20B9 ${o.pro_Detail.pro_price* o.prodqty}</span></td>
							<td style="width: 130px;" class="tabledisplay">Quantity:&nbsp;
								${o.prodqty}</td>
						</tr>

					</thead>
					<tfoot>
						<tr>
							<td>Subtotal</td>
							<td />
							<td />
							<td data-th="Total" class="text-center" colspan="1">${total }</td>

						</tr>
						<tr>
							<td>Shipping</td>
							<td />
							<td />
							<td data-th="Total" class="text-center" colspan="1"><c:if
									test="${total<1000 }">
									<c:set var="shipping" value="0"></c:set>
			               FREE
					</c:if> <c:if test="${total>=1000 }">
									<c:set var="shipping" value="100"></c:set>
			               ${shipping}
					</c:if></td>

						</tr>
						<tr>
							<td>Total</td>
							<td />
							<td />
							<td data-th="Total" class="text-center" colspan="1">${total+shipping}</td>

						</tr>

						<tr>
							<td><a href="${cr}/user/viewCart" class="btn btn-warning"><i
									class="fa fa-angle-left"></i> GO TO CART</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td />
							<td />


							<td><a href="${cr}/user/viewallorders" 
							class="btn btn-success btn-block">GO TO ORDER<i
									class="fa fa-angle-right"></i>
							</a></td>
						</tr>
					</tfoot>

				</table>
			</c:forEach>
		</div>
		

	</div>
</div>