package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.AbstractDocument.Content;

import dao.CommodityDao;
import dao.CommodityDaoFactory;
import dao.UserDao;
import dao.UserDaoFactory;
import entity.Commodity;
import entity.User;

@WebServlet("/CommoditiesListServlet")
public class CommoditiesListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String  category= request.getParameter("category");
		String keyWrod = request.getParameter("serchInput");
		
		CommodityDao commodityDao = CommodityDaoFactory.getDaoInstance();
		Commodity commondityPara = new Commodity();
		commondityPara.setLimit(12);
		if(category!=null) {
			commondityPara.setCategory(Integer.parseInt(category));
		}
		commondityPara.setTitle(keyWrod);
		
		commondityPara.setState(util.Content.COMMODITY_STATE_SELLING);
		commondityPara.setOrderBy("order by close_date desc");
		
		List<Commodity>  commodits =commodityDao.getCommodityList(commondityPara );
		System.out.println(commodits.size());
		request.setAttribute("#PRODUCTLIST", commodits);
		request.getRequestDispatcher("CommonditiesList_F.jsp").forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}
	
	 

}
