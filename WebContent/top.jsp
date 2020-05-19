<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 2020-04-21 - -->
<%@page 
 import="impl.*"
 import="java.util.*"
 import="dao.*"
 import="entity.*"
 import="java.text.SimpleDateFormat"
 import="java.sql.Timestamp"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user=(User)session.getAttribute("user");
%>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>Charity Online Store</title>
	 
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css"  type="text/css">
	
	<!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
	
	
	<!-- Custom Fonts -->
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="fonts/font-slider.css" type="text/css">
	
	<!-- jQuery and Modernizr-->
	<script src="js/jquery-2.1.1.js"></script>
	
	<!-- Core JavaScript Files -->  	 
    <script src="js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
			<% if (request.getAttribute("#MESSAGE")!=null){
				System.out.println("--top---"+request.getAttribute("#MESSAGE"));
				
				out.println("alert('"+request.getAttribute("#MESSAGE")+"')");
				 
			}else{
			//	System.out.println("--top---null");
			}
			%>
		
			<% if (request.getParameter("errorMsg")!=null&&request.getParameter("errorMsg").equals("1")){
				 out.println("alert('please change a new username')");
			}else if (request.getParameter("errorMsg")!=null&&request.getParameter("errorMsg").equals("2")){
				 out.println("alert('Login failed ')");
			}else if (request.getParameter("errorMsg")!=null&&request.getParameter("errorMsg").equals("3")){
				 out.println("alert('Could not find the user. Please provide correct user name and email or phone ')");
			}else  if (request.getParameter("errorMsg")!=null&&request.getParameter("errorMsg").equals("4")){
				 out.println("alert('Password change failed, please contact administrator. ')");
			}else  if (request.getParameter("errorMsg")!=null&&request.getParameter("errorMsg").equals("5")){
				 out.println("alert('Please login first. ')");
			}else{
			//	System.out.println("top message:"+request.getParameter("errorMsg"));
			}
			%>
	 
	//表单未填写完全禁止提交
	function SumbitJudge() {
	// 	alert("sada");
	var input=document.getElementById("serchInput").value;
	if (!input) {
		alert("please input something！");
		return false;
	}
	return true;
}
</script>
</head>
	<nav id="top">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<!--select class="language">
						<option value="English" selected>English</option>
						<option value="France">France</option>
						<option value="Germany">Germany</option>
					</select>
					<select class="currency">
						<option value="USD" selected>USD</option>
						<option value="EUR">EUR</option>
						<option value="DDD">DDD</option>
					</select-->
				</div>
				<div class="col-xs-6">
					<ul class="top-link">
					<%
						if (user == null) {
					%>  
						<li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span> Login </a></li>
						<li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span> Regist</a></li>
						
					<%} else if (user.getAdmin()==util.Content.Admin_NO) {%>
						<li><a href="OrderListUserServlet"><span class="glyphicon glyphicon-user"></span> Welcome:<b>${user.userName}</b></a></li>
						<li><a href="<%=path%>/IndexServlet?login=no"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
					<%}else if (user.getAdmin()==util.Content.Admin_YES)  {%>
						<li><a href="CommoditySearchManageServlet"><span class="glyphicon glyphicon-user"></span> Welcome:<b>${user.userName}</b></a></li>
						<li><a href="<%=path%>/IndexServlet?login=no"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
					<%}%>
					
						<!--联系方式li><a href="contact.html"><span class="glyphicon glyphicon-envelope"></span> Contact</a></li-->
					</ul>
				</div>
		</div>
	</nav>
	<!--Header-->
	<header class="container">
		<div class="row">
			<div class="col-md-4">
				<a href="IndexServlet">
					<div id="logo"><img src="img/logo/2logo.png" /></div>
				</a>
			</div>
			<div class="col-md-4">
				<form class="form-search" action="CommoditiesListServlet">  
					<input placeholder="Search"  type="text" name="serchInput" id ="serchInput" class="input-medium search-query">  
					<button onclick=" return SumbitJudge()" type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button>  
				</form>
			</div>
			<div class="col-md-4">
				<div id="cart"><a class="btn btn-1" href="CartListServlet"><span class="glyphicon glyphicon-shopping-cart"></span>  Cart  List  </a></div>
			</div>
		</div>
	</header>
	<!--Navigation-->
    <nav id="menu" class="navbar">
		<div class="container">
			<div class="navbar-header"><span id="heading" class="visible-xs">Categories</span>
			  <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<%=path%>/index.jsp">Home</a></li>
					<li><a href="<%=path%>/CommoditiesListServlet?category=1">TOY</a></li>
					<li><a href="<%=path%>/CommoditiesListServlet?category=2">KITCHEN STUFF</a>
					<li><a href="<%=path%>/CommoditiesListServlet?category=3">TOOLS</a></li>
					<li><a href="<%=path%>/CommoditiesListServlet?category=4">DECORATION</a></li>
					<li><a href="<%=path%>/CommoditiesListServlet?category=5">CLOTHES</a></li>
					<li><a href="<%=path%>/contact.jsp">CONTACT US</a></li>
					<li><a href="<%=path%>/about.jsp">ABOUT US</a></li>
					<!--li class="dropdown"><a href="<%=path%>/CommodityListServlet.jsp?category=1" class="dropdown-toggle" data-toggle="dropdown">TOY</a>
						<!--div class="dropdown-menu">
							<div class="dropdown-inner">
								<ul class="list-unstyled">
									<li><a href="category.html">Window</a></li>
									<li><a href="category.html">MacBook</a></li>
								</ul>
							</div>
						</div-- >
					</li-->
					
						 
					
				</ul>
			</div>
		</div>
	</nav>