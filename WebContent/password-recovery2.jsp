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
					<p>Please input your new password</p>
					<p>
                            
                    </p>
					<form name="form1" id="ff1" method="post" action="ChangePasswordServlet">
						<div class="form-group">
						<%User user2 = (User)request.getAttribute("#USER");%>
							<input type="hidden" value ='<%=user2.getId()%>'  name="id" id="id" >
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="New Password :" name="password" id="password" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Retype Password :" name="repassword" id="repassword" required>
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