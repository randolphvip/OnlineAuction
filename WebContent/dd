<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Add Commodity |</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="top-css.jsp"%>
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
                            <div class="breadcome-list single-page-breadcome">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                      
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <ul class="breadcome-menu">
                                            <li><a href="IndexServlet">Home</a> <span class="bread-slash">/</span>
                                            </li>
                                            <li><span class="bread-blod"><a href="UserSearchManagementServlet">Back to the Commodities List</a></span>
                                            </li>
                                        </ul>
                                    </div>
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
                        <div class="product-payment-inner-st" style="padding:80px">
                            <ul id="myTabedu1" class="tab-review-design">
                                <li class="active"><a href="#description">Add Commodity</a></li>
                                
                            </ul>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                
												<form id="add-department" action="CommodityAddServlet" class="add-department" method="post"  enctype="multipart/form-data">
                                                    <div class="row">
                                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                            <div class="form-group">
                                                             <label>TITLE</label>   
															 <input name="title" id ="title"type="text"  class="form-control" placeholder="title" required>
                                                            </div>
                                                            <div class="form-group">
																<label>Initial Price</label>  
                                                                <input  name="price" id="price" type="number" class="form-control" placeholder="Initial Price" required>
                                                            </div>
															<div class="form-group">
																<label>Close Date</label>  
																<!--input name="" id="" type="datetime-local"value="2015-09-24T13:59:59" min="2015-09-16" max="2015-09-26" /-->
																<input name="closeDate" id="closeDate" type="datetime-local" class="form-control" required />
                                                            </div>
															 <div class="form-group">
																<label>category</label>  
                                                                <select name="category" id="category" class="form-control" required>
																	<option value="none" selected="" disabled="">Select category</option>
																	<option value="1">TOY</option>
																	<option value="2">KITCHEN&STUFF</option>
																	<option value="3">TOOLS</option>
																	<option value="4">DECORATION</option>
																	<option value="5">CLOTHES</option>
																	
																</select>
                                                            </div>
															 <div class="form-group">
																<label>picture</label>  
                                                                <input   name="uploadFile" id="File" type="file" class="form-control" required>
                                                            </div>
                                                          
															 <div class="form-group res-mg-t-15">
															  <label>Description</label>   
																<textarea name="description" id="description" placeholder="Description" required></textarea>
															</div>
                                                        </div>
                                                       
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <div class="payment-adress">
                                                                <button type="submit" onclick="alert(add-department.closeDate.value)" class="btn btn-primary waves-effect waves-light">Submit</button>
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