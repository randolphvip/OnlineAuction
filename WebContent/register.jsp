<!DOCTYPE html>
<html lang="en">
<script language ="javaScript">
function check(){
	if (mainForm.repassword.value!=mainForm.password.value){
		alert("password is not equal");
		return false;
	}
	return ture;
}
</script>

<body>
	
	<%@ include file="top.jsp"%>
	<!--//////////////////////////////////////////////////-->
	<!--///////////////////Account Page///////////////////-->
	<!--//////////////////////////////////////////////////-->
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
					<form name="mainForm" id="mainForm" method="post" action="RegisterServlet">
						<div class="form-group">UserName:
							<input type="text" class="form-control" placeholder="UserName :" name="userName" id="userName" maxlength="20" pattern=".{6,}" title="6 characters minimum" required>
						</div>
						<div class="form-group">First Name:
							<input type="text" class="form-control" placeholder="First Name :" name="firstName" id="firstName" maxlength="40" required>
						</div>
						<div class="form-group">Last Name:
							<input type="text" class="form-control" placeholder="Last Name :" name="lastName" id="lastName" maxlength="40" required>
						</div>
						<div class="form-group">Email Address:
							<input type="email" class="form-control" placeholder="Email Address :" name="email" id="email" maxlength="100" required>
						</div>
						<div class="form-group">Mobile:
							<input type="tel" class="form-control" placeholder="Mobile :" name="mobile" id="mobile" maxlength="20" required>
						</div>
						<div class="form-group">Address:
							<input type="text" class="form-control" placeholder="address :" name="address" id="address"maxlength="300" required>
						</div>
						<div class="form-group">Gender:
							<input name="gender" id="gender" type="radio" value ="2" checked> Male <input name="gender" id="gender" type="radio" value ="1"> Female 
						</div>
						<div class="form-group">Password:
							<input type="password" class="form-control" placeholder="Password :" name="password" id="password" pattern=".{6,}" title="6 characters minimum" maxlength="45" required>
						</div>
						<div class="form-group">Retype Password:
							<input type="password" class="form-control" placeholder="Retype Password :" name="repassword" id="repassword" required>
						</div>
						<div class="form-group">
							<input name="agree" id="agree" type="checkbox" > I agree to your website.
						</div>
						<button type="submit"  onclick ="return  check()" id="submit" class="btn btn-1">Create</button>
					</form>
				</div>
			</div>
		</div>
	</div>
 <%@ include file="bottom.jsp"%>
</body>
</html>