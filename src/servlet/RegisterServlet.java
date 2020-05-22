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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String gender = request.getParameter("gender");

		User user = new User();

		user.setUserName(userName);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setAddress(address);
		user.setMobile(mobile);
		if (gender != null && gender != "")
			user.setGender(Integer.parseInt(gender));

		// SAVE into databse;
		UserDao userdao = DaoFactory.getUserDaoInstance();
		int result = userdao.saveUser(user);

		if (result == 0) {
			response.sendRedirect("IndexServlet");
		} else {
			request.getSession().setAttribute("#MESSAGE", "please change a new username");
			response.sendRedirect("register.jsp?errorMsg=1");

		}

//		System.out.println("RegisterDoPost");
//		registerUser(request, response);
	}

	public void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String password = request.getParameter("password");

		UserDao userdao = DaoFactory.getUserDaoInstance();
		// 注册用户
		int bb = 0;
		// 插入数据库
		bb = userdao.register(name, password);
		if (bb == 0) {
			// 注册成功
//			 System.out.println("yes");
			response.sendRedirect("registerSuccess.jsp");
		} else {
			// System.out.println("no");
			response.sendRedirect("register.jsp?register=error");
		}
	}

}
