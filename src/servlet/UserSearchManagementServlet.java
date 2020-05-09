package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class CommodityManageServlet
 */
@WebServlet("/UserSearchManagementServlet")
public class UserSearchManagementServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchManagementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		if (request.getSession().getAttribute("user")!=null) {//judge the user 
			//page
	//	getPage
			
			
			UserDao userDao = DaoFactory.getUserDaoInstance();
			User userPara = new User();
			userPara.setLimit(10* 1);
			userPara.setOrderBy("order by id  desc");
			List<User>  users =userDao.findUserList(userPara );
			
			
			request.setAttribute("#USER",users);
			request.setAttribute("#PAGE",page);
			request.getRequestDispatcher("UserList.jsp").forward(request, response);
		
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	

 
	
	
	
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
