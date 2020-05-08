<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="top-css.jsp"%>
	<%	java.util.List<Order> orderList =(java.util.List<Order>)request.getAttribute("#ORDER");%>
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
            <!--div class="breadcome-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="breadcome-list single-page-breadcome">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div class="breadcome-heading">
                                            <form role="search" class="sr-input-func">
                                                <input type="text" placeholder="Search..." class="search-int form-control">
                                                <a href="#"><i class="fa fa-search"></i></a>
											</form>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div-->
        </div>
        <div class="product-status mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-status-wrap drp-lst" style="padding:40px">
                            <h4>Order List</h4>
                            <div class="add-product">
                                
                            </div>
                            <div class="asset-inner">
                                <table>
                                    <tr class="alert alert-success">
                                        <th>ID</th>
										<th>photo</th>
										<th>TITLE</th>
										<th>PRICE</th>
                                        <th>DEAL_DATE</th>
										<th>WINNER USER</th>
										<th>PICK UP DATE</th>
										<th>Status</th>
										<% if (user.getAdmin()==util.Content.Admin_YES){
											out.print("<th>Setting</th>");
										}%>
                                        <!--th>Setting</th-->
                                    </tr>
									
									<%
									if (orderList!=null)
									for(Order order:orderList){
										Commodity commodity = order.getCommodity();
										%>	
									
                                    <tr>
                                        <td><a href="CommondityShowDetailServlet?id=<%=commodity.getId()%>"><%=order.getId()%></a></td>
										<td><a href="CommondityShowDetailServlet?id=<%=commodity.getId()%>"><img alt="logo" class="img-circle m-b" src="<%=commodity.getPicture()%>"></a></td>
										<td><a href="CommondityShowDetailServlet?id=<%=commodity.getId()%>"><%=commodity.getTitle()%></a></td>
										<td><%=order.getPrice()%></td>
                                        <td><%=order.getDealDate()%></td>
										<td><a href="UserDetailServlet?id=<%=order.getWinnerId()%>"><%=order.getWinnerId()%></a></td>
										<td><%
											if (order.getPickUpDate()==null){
												out.println("No appointment yet ");
											}else{
												out.println(order.getPickUpDate());
											}
										%></td>
                                        <td>
										
										<% if (user.getAdmin()==util.Content.Admin_NO){
												if(order.getPickUpState()==util.Content.PICK_UP_STATE_NO){%>
													<a href="OrderDetailServlet?OrderID=<%=order.getId()%>"><button class='btn btn-info widget-btn-2 btn-sm'> Make An Appointment</button></a>
											<% 	}else if(order.getPickUpState()==util.Content.PICK_UP_STATE_YES){%>
													<button class='btn btn-warning widget-btn-3 btn-sm'> Success</button>
											<%	}else if(order.getPickUpState()==util.Content.PICK_UP_STATE_APPOINTED){%>
													<a href="OrderDetailServlet?OrderID=<%=order.getId()%>"><button class='btn btn-warning widget-btn-3 btn-sm'> Update Appointment Date</button></a>
												
											<%}
										} else{if(order.getPickUpState()==util.Content.PICK_UP_STATE_NO){%>
												<a href="OrderDetailServlet?OrderID=<%=order.getId()%>">
													<button class='btn btn-info widget-btn-2 btn-sm'> Did Not Make Appointment</button>
												</a>
											<% 	}else if(order.getPickUpState()==util.Content.PICK_UP_STATE_YES){%>
												<a href="OrderDetailServlet?OrderID=<%=order.getId()%>">
													<button class='btn btn-warning widget-btn-3 btn-sm'> Success</button>
												</a>
											<%	}else if(order.getPickUpState()==util.Content.PICK_UP_STATE_APPOINTED){%>
												<a href="OrderDetailServlet?OrderID=<%=order.getId()%>">
													<button class='btn btn-warning widget-btn-4 btn-sm'> Already Booked</button>
												</a>
											<%}
											
										}%>
											<!--button class='btn btn-success widget-btn-1 btn-sm'>Deleted</button>
											<button class='btn btn-info widget-btn-2 btn-sm'>Deleted</button>
                                            <button class='btn btn-warning widget-btn-3 btn-sm'>Deleted</button>
											<button class='btn btn-danger widget-btn-4 btn-sm'>Deleted</button-->
                                        </td> 
										
										<% if (user.getAdmin()==util.Content.Admin_YES){%>
										<td>
															
											<!--a title="MyWinServlet" href="edit">
												<button data-toggle="tooltip" title="Edit" class="pd-setting-ed">
													<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</button>
											</a-->
											 
											
											<a title="" href="OrderStateChangeServlet?pickUpState=2&orderID=<%=order.getId()%>">
											 	<button  title="change state to no appiontment" class="pd-setting-ed">
													<i class="fa fa-exclamation"></i>
												</button>
											</a>
											
											<a title="" href="OrderStateChangeServlet?pickUpState=1&orderID=<%=order.getId()%>">
											 	<button  title="change state to picked up" class="pd-setting-ed">
													<i class="fa fa-check"></i>
												</button>
											</a>
                                        </td>
											
										<%}%>
                                         
                                    </tr>
									
									<%}%>
                                   
                                   
                                </table>
                            </div>
                            <div class="custom-pagination">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
    </div>

    
</body>

</html>