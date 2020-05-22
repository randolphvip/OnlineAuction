package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.OrderDao;
import entity.Order;
import entity.User;
import util.Utils;

@WebServlet("/MakeAppointmentServlet")
public class MakeAppointmentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}
		String pickUpDate = request.getParameter("pickUpDate");
		System.out.println("pickUpDate:" + pickUpDate);

		pickUpDate = pickUpDate.replace("T", " ");
		String message = request.getParameter("message");
		String orderID = request.getParameter("orderID");

		OrderDao orderDao = DaoFactory.getOrderDaoInstance();
		Order orderPara = new Order();
		orderPara.setPickUpDate(Utils.strToSqlDate(pickUpDate, "yyyy-MM-dd HH:mm"));
		orderPara.setMessage(message);
		orderPara.setId(Integer.parseInt(orderID));

		orderDao.makeAppointment(orderPara);

		response.sendRedirect("OrderListUserServlet");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
