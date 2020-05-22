package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommodityDao;
import dao.DaoFactory;
import entity.Commodity;

/**
 * Servlet implementation class CommodityServlet
 */
@WebServlet("/CommondityShowDetailServlet")
public class CommondityShowDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommodityDao commodityDao = DaoFactory.getCommodityDaoInstance();

		String id = request.getParameter("id");
//		PrintWriter out = response.getWriter();
		Commodity commodityPara = new Commodity();
		if (id != null && id != "") {
			commodityPara.setId(Integer.parseInt(id));
		}
	
		Commodity commodity = commodityDao.getCommodity(commodityPara);
		request.setAttribute("#COMMODITY", commodity);
		request.getRequestDispatcher("product.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	}

}
