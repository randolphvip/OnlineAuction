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

@WebServlet("/RecoverPasswordServlet")
public class RecoverPasswordServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String  userName= request.getParameter("username");
		String email = request.getParameter("email");
		String mobile= request.getParameter("mobile");
		
		
		UserDao userDao = DaoFactory.getUserDaoInstance();
		User user =userDao.getUserByName(userName);
		if (user!=null) {
			if(user.getEmail().equals(email.trim())){
				request.setAttribute("#USER", user);
				request.getRequestDispatcher("password-recovery2.jsp").forward(request, response);
			}else if(user.getMobile().equals(mobile.trim())){
				request.setAttribute("#USER", user);
				request.getRequestDispatcher("password-recovery2.jsp").forward(request, response);
			}else {
				
				response.sendRedirect("password-recovery.jsp?errorMsg=3");
			}
		}
		
		
		
		
//		request.setAttribute("#PRODUCTLIST", commodits);
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}
	
	 

}
