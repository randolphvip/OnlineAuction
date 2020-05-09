<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="top-css.jsp"%>
	<%	java.util.List<Cart> cartList =(java.util.List<Cart>)request.getAttribute("#CART");%>
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
                            <h4>Cart </h4>
                            <div class="add-product">
                                
                            </div>
                            <div class="asset-inner">
                                <table>
                                    <tr class="alert alert-success">
                                        <th>ID</th>
										<th>PHOTO</th>
										<th>TITLE</th>
										<th>INITIAL PRICE</th>
										<th>CURRENT PRICE</th>
                                        <th>PUBLISH DATE</th>
										<th>CLOSE DATE</th>
										<th>Status</th>
									    <th>Setting</th>
                                    </tr>
									
									<%
									if (cartList!=null)
									for(Cart cart:cartList){
										
										%>	
									
                                    <tr>
                                        <td><a href="CommondityShowDetailServlet?id=<%=cart.getCommodityId()%>"><%=cart.getCommodityId()%></a></td>
										<td><a href="CommondityShowDetailServlet?id=<%=cart.getCommodityId()%>"><img alt="logo" class="img-circle m-b" src="<%=cart.getPicture()%>"></a></td>
										<td><a href="CommondityShowDetailServlet?id=<%=cart.getCommodityId()%>"><%=cart.getTitle()%></a></td>
										<td><%=cart.getPrice()%></td>
										<td><%=cart.getMaxPrice()%></td>
                                        <td><%=cart.getPublishDate()%></td>
										 <td><%=cart.getCloseDate()%></td>
										<td><a href="UserDetailServlet?id=<%=cart.getWinnerId()%>"><%=cart.getWinnerId()%></a></td>
										<td></td>
                                        <td></td> 
										
										 
                                         
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