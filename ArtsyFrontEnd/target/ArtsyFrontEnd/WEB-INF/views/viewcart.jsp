<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {
	margin-bottom: 3%;
	margin-top: 7%;
}

<
style>.table>tbody>tr>td, .table>tfoot>tr>td {
	vertical-align: middle;
}

@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	
	
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 4rem;
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
	}
}
</style>
      <div class="container" style="margin-top: 5%">
	<c:if test="${empty cartinfo}">
		<h2 class="jumbotron">Cart is empty</h2>
		<a href="${cr}/allproducts" class="btn btn-success"><i
			class="fa fa-angle-left"></i>Continue Shopping</a>
	</c:if>
	<c:if test="${not empty cartinfo}">

		
		<table class="table table-borderless table-hover table-striped">
			
			<tbody>
				<c:set var="Total" value="0" />
				<c:forEach items="${cartinfo}" var="p">
					<c:set var="subtotal"
						value="${p.pro_Quantity*p.pro_details.pro_price}"></c:set>
					<c:set var="total" value="${total+subtotal}" />

					<tr>

						<td data-th="Product">
							<div class="row">
								<div class="col-4">
									<img src="${cr}/pimg/${p.pro_details.pro_id}.jpg" alt="..."
										class="img-responsive" height="100" />
								</div>
								</td>
								<td>
								<div class="col-8">
									<h8 class="nomargin" style="padding-top:2px;">${p.pro_details.pro_name}</h8>
									<div>
										<a href="${cr}/user/deleteitem?cartid=${p.cart_id}" 
										class="btn btn-danger"><i class="fa fa-trash"></i> Remove</a>
									</div>
									<c:if test="${error && pid==p.pro_details.pro_id}">
										<div style= "margin-top:2%" class="alert alert-warning">
											<strong>${message}</strong>
										</div>
									</c:if>
								</div>
							</div>
						</td>
						<td data-th="Price">${p.pro_details.pro_price}</td>
						<td data-th="Quantity" style="width:15%">
							<div>
								<form action="${cr}/addtocart" method="post">
									 <div class="input-group">
                                   
                                    <button type="submit" class=" btn btn-primary"><i class="fa fa-minus"></i>
                                        </button>
                                   
              						 
									<input type="number" class="form-control" id="quantity"
										name="quantity" value="${p.pro_Quantity}"> 
										<input type="hidden" value="${p.pro_details.pro_id }" id="productid" name="productid">
										 <input type="hidden" value="true" id="cartpage" name="cartpage">
										
                                    
										<button type="submit" class="btn btn-primary">
										<i class="fa fa-plus"></i>
									</button>
								
								
									</div>
									

								</form>
							</div>
						</td>
						<td data-th="Total" class="text-center" colspan="2"><label>&#8377 ${total}</label>
						</td>
					</tr>


				</c:forEach>

			</tbody>
			<tfoot>
				<tr>
					<td>Subtotal</td>
					<td />
					<td />
					<td data-th="Total" class="text-center" colspan="1">${total}</td>

				</tr>
				<tr>
					<td>Shipping</td>
					<td />
					<td />
					<td data-th="Total" class="text-center" colspan="1"><c:if
							test="${total>=1000 }">
							<c:set var="shipping" value="0"></c:set>
			               FREE
					</c:if> <c:if test="${total<1000 }">
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
					<td><a href="${cr}/allproducts"
						class="btn btn-warning"><i class="fa fa-angle-left"></i>
							Continue Shopping</a></td>
					<td colspan="2" class="hidden-xs"></td>
					<td />
					<td />


					<td><a href="${cr}/user/selectaddress"
						class="btn btn-success btn-block">Checkout <i
							class="fa fa-angle-right"></i>
					</a></td>
				</tr>
			</tfoot>
		</table>
	</c:if>
</div>
</body>
</html>