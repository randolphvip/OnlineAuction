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
@WebServlet("/UserSearchManagementServlet")
public class UserSearchManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchManagementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user")!=null) {//judge the user 
			request.setAttribute("#USER",findUserList());
			request.getRequestDispatcher("UserList.jsp").forward(request, response);
		
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	

	public List<User>  findUserList(){
		int pageNum=1;//翻页信息
		
		UserDao userDao = UserDaoFactory.getDaoInstance();
		
		User userPara = new User();
		
		userPara.setLimit(10* pageNum);
		userPara.setOrderBy("order by id  desc");
		
	 
		
		List<User>  users =userDao.findUserList(userPara );
		
		System.out.println(users.size());
	 
	  return users ;
	}
	
	
	
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
