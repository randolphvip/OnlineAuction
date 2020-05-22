package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class CommodityManageServlet
 */
@WebServlet("/UserSearchManagementServlet")
public class UserSearchManagementServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}

		UserDao userDao = DaoFactory.getUserDaoInstance();
		User userPara = new User();
		// 设置翻页
		String pageNumber = request.getParameter("pageNumber");
		int page = 0;
		if (pageNumber != null && pageNumber != "") {
			page = Integer.parseInt(pageNumber);
			userPara.setLimitBegin(10 * page);
		} else {
			userPara.setLimitBegin(0);
		}

		userPara.setLimit(10 * 1);

		userPara.setOrderBy("order by id  desc");
		List<User> users = userDao.findUserList(userPara);

		request.setAttribute("#USER", users);
		request.setAttribute("#PAGENUMBER", page);
		System.out.println((int) request.getAttribute("#PAGENUMBER"));

		request.getRequestDispatcher("UserList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
