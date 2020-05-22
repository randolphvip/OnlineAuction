package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuctionDao;
import dao.CommodityDao;
import dao.DaoFactory;
import entity.Bid;
import entity.User;
import util.Content;

/**
 * Servlet implementation class AuctionServlet
 */
@WebServlet("/AuctionServlet")
public class AuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// if the session time out , it will jump to he login page.
		User user = (User) request.getSession().getAttribute(Content.USER_SESSION);
		if (user == null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");


			AuctionDao auctionDao = DaoFactory.getAuctionDaoInstance();
			CommodityDao commodityDao = DaoFactory.getCommodityDaoInstance();

			// goods ID
			int commodityID = Integer.parseInt(request.getParameter("ID"));
			// price
			Float price = Float.parseFloat(request.getParameter("bid_price"));

			Bid bid = new Bid();
			bid.setCommodityID(commodityID);
			bid.setUserID(user.getId());
			bid.setUserName(user.getUserName());
			bid.setPrice(price);
			auctionDao.saveBid(bid);// 添加拍卖历史记录

			commodityDao.updateMaxPrice(commodityID, price, user.getId());

			// 添加到購物車。
			CartAddServlet c = new CartAddServlet();
			c.cartAdd(commodityID, user.getId());

			response.sendRedirect("CommondityShowDetailServlet?id=" + commodityID);
 
	}

}
