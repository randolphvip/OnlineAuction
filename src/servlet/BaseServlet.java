package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BaseBean;

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5468748781330210222L;
	
 
	
	public  BaseBean page = new BaseBean();
	 
		public void getPage(HttpServletRequest request, HttpServletResponse response) {
			  
	}
 

}
