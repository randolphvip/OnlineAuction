package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommodityDao;
import dao.DaoFactory;
import dao.OrderDao;
import entity.Cart;
import entity.Commodity;
import entity.Order;
import entity.User;

@WebServlet("/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}
		String orderId= request.getParameter("OrderID");
		OrderDao orderDao = DaoFactory.getOrderDaoInstance();
		CommodityDao commodityDao = DaoFactory.getCommodityDaoInstance();
		
		Order orderPara= new Order();
		orderPara.setId(Integer.parseInt(orderId));
		
		Order order =orderDao.getOrderById(Integer.parseInt(orderId));
		
		Commodity commodity=commodityDao.getCommodityByID(order.getCommodityId());
		order.setCommodity(commodity);
		
		request.setAttribute("#ORDER", order);
		
		request.getRequestDispatcher("OrderDetail.jsp").forward(request, response);
		
 
		
		


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

	
	public static void main(String []age) {
		Cart cart=new Cart();
		System.out.println(cart.getCommodityId());
	}
}
