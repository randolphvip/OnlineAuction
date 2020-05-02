<!DOCTYPE html>
<html lang="en">


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
				<div class="col-md-6">
					<div class="heading"><h2>PASSWORD RECOVER</h2></div>
					<p>Please fill the form to recover your password</p>
					<p>
                            Enter your user name and your Email address or phone number.
                    </p>
					<form name="form1" id="ff1" method="post" action="RecoverPasswordServlet">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Username :" name="username" id="username" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Email address" name="email" id="email" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="mobile number:" name="mobile" id="mobile" required>
						</div>
						<button type="submit" class="btn btn-1" name="login" id="login">Reset password</button>
						 
						
					</form>
				</div>
				 
			</div>
			
			
			
			
			
			 
	
	
		</div>
	</div>
 <%@ include file="bottom.jsp"%>
</body>
</html>