<!DOCTYPE html>
<html lang="en">


<body>
	<script language="javaScript">
		function change2Mail(){
			 
			document.getElementById("MailDiv").style.display="";
			document.getElementById("MobileDiv").style.display="none";
			document.getElementById("mobile").value="";
			 
		}
		function change2Mobile(){
			document.getElementById("MailDiv").style.display="none";
			document.getElementById("MobileDiv").style.display="";
			document.getElementById("email").value="";
		}
	</script>
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
					<form name="mainForm" id="mainForm" method="post" action="RecoverPasswordServlet">
						<div class="form-group">
						User name
							<input type="text" class="form-control" placeholder="Username :" name="username" id="username" required>
						</div>
						
						<div class="form-group">
							<input name="rt" id="rt" type="radio" value ="1" checked onclick="change2Mail()"> E-Mail 
							&emsp;&emsp;&emsp;&emsp;
							<input name="rt" id="rt" type="radio" value ="2"onclick="change2Mobile()"> Mobile 
						</div>
						
						<div class="form-group"  id="MailDiv" name  ="MailDiv" >
							Email Address:
							<input type="text" class="form-control" placeholder="Email address" name="email" id="email" >
						</div>
						<div class="form-group" id="MobileDiv" name ="MobileDiv" style="display:none" >
							Mobile:
							<input type="text" class="form-control" placeholder="mobile number:" name="mobile" id="mobile" >
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