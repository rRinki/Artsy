<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
.trn {
	background: rgba(0, 0, 0, 0.5);
}

.navbar-brand {
	margin-top: 100px;
	margin-top: -5px;
}

li a {
	display: block;
	color: #blue;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.nav-link {
	color: #black !important;
}

li a:hover {
	background-color: #111;
	padding: 3px 0;
	-webkit-transition: .5s all ease;
	-moz-transition: .5s all ease;
	transition: .5s all ease;
}

li a:hover:not(.active)
{
background-color:#324;
}
li a.active {
	xcolor: white;
	xbackground-color: #4CAF50;
}
</style>

<nav>
	<nav class=" navbar navbar-expand-md navbar-dark  fixed-top trn">
		<div class="row">

			<a class="navbar-brand text-center" href="Home"> <img
				src="${cr}/img/logo.PNG" width="120" height="50" alt=""></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<div class="col text center">
				<ul class="navbar-nav pull-right">

					<c:choose>
						<c:when test="${sessionScope.adminrole}">




							<li class="nav-item active"><a class="nav-link"
								href="${cr}/Home">HOME</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="${cr}/admin/Category">MANAGE CATEGORY</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="${cr}/admin/products">MANAGE PRODUCT</a></li>
							<li class="nav-item active"><a class="nav-link "
								href="${cr}/ContactUS">CONTACT US</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="${cr}/AboutUS">ABOUT US</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="${cr}/Home">Hi ${sessionScope.username}!</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="logout">LOGOUT</a></li>


						</c:when>

						<c:when test="${userrole}">

							<li class="nav-item active"><a class="nav-link"
								href="${cr}/Home">HOME</a></li>


							<li class="nav-item active"><a class="nav-link"
								href="${cr}/allproducts">PRODUCT</a></li>
							<li class="nav-item active"><a class="nav-link "
								href="${cr}/ContactUS">CONTACT US</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="${cr}/AboutUS">ABOUT US</a></li>
								<li class="nav-item active"><a class="nav-link"
								href="${cr}/user/viewCart">Cart<i class="fa fa-shopping-cart"><sup>${cartqty}</sup></i></a></li>

							<li class="nav-item active"><a class="nav-link"
								href="${cr}/Register">REGISTER</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="${cr}/Home">Welcome ${sessionScope.username}!</a></li>

							<li class="nav-item active"><a class="nav-link"
								href="${cr}/logout">LOGOUT</a></li>


						</c:when>

						<c:otherwise>

							<li class="nav-item active"><a class="nav-link"
								href="${cr}/Home">HOME</a></li>
							<li class="nav-item active"><a class="nav-link "
								href="${cr}/ContactUS">CONTACT US</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="${cr}/allproducts">PRODUCT</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="${cr}/AboutUS">ABOUT US</a></li>
							<li class="nav-item active"><a class="nav-link" href="Login"><span
									class="glyphicon glyphicon-log-in"></span>LOGIN</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="${cr}/Register">REGISTER</a></li>


						</c:otherwise>
					</c:choose>
				</ul>
			</div>


		</div>
	</nav>
</nav>


<script>
	// Scrolling Effect
	$(document)
			.ready(
					function() {
						$(window)
								.scroll(
										function() {
											var scroll = $(window).scrollTop();
											if (scroll > 30) {
												$(".navbar")
														.css("background",
																"linear-gradient(rgba(247, 16, 16, 0.712),rgb(12, 11, 11))");
											}

											else {
												$(".navbar").css("background",
														"rgba(0, 0, 0, 0.2)");
											}
										})
					})
</script>


