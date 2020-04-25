package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommodityDao;
import dao.CommodityDaoFactory;
import dao.UserDao;
import dao.UserDaoFactory;
import entity.Commodity;
import entity.User;

/**
 * Servlet implementation class CommodityManageServlet
 */
@WebServlet("/CommodityDeleteServlet")
public class CommodityDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public CommodityDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user")!=null) {//judge the user 
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			CommodityDao commodityDao = CommodityDaoFactory.getDaoInstance();
			
			String id=request.getParameter("id");
			commodityDao.updateState(Integer.parseInt(id),3);
			
			
			
			request.getRequestDispatcher("CommoditySearchManageServlet").forward(request, response);
			
			java.util.List<Commodity> commodities =(List<Commodity>)request.getAttribute("#COMMODITY");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	

	 
}
