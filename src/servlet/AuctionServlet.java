package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuctionDao;
import dao.AuctionDaoFactory;
import dao.CommodityDao;
import dao.CommodityDaoFactory;
import entity.Bid;
import entity.User;
import util.Content;


/**
 * Servlet implementation class AuctionServlet
 */
@WebServlet("/AuctionServlet")
public class AuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("in.......AuctionServlet.....");
		
		if(request.getSession().getAttribute(Content.USER_SESSION)==null) {
			request.setAttribute(Content.MESSAGE, "PLESE LOGIN");
		//	response.sendRedirect("login.jsp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			User user =(User)request.getSession().getAttribute(Content.USER_SESSION);
			AuctionDao auctionDao=AuctionDaoFactory.getDaoInstance();
			CommodityDao commodityDao= CommodityDaoFactory.getDaoInstance();
			
			//商品ID
			int commodityID= Integer.parseInt(request.getParameter("ID"));
			//价格
			Float price = Float.parseFloat(request.getParameter("bid_price"));
			
			
			Bid bid = new Bid();
			bid.setCommodityID(commodityID);
			bid.setUserID(user.getId());
			bid.setUserName(user.getUserName());
			bid.setPrice(price);
			auctionDao.saveBid(bid);//添加拍卖历史记录
			System.out.println("---出价成功");
			
			commodityDao.updateMaxPrice(commodityID, price, user.getId());
			response.sendRedirect("CommondityShowDetailServlet?id="+commodityID);
			
			
			
		}
//		
//		
//		
//		
//		int id=Integer.valueOf(request.getParameter("id"));
//    
    
    
    
    
    
    
    
    
    
    
    
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
  
}
