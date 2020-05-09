<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Order Detail |</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="top-css.jsp"%>
	<%Order order =(Order)request.getAttribute("#ORDER");
	Commodity commodity=order.getCommodity();
	String message = order.getMessage();
	System.out.println("message----------------"+message);
	java.sql.Timestamp pickUpDate= order.getPickUpDate();
	String pickUpDateString =null;
	if(pickUpDate!=null){
		 pickUpDateString=util.Utils.dateToStr(pickUpDate);
		pickUpDateString=pickUpDateString.replace(" ", "T");
	}	 
	%>
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
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                           
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                      
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <ul class="breadcome-menu">
                                            <li><a href="IndexServlet">Home</a> <span class="bread-slash">/</span>
                                            </li>
                                            <li><span class="bread-blod"><a href="OrderListUserServlet">Back to the Order List</a></span>
                                            </li>
                                        </ul>
                                    </div>
                               
                            </div>
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
                                <li class="active"><a href="#description">Make Appointment</a></li>
                                
                            </ul>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                
												<form id="add-department" action="MakeAppointmentServlet" class="add-department" method="post">
                                                    <div class="row">
                                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														  <div class="form-group">
                                                             <label>commodity ID</label> <br>
															 <a href="CommondityShowDetailServlet?id=<%=commodity.getId()%>">&nbsp;&nbsp;&nbsp;<%=order.getId()%></a>
															</div>
														    <div class="form-group">
                                                             <label>TITLE</label> <br>
															 <a href="CommondityShowDetailServlet?id=<%=commodity.getId()%>">
															  &nbsp;&nbsp;&nbsp;<%=commodity.getTitle()%></a>
															</div>
                                                            <div class="form-group">
																<label>Final Price</label><br>
                                                              <span class="message-content"> &nbsp;&nbsp;&nbsp;<%=order.getPrice()%></span>
                                                            </div>
															<div class="form-group">
																<label>Picture</label><br>
																<img style="width:205px;height:260px" src="<%=commodity.getPicture()%>" />
														 
                                                            </div>
															<div class="form-group">
																<label>Pick Up Date</label>  
																<input name="pickUpDate" id="pickUpDate" type="datetime-local" class="form-control" value="<%if (pickUpDateString!=null) out.print(pickUpDateString);%>"  required />
                                                            </div>
															<div class="form-group res-mg-t-15">
															  <label>MESSAGE</label>   
																<textarea name="message" id="message" placeholder="message" required><%if (message!=null) out.print(message);%></textarea>
															<input name="orderID" id="orderID" type="hidden" value="<%=order.getId()%>"   />
															
															</div>
                                                        </div>
                                                       
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <div class="payment-adress">
															<% if (user.getAdmin()==util.Content.Admin_NO){%>
                                                                <button type="submit"  class="btn btn-primary waves-effect waves-light">Submit</button>
															<%}%>
																<button onclick="location='OrderListUserServlet'"  class="btn btn-primary waves-effect waves-light">Back</button>
															 
                                                            </div>
                                                        </div>
                                                    </div>
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