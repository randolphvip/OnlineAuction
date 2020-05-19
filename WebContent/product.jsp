<!DOCTYPE html>
<html lang="en"> 

<body>
	<%@ include file="top.jsp"%>
	<!--//////////////////////////////////////////////////-->
	<!--///////////////////Product Page///////////////////-->
	<!--//////////////////////////////////////////////////-->
	<% Commodity commodity= (Commodity)request.getAttribute("#COMMODITY");
	String closeDate="";
	if(commodity.getCloseDate()!=null){
		 closeDate= util.Utils.dateToStr2(commodity.getCloseDate());
	}
	%>
	
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="IndexServlet">Home</a></li>
						
						<li><a href="CommondityShowDetailServlet?id=<%=commodity.getId()%>"><%=commodity.getTitle()%></a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div id="main-content" class="col-md-8">
					<div class="product">
						<div class="col-md-6">
							<div class="image">
								<img src="<%=commodity.getPicture()%>" />
								<div class="image-more">
									 <!--ul class="row">
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive" src="<%=commodity.getPicture()%>"></a>
										</li>
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive" src="<%=commodity.getPicture()%>"></a>
										</li>
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive" src="<%=commodity.getPicture()%>"></a>
										</li>
									</ul-->
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="caption">
								<div class="name"><h3><%=commodity.getTitle()%></h3></div>
								<div class="info">
									<ul>
										<li>ID: <%=commodity.getId()%></li>
									</ul>
								</div>
								<div class="price">Current Bid :<%=commodity.getMaxPrice()%></div>
								<div class="price">Initial price :<span><%=commodity.getPrice()%></span></div>
								<div>closes : <span><%=commodity.getCloseDate()%></span></div>
								<div>
									<b>
										<div id="CountMsg" class="HotDate">
											<span id="closeTime"> </span>
											 
										</div>
									</b>
								</div>
								<div >publish date : <span><%=commodity.getPublishDate()%></span></div>
								
								<form name="mainForm" id="mainForm" method="post" action="AuctionServlet">
									<div class="well">
										<label>Your Bid: </label> 
										<input  type="hidden" name="ID" id ="ID" value="<%=commodity.getId()%>">
										<input class="form-inline quantity" id ="bid_price" name="bid_price" type="number" step="0.01"  value="<%=commodity.getMaxPrice()+1%>">
									
										<input class="btn btn-2" onclick=" return check();" type="submit" id="bidSubmit" name="bidSubmit" value="Submit">
									</div>
								</form>
								<!--div class="share well">
									<strong style="margin-right: 13px;">Share :</strong>
									<a href="#" class="share-btn" target="_blank">
										<i class="fa fa-twitter"></i>
									</a>
									<a href="#" class="share-btn" target="_blank">
										<i class="fa fa-facebook"></i>
									</a>
									<a href="#" class="share-btn" target="_blank">
										<i class="fa fa-linkedin"></i>
									</a>
								</div-->
							</div>
						</div>
						<div class="clear"></div>
					</div>	
					<div class="product-desc">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#description">Description</a></li>
							<!--li><a href="#review">Questions & Answers.</a></li-->
						</ul>
						<div class="tab-content">
							<div id="description" class="tab-pane fade in active">
								<h4><%=commodity.getTitle()%></h4>
								<p><%=commodity.getIntroduce()%></p>
							</div>
							<div id="review" class="tab-pane fade">
							  <div class="review-text">
								<p></p>
							  </div>
							  <div class="review-form">
								<h4>Write your question</h4>
								<form name="form1" id="ff" method="post" action="review.php">
									
									<label>
									<span>Your message here:</span>
									<textarea name="message" id="message"></textarea>
									</label>
									<div class="text-right">
										<input class="btn btn-default" type="reset" name="reset" value="Reset">
										<input class="btn btn-default" type="submit" name="Submit" value="Submit">
									</div>
								</form>
							  </div>
							</div>
						</div>
					</div>
					<!--div class="product-related">
						<div class="heading"><h2>RELATED PRODUCTS</h2></div>
						<div class="products">
							<div class="col-lg-4 col-md-4 col-xs-12">
								<div class="product">
									<div class="image"><a href="product.html"><img src="images/iphone.png" /></a></div>
									<div class="buttons">
										<a class="btn cart" href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>
										<a class="btn wishlist" href="#"><span class="glyphicon glyphicon-heart"></span></a>
										<a class="btn compare" href="#"><span class="glyphicon glyphicon-transfer"></span></a>
									</div>
									<div class="caption">
										<div class="name"><h3><a href="product.html">Aliquam erat volutpat</a></h3></div>
										<div class="price">$122<span>$98</span></div>
										<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
									</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-4 col-xs-12">
								<div class="product">
									<div class="image"><a href="product.html"><img src="images/galaxy-s4.jpg" /></a></div>
									<div class="buttons">
										<a class="btn cart" href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>
										<a class="btn wishlist" href="#"><span class="glyphicon glyphicon-heart"></span></a>
										<a class="btn compare" href="#"><span class="glyphicon glyphicon-transfer"></span></a>
									</div>
									<div class="caption">
										<div class="name"><h3><a href="product.html">Aliquam erat volutpat</a></h3></div>
										<div class="price">$122<span>$98</span></div>
										<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span></div>
									</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-4 col-xs-12">
								<div class="product">
									<div class="image"><a href="product.html"><img src="images/galaxy-note.jpg" /></a></div>
									<div class="buttons">
										<a class="btn cart" href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>
										<a class="btn wishlist" href="#"><span class="glyphicon glyphicon-heart"></span></a>
										<a class="btn compare" href="#"><span class="glyphicon glyphicon-transfer"></span></a>
									</div>
									<div class="caption">
										<div class="name"><h3><a href="product.html">Aliquam erat volutpat</a></div>
										<div class="price">$122<span>$98</span></div>
										<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span></div>
									</div>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div-->
				</div>
				<div id="sidebar" class="col-md-4">
					<div class="widget wid-categories">
						<div class="heading"><h4>BID  HISTORY </h4></div>
						<div class="content">
							<ul>
							<%List<Bid> bids = commodity.getBids();
								for (Bid bid:bids){
									
									out.println("<li></li><b>$"+bid.getPrice()+"</b>  &nbsp;&nbsp; "+bid.getUserName()+ "<div style='float:right'>"+ new java.text.SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(bid.getDate()) +"</div>");
								}
							%>
							</ul>
						</div>
					</div>
					<!--div class="widget wid-type">
						<div class="heading"><h4>TYPE</h4></div>
						<div class="content">
							<select>
								<option value="EL" selected>Electronics</option>
								<option value="MT">Mice and Trackballs</option>
								<option value="WC">Web Cameras</option>
								<option value="TA">Tablates</option>
								<option value="AP">Audio Parts</option>
							</select>
						</div>
					</div-->
					<!--div class="widget wid-discouts">
						<div class="heading"><h4>DISCOUNTS</h4></div>
						<div class="content">
							<label class="checkbox"><input type="checkbox" name="discount" checked="">Upto - 10% (20)</label>
							<label class="checkbox"><input type="checkbox" name="discount">40% - 50% (5)</label>
							<label class="checkbox"><input type="checkbox" name="discount">30% - 20% (7)</label>
							<label class="checkbox"><input type="checkbox" name="discount">10% - 5% (2)</label>
							<label class="checkbox"><input type="checkbox" name="discount">Other(50)</label>
						</div>
					</div-->
					<!--div class="widget wid-brand">
						<div class="heading"><h4>BRAND</h4></div>
						<div class="content">
							<label class="checkbox"><input type="checkbox" name="brand">Nokia</label>
							<label class="checkbox"><input type="checkbox" name="brand">Samsung</label>
							<label class="checkbox"><input type="checkbox" name="brand">Iphone</label>
							<label class="checkbox"><input type="checkbox" name="brand">HTC</label>
							<label class="checkbox"><input type="checkbox" name="brand">Oppo</label>
							<label class="checkbox"><input type="checkbox" name="brand">Kings</label>
							<label class="checkbox"><input type="checkbox" name="brand">Zumba</label>	
						</div>
					</div-->
					<!--div class="widget wid-product">
						<div class="heading"><h4>LATEST</h4></div>
						<div class="content">
							<div class="product">
								<a href="#"><img src="images/galaxy-note.jpg" /></a>
								<div class="wrapper">
									<h5><a href="#">Samsung Galaxy Tab</a></h5>
									<div class="price">$122</div>
									<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
								</div>
							</div>
							<div class="product">
								<a href="#"><img src="images/galaxy-s4.jpg" /></a>
								<div class="wrapper">
									<h5><a href="#">Samsung Galaxy Tab</a></h5>
									<div class="price">$122</div>
									<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
								</div>
							</div>
							<div class="product">
								<a href="#"><img src="images/Z1.png" /></a>
								<div class="wrapper">
									<h5><a href="#">Samsung Galaxy Tab</a></h5>
									<div class="price">$122</div>
									<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
								</div>
							</div>
						</div>
					</div-->
				</div>
			</div>
		</div>
	</div>	
	
	<!-- IMG-thumb -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">         
          <div class="modal-body">                
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
	 <%@ include file="bottom.jsp"%>
	 <script type="text/javascript">
        function generateOrders(){
            $.ajax({
                type: "POST",                            //传数据的方式
                url: "OrderCreateServlet",                             //servlet地址
 
                data: $('#mainForm').serialize(),            //传的数据  form表单 里面的数据
                success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
                  // alert(result);
				 //  $("#results").val(result);           //找到输入框 并且将result的值 传进去
                }
            });
        }
  
    </script>
	 <script type="text/javascript">
		var intervalObj=null
		function getRTime(){
			var EndTime = new Date('<%=closeDate%>'); //截止时间
			var NowTime = new Date();
			var t = EndTime.getTime() - NowTime.getTime();
			if (t<0){
				document.getElementById("closeTime").innerHTML ="CLOSED";
				clearInterval(intervalObj);				// do not need to change close time
				generateOrders();
			 
				$("#bidSubmit").attr("disabled","true");//disable the bid button
		
 
				return;
			}
			if(intervalObj==null){
				intervalObj =setInterval(getRTime,1000);
			}

			//累减
			// var d=Math.floor(t/1000/60/60/24);
			// t-=d*(1000*60*60*24);
			// var h=Math.floor(t/1000/60/60);
			// t-=h*60*60*1000;
			// var m=Math.floor(t/1000/60);
			// t-=m*60*1000;
			// var s=Math.floor(t/1000);

			//累加
			var d=Math.floor(t/1000/60/60/24);
			var h=Math.floor(t/1000/60/60%24);
			var m=Math.floor(t/1000/60%60);
			var s=Math.floor(t/1000%60);


			document.getElementById("closeTime").innerHTML = d + "Days"+h + "Hours"+m + "Minutes"+s + "Seconds";
			//document.getElementById("t_h").innerHTML = h + "Hours";
			//document.getElementById("t_m").innerHTML = m + "Minutes";
			//document.getElementById("t_s").innerHTML = s + "Seconds";
			
		}
		getRTime();
		//var intervalObj =setInterval(getRTime,1000);
	</script>
	
	<script>
	$(document).ready(function(){
		$(".nav-tabs a").click(function(){
			$(this).tab('show');
		});
		$('.nav-tabs a').on('shown.bs.tab', function(event){
			var x = $(event.target).text();         // active tab
			var y = $(event.relatedTarget).text();  // previous tab
			$(".act span").text(x);
			$(".prev span").text(y);
		});
	});
	</script>
		<script language ="javaScript">
		function check(){
			var minPrice =<%=commodity.getMaxPrice()%>;
			var currentPrice =mainForm.bid_price.value;
			if(minPrice<currentPrice){
				return true;
			}else{
				alert("bid price must be more then current price");
				return false;
			}
			
		}
	</script>

	

</body>
</html>
