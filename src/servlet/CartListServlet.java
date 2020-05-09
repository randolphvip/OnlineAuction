package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.DaoFactory;
import entity.Cart;
import entity.User;

@WebServlet("/CartListServlet")
public class CartListServlet extends HttpServlet {

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
		
		CartDao cartDao = DaoFactory.getCartDaoInstance();
		Cart cart = new Cart();
		cart.setUserId(user.getId());
	
		List<Cart> list=cartDao.getCartList(cart);
		
		request.setAttribute("#CART", list);
		
		System.out.println(list.size());
		request.getRequestDispatcher("CartList.jsp").forward(request, response);
		
	 
	 

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
