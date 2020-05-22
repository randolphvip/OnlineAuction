package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.DaoFactory;
import entity.User;

@WebServlet("/CartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {

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

	 
		CartDao cartDao = DaoFactory.getCartDaoInstance();

		String id = request.getParameter("id");

		cartDao.changeCartState(Integer.parseInt(id), util.Content.CART_STATE_DELETED);

		response.sendRedirect("CartListServlet");

//	 		 

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
