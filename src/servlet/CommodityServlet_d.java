package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/CommoditySearchServlet_d")
public class CommodityServlet_d extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityServlet_d() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String category=request.getParameter("category");
		PrintWriter out = response.getWriter();
		
		CommodityDao thisDao = DaoFactory.getCommodityDaoInstance();
		
		List<Commodity> CommodityList = null;
		Commodity commodity =new Commodity();
		if(category!=null && category!="")
		commodity.setCategory(Integer.parseInt(category));
		
		CommodityList = thisDao.getCommodityList(commodity);
		
		 for (Commodity c:CommodityList) {
			 System.out.println(c.getId());
			 
		 }
		
		out.print("----------");
		
		doPost(request, response);
	}

	 
}
