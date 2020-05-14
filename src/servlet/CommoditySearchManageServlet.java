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
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	

	public List<Commodity>  findProductList(){
		int pageNum=1;//翻页信息
		CommodityDao commodityDao = DaoFactory.getCommodityDaoInstance();
		Commodity commondityPara = new Commodity();
		
		commondityPara.setLimit(20);
		commondityPara.setOrderBy("order by id  desc");
		//commodityDaocommondityPara.setCategory(1);
		List<Commodity>  commodits =commodityDao.getCommodityList(commondityPara );
		System.out.println(commodits.size());
	 
	  return commodits ;
	}
	
	
	
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
