

<!DOCTYPE html>
<html lang="en">


<body>
	<!--Top--> 
	<%@ include file="top.jsp"%>
	<!--//////////////////////////////////////////////////-->
	<!--///////////////////HomePage///////////////////////-->
	<!--//////////////////////////////////////////////////-->
    <div class="copyrights"></div>
	<div id="page-content" class="home-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<!-- Carousel -->
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators hidden-xs">
							<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>
						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="images/ad1.png" alt="First slide"><!-----首页广告翻滚，准备替换为教会的信息。------->
								<!-- Static Header -->
								<div class="header-text hidden-xs">
									<div class="col-md-12 text-center">
									</div>
								</div><!-- /header-text -->
							</div>
							<div class="item">
								<img src="images/ad2.jpg" alt="Second slide"><!-----首页广告翻滚，准备替换为教会的信息。------->
								<!-- Static Header -->
								<div class="header-text hidden-xs">
									<div class="col-md-12 text-center">
									</div>
								</div><!-- /header-text -->
							</div>
							<div class="item">
								<img src="images/ad3.jpg" alt="Third slide"><!-----首页广告翻滚，准备替换为教会的信息。------->
								<!-- Static Header -->
								<div class="header-text hidden-xs">
									<div class="col-md-12 text-center">
									</div>
								</div><!-- /header-text -->
							</div>
						</div>
						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left"></span>
						</a>
						<a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div><!-- /carousel -->
				</div>
			</div>
			<!--div class="row">
				<div class="banner">
					<div class="col-sm-4">
						<img src="images/sub-banner1.png" />
					</div>
					<div class="col-sm-4">
						<img src="images/sub-banner2.png" />
					</div>
					<div class="col-sm-4">
						<img src="images/sub-banner3.png" />
					</div>
				</div>
			</div-->
			<div class="row">
				<div class="col-lg-12">
					<div class="heading"><h2>Closing soon</h2></div>
				 
					<% java.util.List<Commodity> productList = (List)request.getAttribute("#PRODUCT");
						for(int i=0;i<productList.size();i++){
							Commodity commodity =productList.get(i);
							if(i%4==0){
								out.println("<div class='products'>");
							}
							%>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="product">
								<div class="image"><a href="CommondityShowDetailServlet?id=<%=commodity.getId()%>"><img style="width:205px;height:260px" src="<%=commodity.getPicture()%>" /></a></div>
								<div class="buttons">
									<%if(user!=null){%>
									<a class="btn cart" href="#" onclick="addToCart('<%=commodity.getId()%>')">
										<span class="glyphicon glyphicon-shopping-cart"></span>
									</a>
									<%}%>
									<!--a class="btn wishlist" href="#"><span class="glyphicon glyphicon-heart"></span></a-->
									<a class="btn compare" href="CommondityShowDetailServlet?id=<%=commodity.getId()%>">Detail</a>
								</div>
								<div class="caption">
									<div class="name"><h3><a href="product.html"><%=commodity.getTitle()%></a></h3></div>
									<div class="price">Current price:<%=commodity.getMaxPrice()%></div>
									<div class="rating">Closes:<%=util.Utils.dateToStr(commodity.getCloseDate())%></div>
								</div>
							</div>
						</div>
						
						<%
						if(i%4==3){
								out.println("</div>");
							}
							
						}%>
				
					 
					
				</div>
			</div>
		
		</div>
	</div>
	<%@ include file="bottom.jsp"%>
	<script type="text/javascript">
        function addToCart( commodityId){
		
            $.ajax({
                type: "POST",                            //传数据的方式
                url: "CartAddServlet?commodityId="+commodityId,                             //servlet地址
 
                data: $('#mainForm').serialize(),            //传的数据  form表单 里面的数据
                success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
                   alert(result);
				 //  $("#results").val(result);           //找到输入框 并且将result的值 传进去
                }
            });
        }
  
    </script>
</body>
</html>
 