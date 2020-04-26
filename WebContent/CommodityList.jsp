<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="top-css.jsp"%>
	<%	java.util.List<Commodity> commodities =(java.util.List<Commodity>)request.getAttribute("#COMMODITY");%>
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
                        <a href="IndexServlet"><img class="main-logo" src="img/logo/logo.png" alt="" /></a>
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
            </div>
        </div>
        <div class="product-status mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-status-wrap drp-lst" style="padding:40px">
                            <h4>Commodities List</h4>
                            <div class="add-product">
                                <a href="CommodityAdd.jsp">Add Commodity</a>
                            </div>
                            <div class="asset-inner">
                                <table>
                                    <tr class="alert alert-success">
                                        <th>Commodity ID</th>
                                        <th>Title</th>
                                        <th>Status</th>
                                        <th>Initial price</th>
                                        <th>Max Price</th>
                                        <th>photo</th>
                                        <th>Close Date</th>
                                        <th>Setting</th>
                                    </tr>
									
									<%
									if (commodities!=null)
									for(Commodity commodity:commodities){%>	
									
                                    <tr>
                                        <td><%=commodity.getId()%></td>
                                        <td><%=commodity.getTitle()%></td>
                                        <td>
											<%if(commodity.getState()==util.Content.COMMODITY_STATE_SELLING){
												out.println("<button class='pd-setting'>Active</button>");
											}else if (commodity.getState()==util.Content.COMMODITY_STATE_SOLD){
												out.println("<button class='ds-setting'>Sold</button>");
											}else if (commodity.getState()==util.Content.COMMODITY_STATE_DELETED){
												out.println("<button class='ps-setting'>Deleted</button>");
											}
											%>
                                            
                                        </td>
                                        <td><%=commodity.getPrice()%></td>
                                        <td><%=commodity.getMaxPrice()%></td>
                                        <td><img alt="logo" class="img-circle m-b" src="<%=commodity.getPicture()%>"></td>
                                        <td><%=commodity.getCloseDate()%></td>
                                        <td>
											<a title="MyWinServlet" href="edit">
												<button data-toggle="tooltip" title="Edit" class="pd-setting-ed">
													<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</button>
											</a>
											<a title="MyWinServlet" href="CommodityDeleteServlet?id=<%=commodity.getId()%>">
												<button data-toggle="tooltip" title="Trash" class="pd-setting-ed">
													<i class="fa fa-trash-o" aria-hidden="true"></i>
												</button>
											</a>
                                        </td>
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