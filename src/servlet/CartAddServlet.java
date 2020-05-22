package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.DaoFactory;
import entity.Cart;
import entity.User;

@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// if the session time out , it will jump to he login page.
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		boolean result = false;
		String commodityID = request.getParameter("commodityId");

		result = cartAdd(Integer.parseInt(commodityID), user.getId());

		if (result) {
			out.println("Commodity has already added to the cart.");
		} else {
			out.println("The commodity is already in the cart.");
		}

	}

	public boolean cartAdd(int commodityID, int userID) {
		CartDao cartDao = DaoFactory.getCartDaoInstance();
		System.out.println("commodityID:" + commodityID);

		Cart cart = new Cart();
		cart.setCommodityId(commodityID);
		cart.setUserId(userID);
		cart.setCartState(util.Content.CART_STATE_ACTIVE);
		boolean result = false;

		Cart cart1 = cartDao.getCart(cart);
		if (cart1 == null) {
			result = cartDao.cartAdd(cart);
		}
		return result;

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
