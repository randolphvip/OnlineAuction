package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommodityDao;
import dao.DaoFactory;
import entity.User;

/**
 * Servlet implementation class CommodityManageServlet
 */
@WebServlet("/CommodityDeleteServlet")
public class CommodityDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		CommodityDao commodityDao = DaoFactory.getCommodityDaoInstance();

		String id = request.getParameter("id");
		commodityDao.updateState(Integer.parseInt(id), 3);

		request.getRequestDispatcher("CommoditySearchManageServlet").forward(request, response);

	}

}
