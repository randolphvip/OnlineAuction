package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommodityDao;
import dao.DaoFactory;
import entity.Commodity;
import entity.User;

/**
 * Servlet implementation class CommodityManageServlet
 */
@WebServlet("/CommoditySearchManageServlet")
public class CommoditySearchManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}

		CommodityDao commodityDao = DaoFactory.getCommodityDaoInstance();
		Commodity commondityPara = new Commodity();
		// 设置翻页
		String pageNumber = request.getParameter("pageNumber");
		int page = 0;
		if (pageNumber != null && pageNumber != "") {
			page = Integer.parseInt(pageNumber);
			commondityPara.setLimitBegin(10 * page);
		} else {
			commondityPara.setLimitBegin(0);
		}

		commondityPara.setOrderBy("order by id  desc");

		List<Commodity> commodits = commodityDao.getCommodityList(commondityPara);
		System.out.println(commodits.size());

		request.setAttribute("#PAGENUMBER", page);
		request.setAttribute("#COMMODITY", commodits);
		request.getRequestDispatcher("CommodityList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
 
}
