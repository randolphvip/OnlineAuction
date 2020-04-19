<%@page import="java.sql.Timestamp"%>
<%@page import="impl.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
%>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>Mobile Shop</title>
	
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
		System.out.println("--top---null");
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
						if (session.getAttribute("user") == null) {
					%>  
						<li><a href="<%=path%>/login.jsp"><span class="glyphicon glyphicon-user"></span> login </a></li>
						<li><a href="<%=path%>/register.jsp"><span class="glyphicon glyphicon-user"></span> regist</a></li>
						
					<%} else {%>
					<li><a href="<%=path %>/UserServlet?user_id=<%=((User)session.getAttribute("user")).getId() %>"><span class="glyphicon glyphicon-user"></span> welcome:<b>${user.userName}</b></a></li>
					
					<li><a href="<%=path%>/IndexServlet?login=no"><span class="glyphicon glyphicon-user"></span> logout</a></li>
				 
					 
					 
					<%}%>
						<!--联系方式li><a href="contact.html"><span class="glyphicon glyphicon-envelope"></span> Contact</a></li-->
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<!--Header-->
	<header class="container">
		<div class="row">
			<div class="col-md-4">
				<div id="logo"><img src="images/logo2.png" /></div>
			</div>
			<div class="col-md-4">
				<form class="form-search">  
					<input placeholder="search"  type="text" name="serchInput" id ="serchInput" class="input-medium search-query">  
					<button onclick=" return SumbitJudge()" type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button>  
				</form>
			</div>
			<div class="col-md-4">
				<div id="cart"><a class="btn btn-1" href="cart.html"><span class="glyphicon glyphicon-shopping-cart"></span>watch List : 0 ITEM</a></div>
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
					<li class="dropdown"><a href="<%=path%>/showList.jsp?category1" class="dropdown-toggle" data-toggle="dropdown">PC Computers</a>
						<!--div class="dropdown-menu">
							<div class="dropdown-inner">
								<ul class="list-unstyled">
									<li><a href="category.html">Window</a></li>
									<li><a href="category.html">MacBook</a></li>
								</ul>
							</div>
						</div-->
					</li>
					<li class="dropdown"><a href="<%=path%>/showList.jsp?category2" class="dropdown-toggle" data-toggle="dropdown">Laptops &amp; Notebooks</a>
						<!--div class="dropdown-menu">
							<div class="dropdown-inner">
								<ul class="list-unstyled">
									<li><a href="category.html">Dell</a></li>
									<li><a href="category.html">Asus</a></li>
									<li><a href="category.html">Samsung</a></li>
									<li><a href="category.html">Lenovo</a></li>
									<li><a href="category.html">Acer</a></li>
								</ul>
							</div> 
						</div!-->
					</li>
					<li class="dropdown"><a href="<%=path%>/showList.jsp?category3" class="dropdown-toggle" data-toggle="dropdown">Mobiles &amp; Tablet</a>
						<!--div class="dropdown-menu" style="margin-left: -203.625px;">
							<div class="dropdown-inner">
								<ul class="list-unstyled">
									<li><a href="category.html">Iphone</a></li>
									<li><a href="category.html">Samsung</a></li>
									<li><a href="category.html">Nokia</a></li>
									<li><a href="category.html">Lenovo</a></li>
									<li><a href="category.html">Google</a></li>
								</ul>
								<ul class="list-unstyled">
									<li><a href="category.html">Nexus</a></li>
									<li><a href="category.html">Dell</a></li>
									<li><a href="category.html">Oppo</a></li>
									<li><a href="category.html">Blackberry</a></li>
									<li><a href="category.html">HTC</a></li>
								</ul>
								<ul class="list-unstyled">
									<li><a href="category.html">LG</a></li>
									<li><a href="category.html">Q-Mobiles</a></li>
									<li><a href="category.html">Sony</a></li>
									<li><a href="category.html">Wiko</a></li>
									<li><a href="category.html">T&T</a></li>
								</ul>
							</div>
						</div!-->
					</li>
					<li><a href="<%=path%>/showList.jsp?category4">Software</a></li>
				</ul>
			</div>
		</div>
	</nav>