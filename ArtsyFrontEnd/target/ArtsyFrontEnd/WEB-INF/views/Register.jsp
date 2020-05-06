<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

   <style>
        .jumbotron{
            box-shadow: 10px 10px 5px grey;
            background-color: rgb(209, 181, 184);
            background-image: url("img/11.png");
            background-size: cover;
        }

       body{
            background-image: url("img/11.png");
            background-size: cover;
            
        }
    .container{
        margin-left: auto; 
        margin-right:auto;
    }
    
    
   </style>

        <body>
               <div>
               
               
       <div class="col-md-4 mx-auto">
       page<div class="jumbotron" style="margin-top:5%;" >
            
      
        
        <h3 class="text-center">Access our products with a free account</h3>
        <h5 class="text-center">Sign up to see more</h5>
        <br>
        
        <c:if test="${success}">
				<div class="alert alert-success">
					<strong>Success!</strong>Customer Added.
					<h3>${message}</h3>
				</div>
			</c:if>
			<c:if test="${error1}">
				<div class="alert alert-danger">
					<strong>Danger!</strong>Check the data again.
					<h3>${message}</h3>
				</div>
			</c:if>

			<c:if test="${error2}">
				<div class="alert alert-warning">
					<strong>Warning!</strong>Customer Already Exists.
					<h3>${message}</h3>
				</div>
			</c:if>
			
		
          <div class="container" >
          <form:form action="addcustomer" method="post" modelAttribute="customerobject">
          
         <div class="form-group col-md-12">
            <form:input type="text" class="form-control" placeholder="Name**" path="cus_Name"/>
            <form:errors path="cus_Name" cssStyle="color:Red"></form:errors>
        </div>

        <div class="form-group col-md-12">
            <form:input type="text" class="form-control" placeholder="Your Phone**" path="cus_Phone"/>
            <form:errors path="cus_Phone" cssStyle="color:Red"></form:errors>
        </div>

        <div class="form-group col-md-12">
            <form:input type="text" class="form-control" placeholder="Your Email**" path="cus_Email"/>
            <form:errors path="cus_Email" cssStyle="color:Red"></form:errors>
        </div>

        <div class="form-group col-md-12">
            <form:input type="text" class="form-control" placeholder="Password" path="cust_Password"/>
            <form:errors path="cust_Password" cssStyle="color:Red"></form:errors>
        </div>
        
        <h6 class="text-center">By clicking the Sign Up button,you agree to our Terms & Conditions and Privacy Policy</h6>
        <div class="form-group col-md-12">
            <input type="submit" class="btn btn-dark form-control" value="Sign Up">
            
            
        </div>
        </form:form>
    </div>

</div>
</div>
	</div>
</body>
