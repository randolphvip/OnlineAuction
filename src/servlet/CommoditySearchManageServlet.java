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
@WebServlet("/CommoditySearchManageServlet")
public class CommoditySearchManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommoditySearchManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user")!=null) {//judge the user 
			request.setAttribute("#COMMODITY",findProductList());
			request.getRequestDispatcher("CommodityList.jsp").forward(request, response);
			java.util.List<Commodity> commodities =(List<Commodity>)request.getAttribute("#COMMODITY");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	

	public List<Commodity>  findProductList(){
		int pageNum=1;//翻页信息
		CommodityDao commodityDao = CommodityDaoFactory.getDaoInstance();
		Commodity commondityPara = new Commodity();
		
		commondityPara.setLimit(10* pageNum);
		commondityPara.setOrderBy("order by id  desc");
		//commodityDaocommondityPara.setCategory(1);
		List<Commodity>  commodits =commodityDao.getCommodityList(commondityPara );
		System.out.println(commodits.size());
	 
	  return commodits ;
	}
	
	
	
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
