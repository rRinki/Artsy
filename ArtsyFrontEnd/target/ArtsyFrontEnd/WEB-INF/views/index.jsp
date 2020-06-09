<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
<body>

	<jsp:include page="Navbar.jsp"></jsp:include>
	
	
	<div style="min-height: 500px;">
		<c:if test="${indexpage}">
			<jsp:include page="Home.jsp"></jsp:include>
		</c:if>
		<c:if test="${contactus}">
			<jsp:include page="ContactUS.jsp"></jsp:include>
		</c:if>
		<c:if test="${aboutuspage}">
			<jsp:include page="AboutUS.jsp"></jsp:include>
		</c:if>
		<c:if test="${loginpage}">
			<jsp:include page="Login.jsp"></jsp:include>
		</c:if>
		<c:if test="${registerpage}">
			<jsp:include page="Register.jsp"></jsp:include>
		</c:if>
		<c:if test="${productpage}">
			<jsp:include page="Product.jsp"></jsp:include>
		</c:if>
		<c:if test="${cust_productpage}">
			<jsp:include page="allproducts.jsp"></jsp:include>
		</c:if>
		
		<c:if test="${one_productpage}">
			<jsp:include page="Oneproduct.jsp"></jsp:include>
		</c:if>
		<c:if test="${categorypage}">
			<jsp:include page="Category.jsp"></jsp:include>
		</c:if>
		<c:if test="${cartpage}">
			<jsp:include page="viewcart.jsp"></jsp:include>
		</c:if>
		<c:if test="${addresspage}">
			<jsp:include page="alladdress.jsp"></jsp:include>
		</c:if>
		<c:if test="${orderpage}">
			<jsp:include page="Orders.jsp"></jsp:include>
		</c:if>
		<c:if test="${oneorderspage}">
			<jsp:include page="OneOrder.jsp"></jsp:include>
		</c:if>
		
	</div>
	
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
