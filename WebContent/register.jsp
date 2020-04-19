<!DOCTYPE html>
<html lang="en">


<body>
	
	<%@ include file="top.jsp"%>
	<!--//////////////////////////////////////////////////-->
	<!--///////////////////Account Page///////////////////-->
	<!--//////////////////////////////////////////////////-->
	<script language="javaScript">
	<% if (request.getParameter("errorMsg")!=null&&request.getParameter("errorMsg").equals("1")){
		 
		
		out.println("alert('please change a new username')");
		 
	}else{
		System.out.println("--top---null");
	}
		%>
	</script
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="IndexServlet">Home</a></li>
						<li><a href="login2.jsp">Account</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<!--div class="col-md-6">
					<div class="heading"><h2>Login</h2></div>
					<form name="form1" id="ff1" method="post" action="LoginServlet">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Username :" name="username" id="username" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password :" name="password" id="password" required>
						</div>
						<button type="submit" class="btn btn-1" name="login" id="login">Login</button>
						<a href="#">Forgot Your Password ?</a>
						<a href="register.jsp"> <button  type="button" class="btn btn-1" name="register" id="register">register</button></a>
						
					</form>
				</div-->
				<div class="col-md-6">
					<div class="heading"><h2>New User ? Create An Account.</h2></div>
					<form name="form2" id="ff2" method="post" action="RegisterServlet">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="UserName :" name="userName" id="userName" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="First Name :" name="firstName" id="firstName" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Last Name :" name="lastName" id="lastName" required>
						</div>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="Email Address :" name="email" id="email" required>
						</div>
						<div class="form-group">
							<input type="tel" class="form-control" placeholder="Mobile :" name="mobile" id="mobile" required>
						</div>
						<div class="form-group">
							<input name="gender" id="gender" type="radio" value ="0" selected> Male <input name="gender" id="gender" type="radio" value ="1"> Female 
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password :" name="password" id="password" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Retype Password :" name="repassword" id="repassword" required>
						</div>
						<div class="form-group">
							<input name="agree" id="agree" type="checkbox" > I agree to your website.
						</div>
						<button type="submit" class="btn btn-1">Create</button>
					</form>
				</div>
			</div>
		</div>
	</div>
 <%@ include file="bottom.jsp"%>
</body>
</html>