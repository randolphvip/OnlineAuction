package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/UserManageServlet")
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		int userId = Integer.parseInt(request.getParameter("userId"));
////		System.out.println("UserManageServletDoGet");
////		System.out.println("userId:" + userId);
//		chageAdmin(request, response);
//		// 跳转到用户管理的页面,显示所有的用户
//		UserDao thisdao = UserDaoFactory.getDaoInstance();
//		List<User> users = new ArrayList<User>();
//		users = thisdao.getAll();
//		if (users != null) {
//			// 查询成功
//			request.setAttribute("users", users);
//			request.getRequestDispatcher("admin/userManage.jsp").forward(request, response);
//		} else {
//			// 查询失败
//		}
//	}

	// 进行权限更改的方法
//	private void chageAdmin(HttpServletRequest request, HttpServletResponse response) {
//		//什么都不做
//		if (request.getParameter("changeAdmin")==null) {
//			return;
//		}
//		// 晋升管理员的操作
//		if (request.getParameter("changeAdmin").equals("ok")) {
//			UserDao thisdao =UserDaoFactory.getDaoInstance();
//			if (thisdao.changeAdmin(Integer.parseInt(request.getParameter("userId")))) {
//				// 更新成功
//				System.out.println("更新用户权限成功");
//			} else {
//				// 更新失败
//				System.out.println("更新用户权限失败");
//			}
//		}
//		// 变为普通用户的操作
//		if (request.getParameter("changeAdmin").equals("no")) {
//			UserDao thisdao = UserDaoFactory.getDaoInstance();
//			if (thisdao.changeOrdinary(Integer.parseInt(request.getParameter("userId")))) {
//				// 更新成功
//				System.out.println("更新用户权限成功");
//			} else {
//				// 更新失败
//				System.out.println("更新用户权限失败");
//			}
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
