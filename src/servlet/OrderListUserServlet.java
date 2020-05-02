package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.OrderDao;
import entity.Order;
import entity.User;

@WebServlet("/OrderListUserServlet")
public class OrderListUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect("IndexServlet?errorMsg=5");
			return;
		}
		
		OrderDao orderDao = DaoFactory.getOrderDaoInstance();
		Order orderPara= new Order();
		orderPara.setWinnerId(user.getId());
		List<Order> list=orderDao.getOrderList(orderPara);
		
	
//		if (result) {
//			 
//			response.sendRedirect("IndexServlet");
//		}else {
//			response.sendRedirect("password-recovery.jsp?errorMsg=4");
//		}
//	 		 
		
		


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
