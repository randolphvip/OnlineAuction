package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.BookDaoFactory;
import dao.CommodityDao;
import dao.CommodityDaoFactory;
import dao.StampDao;
import dao.StampDaoFactory;
import dao.WatchDao;
import dao.WatchDaoFactory;
import dao.WineDao;
import dao.WineDaoFactory;
import entity.Book;
import entity.Commodity;
import entity.Stamp;
import entity.Watch;
import entity.Wine;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class CommodityServlet
 */
@WebServlet("/CommondityShowDetailServlet")
public class CommondityShowDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		CommodityDao commodityDao = CommodityDaoFactory.getDaoInstance();
		
		String id=request.getParameter("id");
//		PrintWriter out = response.getWriter();
		Commodity commodityP=new Commodity();
		if(id!=null&& id !="") {
			commodityP.setId( Integer.parseInt(id));
		}
		
		
		Commodity commodity= commodityDao.getCommodity(commodityP);
	 
		
		 
	 
		 
		request.setAttribute("#COMMODITY", commodity);
		request.getRequestDispatcher("product.jsp").forward(request, response);
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	}
	 
}