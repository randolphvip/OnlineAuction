<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Add Commodity |</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="top-css.jsp"%>
<script language="javascript">
<% if (request.getParameter("message")!=null&&request.getParameter("message").equals("1")){
	 out.println("alert('update success')");
}
%>
</script>
<script language ="javaScript">
function check(){
	if (mainForm.repassword.value!=mainForm.password.value){
		alert("password is not equal");
		return false;
	}
	return ture;
}
</script>
</head>

<body>
    <!--[if lt IE 8]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
    <!-- Start Left menu area -->
    <%@ include file="MenuManagementLeft.jsp"%>
    <!-- End Left menu area -->
    <!-- Start Welcome area -->
    <div class="all-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="logo-pro">
                        <a href="IndexServlet"><img class="main-logo" src="img/logo/2logo.png" alt="" /></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="header-advance-area">
            
            <!-- Mobile Menu start -->
            <%@ include file="MenuManagementMobile.jsp"%>
            <!-- Mobile Menu end -->
            <div class="breadcome-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<ul class="breadcome-menu">
								<li><a href="IndexServlet">Home</a> <span class="bread-slash">/</span>
								</li>
								<li><span class="bread-blod"><a href="IndexServlet">Back to the Main Page</a></span>
								</li>
							</ul>
						</div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Single pro tab review Start-->
        <div class="single-pro-review-area mt-t-30 mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-payment-inner-st" style="padding:20px">
                            <ul id="myTabedu1" class="tab-review-design">
                                <li class="active"><h5><a href="#description">User Information</a></h5></li>
                                
                            </ul>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="col-md-6">
											<form name="mainForm" id="mainForm" method="post" action="UserUpdateServlet">
													<div class="form-group">UserName:
														<input type="text" class="form-control" placeholder="UserName :" name="userName" id="userName" value='<%=user.getUserName()%>' disabled required>
													</div>
													<div class="form-group">First Name:
														<input type="text" class="form-control" placeholder="First Name :" name="firstName" id="firstName" maxlength="40"  value='<%=user.getFirstName()%>' required>
													</div>
													<div class="form-group">Last Name:
														<input type="text" class="form-control" placeholder="Last Name :" name="lastName" id="lastName" maxlength="40"  value='<%=user.getLastName()%>'  required>
													</div>
													<div class="form-group">Email Address:
														<input type="email" class="form-control" placeholder="Email Address :" name="email" id="email" maxlength="100"  value='<%=user.getEmail()%>'  required>
													</div>
													<div class="form-group">Mobile:
														<input type="tel" class="form-control" placeholder="Mobile :" name="mobile" id="mobile" maxlength="20" value='<%=user.getMobile()%>'  required>
													</div>
													<div class="form-group">Address:
														<input type="text" class="form-control" placeholder="address :" name="address" id="address" maxlength="300"  value='<%=user.getAddress()%>'  required>
													</div>
													<div class="form-group">Gender:
														<input name="gender" id="gender" type="radio" value ="1" <%if (user.getGender()==util.Content.FEMALE){out.print("checked");}%>> Male <input name="gender" id="gender" type="radio" value ="2"  <%if (user.getGender()==util.Content.MALE){out.print("checked");}%>> Female 
													</div>
													<div class="form-group">Password:
														<input type="password" class="form-control" placeholder="Password :" name="password" id="password" pattern=".{6,}" title="6 characters minimum" maxlength="45"  value='<%=user.getPassword()%>'  required>
													</div>
													<div class="form-group">Retype Password:
														<input type="password" class="form-control" placeholder="Retype Password :" name="repassword" id="repassword" value='<%=user.getPassword()%>' required>
													</div>
													 <input type="hidden"  name="userID" id="userID" value='<%=user.getId()%>'>
													<button type="submit" onclick ="return  check()" class="btn btn-1">Update</button>&emsp; &emsp; &emsp; 
													<button type="button" class="btn btn-1" onclick="window.history.back(-1)">&nbsp;back&nbsp; </button>
												</form>
												
                                            </div>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         
    </div>

    
</body>

</html>