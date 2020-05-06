<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0"><html>
<head>
 <meta charset="utf-8">
 
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
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
  
</head>


  <style>
    body{
      background-image:url(img/Login.png);
      background-size:cover;
      
      
    }
    .jump{
      background: rgba(255, 255, 255,0.755);
      xbackground-size: cover;
      backgroung-color:rgba(255, 255, 255,0.9);
      box-shadow: 0 5px 15px rgba(0, 0,0,.5);
      padding:10%;
      
    }
  </style>

        <!--div class="container-fluid bg">
            <div class="row">
                    <h2 class="text-center">LOGIN</h2>
                    <div class="form-group row" margin-left 50% margin-right 50% padding 20%> 
                <div class="col-md-4 col-sm-4 col-xs-12"></div>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                <form class="form-container">
                        <div class="form-group">
                          <label for="exampleInputEmail1">Email address</label>
                          <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        </div>
                        <div class="form-group">
                          <label for="exampleInputPassword1">Password</label>
                          <input type="password" class="form-control" id="exampleInputPassword1">
                        </div>
                        <div class="form-group form-check">
                          <input type="checkbox" class="form-check-input" id="exampleCheck1">
                          <label class="form-check-label" for="exampleCheck1">Check me out</label>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button type="button" class="btn btn-outline-danger">CANCEL</button>
                      </form>
                    </div>
                    </div>
                </div>
            </div>-->

 <div class="container">
   <div class ="row">
    <div class="col-6" style="width:600px;margin-left:250px;margin-top:50px;">
       <div class="conatiner jump">
        <div class="form-group">
           <h2 style="text-align: center">LOGIN</h2></div>

          <hr>
  <form class="form-horizontal" style="margin-left:50px;margin-right:50px;" >
       <div class="form-group input-group">
           <span class="input-group-addon" >
           <span class="glyphicon glyphicon-lock"></span>
              </span>
          <input type="email" class="form-control" name="email" placeholder="Enter Email..." required>
           </div>

                        
                          
  <div class="form-group input-group">
     <span class="input-group-addon">
      <span class="glyphicon glyphicon-lock"></span>
       </span>
            <input type="password" class="form-control" name="password" placeholder="Enter Password..."required>
           </div>
                          
     <div class="form-group">
       <label>
        <input type="checkbox">
                         Remember Me</label>
                           </div>
         
         <div class="form-group">
          <button class="btn btn-primary">Login</button>
          </div>

          <div class="form-group">
            <a href="#">Forgot Password</a>
              </div>
            
              </form>
            </div>
            </div>
          </div>
        </div>
      
           
            



                        