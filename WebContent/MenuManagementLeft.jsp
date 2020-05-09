 <div class="left-sidebar-pro">
        <nav id="sidebar" class="">
            <div class="sidebar-header">
                <a href="IndexServlet"><img class="main-logo" src="" alt="" /></a>
                <!--strong><a href="index.html"><img src="img/logo/logosn.png" alt="" /></a></strong-->
            </div>
            <div class="left-custom-menu-adp-wrap comment-scrollbar">
                <nav class="sidebar-nav left-sidebar-menu-pro">
                    <ul class="metismenu" id="menu1">
					<%if (user!=null&&user.getAdmin()==util.Content.Admin_NO){%>
						
					
                        <li>
                            <a class="has-arrow" href="IndexServlet">
								   <span class="educate-icon educate-home icon-wrap"></span>
								   <span class="mini-click-non">My Account</span>
								</a>
                            <ul class="submenu-angle" aria-expanded="true">
                                <li><a title="OrderListUserServlet" href="OrderListUserServlet"><span class="mini-sub-pro">Order List</span></a></li>
                                <li><a title="MyLostServlet" href="CartListServlet"><span class="mini-sub-pro">Cart</span></a></li>
                                <li><a title="profileEdit" href="UserDetail.jsp"><span class="mini-sub-pro">profile</span></a></li>
                            </ul>
                        </li>
						<%}else{%>
						<li>
                            <a class="has-arrow" href="CommoditySearchManageServlet">
							   <span class="educate-icon educate-home icon-wrap"></span>
							   <span class="mini-click-non">Commodity Management</span>
							</a>
                        </li>
						<li>
                            <a class="has-arrow" href="UserSearchManagementServlet">
							   <span class="educate-icon educate-home icon-wrap"></span>
							   <span class="mini-click-non">User Management</span>
							</a>
                        </li>
						<li>
                            <a class="has-arrow" href="OrderListUserServlet">
							   <span class="educate-icon educate-home icon-wrap"></span>
							   <span class="mini-click-non">Order List</span>
							</a>
                        </li>
						<%}%>
						<li>
                    </ul>
                </nav>
            </div>
        </nav>
    </div>