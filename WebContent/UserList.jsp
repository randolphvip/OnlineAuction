<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="top-css.jsp"%>
	<%	java.util.List<User> users =(java.util.List<User>)request.getAttribute("#USER");
		BaseBean pageBean= (BaseBean)request.getAttribute("#PAGE");
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
												<button onclick=" return SumbitJudge()" type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button> 
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
                            <h4>User List</h4>
                            <!--div class="add-product">
                                <a href="CommodityAdd.jsp">Add User</a>
                            </div-->
                            <div class="asset-inner">
                                <table>
                                    <tr class="alert alert-success">
                                        <th>User ID</th>
                                        <th>User Name</th>
                                        <th>First Namme</th>
                                        <th>Last Name</th>
                                        <th>Gender</th>
                                        <th>Mobile</th>
                                        <th>Address</th>
										<th>EMail</th>
										<th>Admin</th>
										<th>State</th>
										<th>Setting</th>
                                    </tr>
									
									<%
									if (users!=null)
									for(User user:users){%>	
									
                                    <tr>
                                        <td><%=user.getId()%></td>
                                        <td><%=user.getUserName()%></td>
                                        <td><%=user.getFirstName()%></td>
                                        <td><%=user.getLastName()%></td>
                                        <td >
											<%if(user.getGender()==util.Content.FEMALE){
												out.println("FEMALE");
											}else if (user.getGender()==util.Content.MALE){
												out.println("MALE");
											}else{
												out.println("");
											}
											%>										
										</td>
                                        <td><%=user.getMobile()%></td>
                                        <td><%=user.getAddress()%></td>
										<td><%=user.getEmail()%></td>
										<td>										
											<%if(user.getAdmin()==util.Content.Admin_YES){
												out.println("<button class='pd-setting'>Yes</button>");
											}else if (user.getAdmin()==util.Content.Admin_NO){
												out.println("<button class='ds-setting'>NO</button>");
											}else{
												out.println("");
											}
											%>
										</td>
										
										<td>										
											<%if(user.getState()==util.Content.USER_STATE_ENABLE){
												out.println("<button class='pd-setting'>ENABLE</button>");
											}else if (user.getState()==util.Content.USER_STATE_DISABLE){
												out.println("<button class='ds-setting'>DISABLE</button>");
											}else{
												out.println("");
											}
											%>
										</td>
                                        <td>
											<a title="edit" href="edit">
												<button data-toggle="tooltip" title="Edit" class="pd-setting-ed">
													<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</button>
											</a>
											
											
											
											
											<%if(user.getState()==util.Content.USER_STATE_ENABLE){%>
												<a title="DISABLE" href="javascript:if(confirm('Comfirm to disable this item?')) location.href='UserChangeStateServlet?id=<%=user.getId()%>&state=2'" >
													<button data-toggle="tooltip" title="Disable" class="pd-setting-ed">
														<i class="fa fa-trash-o" aria-hidden="true"></i>
													</button>
												</a>
											<%
											}else if (user.getState()==util.Content.USER_STATE_DISABLE){%>
												<a title="ENABLE" href="javascript:if(confirm('Comfirm to enable this item?')) location.href='UserChangeStateServlet?id=<%=user.getId()%>&state=1'">
													 <button class="btn btn-default btn-sm"><i class="fa fa-check"></i></button>
												</a>
											<%}else{
												out.println("");
											}
											%>
											
											
											
                                        </td>
                                    </tr>
									<%}%>
                                   
                                   
                                </table>
                            </div>
							
							<form name="pageForm" id="pageForm" action="UserSearchManagementServlet" method="post">
								<div class="custom-pagination">
									<nav aria-label="Page navigation example">
									
										 <input type="hidden" id ="pageNumber" name ="pageNumber" value="<%=pageBean.getPageNumber()%>">
										<ul class="pagination">
											<li class="page-item"><a class="page-link" href="javascript:previous();">Previous</a></li>
											<li class="page-item"><a class="page-link" href="#">1</a></li>
											<li class="page-item"><a class="page-link" href="#">2</a></li>
											<li class="page-item"><a class="page-link" href="#">3</a></li>
											<li class="page-item"><a class="page-link" href="javascript:next()">Next</a></li>
										</ul>
									<Script language="javaScript">
										function next(){
											document.pageForm.pageNumber.value=Number(document.pageForm.pageNumber.value)+1;
											document.pageForm.submit();
										}
										function previous(){
											if(document.pageForm.pageNumber.value>0){
											document.pageForm.pageNumber.value=Number(document.pageForm.pageNumber.value)-1;
											}
											document.pageForm.submit();
										}
							
									</Script>
									</nav>
								</div>
							</form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
    </div>

    
</body>

</html>