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
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}
		
		OrderDao orderDao = DaoFactory.getOrderDaoInstance();
		Order orderPara= new Order();
		orderPara.setWinnerId(user.getId());
		List<Order> list=orderDao.getOrderList(orderPara);
		
		request.setAttribute("#ORDER", list);
		System.out.println(list.size());
		request.getRequestDispatcher("OrderList.jsp").forward(request, response);
		
	 

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}