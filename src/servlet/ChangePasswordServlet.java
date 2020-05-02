package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.UserDao;
import entity.Commodity;
import entity.User;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("id");
		String password = request.getParameter("password");
		UserDao userDao = DaoFactory.getUserDaoInstance();
		boolean result = userDao.changeUserPassword(Integer.parseInt(userID), password);
		if (result) {
			User user = userDao.getById(Integer.parseInt(userID));
			request.getSession().setAttribute("user", user);
			request.setAttribute("#MESSAGE", "Password has changed successfully ");
//			request.getRequestDispatcher("IndexServlet").forward(request, response);
			response.sendRedirect("IndexServlet");
		}else {
			response.sendRedirect("password-recovery.jsp?errorMsg=4");
		}
//	 		 
		
		


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
