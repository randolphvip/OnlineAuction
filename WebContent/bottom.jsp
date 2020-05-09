<footer>
		<div class="container">
			<div class="wrap-footer">
				<div class="row">
					<div class="col-md-3 col-footer footer-1">
						 
						<p>Thank you very much for using this website. hope you can find your favorite goods </p>
					</div>
					<div class="col-md-3 col-footer footer-2">
						<div class="heading"><h4>Customer Service</h4></div>
						<ul>
							<li><a href="about.jsp">About Us</a></li>
							<li><a href="#" onclick="alert('developing')">Privacy Policy</a></li>
							<li><a href="#"  onclick="alert('developing')">Terms & Conditions</a></li>
							<li><a href="contact.jsp">Contact Us</a></li>
						</ul>
					</div>
					<div class="col-md-3 col-footer footer-3">
						<div class="heading"><h4>My Account</h4></div>
						<ul>
						<%if (user!=null&&user.getAdmin()==util.Content.Admin_NO) {%>
							<li><a href="#">cart</a></li>
							<li><a href="OrderListUserServlet">My orders</a></li>
							<li><a href="UserDetail.jsp">Profile</a></li>
						<%}else if (user!=null&&user.getAdmin()==util.Content.Admin_YES) {
							out.println("<li><a href='CommoditySearchManageServlet'>Admin</a></li>");
						}
						%>
						
						
						
						</ul>
					</div>
					<div class="col-md-3 col-footer footer-4">
						<div class="heading"><h4>Contact Us</h4></div>
						<ul>
							<li><span class="glyphicon glyphicon-home"></span>Corner Cornwall St and, Kings Crescent, Lower Hutt 5010, New Zealand</li>
							<li><span class="glyphicon glyphicon-earphone"></span>+64 4-570 0276</li>
							<li><span class="glyphicon glyphicon-envelope"></span> salvationarmy.org.nz</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="copyright">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						Copyright 2020 &copy; Weltec T7351 project
					</div>
					<div class="col-md-6">
						<div class="pull-right">
							<ul>
								<!--li><img src="images/visa-curved-32px.png" /></li>
								<li><img src="images/paypal-curved-32px.png" /></li>
								<li><img src="images/discover-curved-32px.png" /></li>
								<li><img src="images/maestro-curved-32px.png" /></li-->
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>