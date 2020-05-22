package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/UserChangeStateServlet")
public class UserChangeStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}
		UserDao userDao = DaoFactory.getUserDaoInstance();

		String userID = request.getParameter("id");
		String state = request.getParameter("state");
		userDao.updateState(Integer.parseInt(userID), Integer.parseInt(state));

		request.getRequestDispatcher("UserSearchManagementServlet").forward(request, response);
	}

}
