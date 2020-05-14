<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Add Commodity |</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="top-css.jsp"%>
	<%Commodity commodity =(Commodity)request.getAttribute("#COMMODITY");%>
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
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<ul class="breadcome-menu">
								<li><a href="IndexServlet">Home</a> <span class="bread-slash">/</span>
								</li>
								<li><span class="bread-blod"><a href="CommoditySearchManageServlet">Back to the Commodities List</a></span>
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
                        <div class="product-payment-inner-st" style="padding:30px">
                            <ul id="myTabedu1" class="tab-review-design">
                                <li class="active"><a href="#description">Edit Commodity</a></li>
                                
                            </ul>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                
												<form id="add-department" action="CommodityUpdateServlet" class="add-department" method="post"  enctype="multipart/form-data">
                                                    <div class="row">
                                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                            <div class="form-group">
                                                             <label>TITLE</label>   
															 <input name="title" id ="title"type="text"  class="form-control" placeholder="title" value="<%=commodity.getTitle()%>" required>
                                                            </div>
                                                            <div class="form-group">
																
																<%if(commodity.getBids()!=null&&commodity.getBids().size()>0){%>
																	<font color="#FF0000">This commodity has already been  bid , So the  price could not be changed</font><br>
																	<label>current price</label>
																	  <input  name="maxPrice" id="maxPrice" type="number" class="form-control" value="<%=commodity.getMaxPrice()%>" placeholder="Initial Price" disabled required>
																<%}else{%> 
																	<label>Initial price</label>
																	  <input  name="price" id="price" type="number" class="form-control" value="<%=commodity.getPrice()%>" placeholder="Initial Price" required>
																<%}%>
                                                            </div>
															<div class="form-group">
																<label>Close Date</label>  
																<input name="closeDate" id="closeDate" type="datetime-local" class="form-control" value="<%=util.Utils.dateToStr(commodity.getCloseDate()).replace(" ", "T")%>" required />
																
																
                                                            </div>
															 <div class="form-group">
																<label>category</label>  
                                                                <select name="category" id="category" class="form-control" required>
																	<option value="none" selected="" disabled="">Select category</option>
																	<option value="1" <%if(commodity.getCategory()==1){out.print("SELECTED");}%>>TOY</option>
																	<option value="2" <%if(commodity.getCategory()==2){out.print("SELECTED");}%>>KITCHEN & STUFF</option>
																	<option value="3" <%if(commodity.getCategory()==3){out.print("SELECTED");}%>>TOOLS</option>
																	<option value="4" <%if(commodity.getCategory()==4){out.print("SELECTED");}%>>DECORATION</option>
																	<option value="5" <%if(commodity.getCategory()==5){out.print("SELECTED");}%>>CLOTHES</option>
																</select>
                                                            </div>
															 <div class="form-group">
																<label>picture</label>  
                                                                <input   name="uploadFile" id="File" type="file" class="form-control">
																<!--img alt="logo" class="img-circle m-b" src="<%=commodity.getPicture()%>"-->
																<img style="width:310px;height:390px" src="<%=commodity.getPicture()%>" />
                                                            </div>
                                                          
															 <div class="form-group res-mg-t-15">
															  <label>Description</label>   
																<textarea name="description" id="description" placeholder="Description" required><%=commodity.getIntroduce()%></textarea>
															</div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                            <div class="payment-adress">
																<input type="hidden"  name="commodityId" id="commodityId" value='<%=commodity.getId()%>'>
                                                                <button  onclick="" class="btn btn-primary waves-effect waves-light">Update</button> &emsp; &emsp; &emsp;
																
																<button type="button" onclick="location='CommoditySearchManageServlet'" class="btn btn-primary waves-effect waves-light">Back</button>
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