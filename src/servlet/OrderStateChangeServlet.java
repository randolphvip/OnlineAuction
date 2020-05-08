package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommodityDao;
import dao.DaoFactory;
import dao.OrderDao;
import entity.Commodity;
import entity.Order;
import entity.User;

@WebServlet("/OrderStateChangeServlet")
public class OrderStateChangeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}
		String orderID= request.getParameter("orderID");
		String pickUpState= request.getParameter("pickUpState");
		
		
		
		OrderDao orderDao = DaoFactory.getOrderDaoInstance();
		
		 if(orderID!=null&&pickUpState!=null) {
			 orderDao.changeOrderState(Integer.parseInt( orderID), Integer.parseInt (pickUpState));
		 }
		
		response.sendRedirect("OrderListUserServlet");
		
 
		
		


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
