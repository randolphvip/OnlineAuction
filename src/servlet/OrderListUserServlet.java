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
		User user = (User) request.getSession().getAttribute("user");
		OrderDao orderDao = DaoFactory.getOrderDaoInstance();
		Order orderPara = new Order();
		if (user == null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}

		if (user.getAdmin() == util.Content.Admin_NO) {
			orderPara.setWinnerId(user.getId());
		}

		// 设置翻页
		String pageNumber = request.getParameter("pageNumber");
		int page = 0;
		if (pageNumber != null && pageNumber != "") {
			page = Integer.parseInt(pageNumber);
			orderPara.setLimitBegin(10 * page);
		} else {
			orderPara.setLimitBegin(0);
		}

		orderPara.setOrderBy(" Order By C.CLOSE_DATE DESC");
		List<Order> list = orderDao.getOrderList(orderPara);
		request.setAttribute("#ORDER", list);
		request.setAttribute("#PAGENUMBER", page);
		request.getRequestDispatcher("OrderList.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
