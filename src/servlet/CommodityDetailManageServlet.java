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
import entity.User;

/**
 * Servlet implementation class CommodityManageServlet
 */
@WebServlet("/CommodityDetailManageServlet")
public class CommodityDetailManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityDetailManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}
		
		CommodityDao commodityDao = DaoFactory.getCommodityDaoInstance();
		String commodityId= request.getParameter("commodityId");
		
		Commodity commodity =commodityDao.getCommodityByID(Integer.parseInt(commodityId));
		request.setAttribute("#COMMODITY", commodity);
		request.getRequestDispatcher("CommodityEdit.jsp").forward(request, response);
		
		 
	}

	
 
	
	
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
