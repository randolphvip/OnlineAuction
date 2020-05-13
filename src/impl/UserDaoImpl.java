package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import entity.User;
import util.Content;
import util.DBCPUtil;

public class UserDaoImpl implements UserDao {
	
	private Connection connection = null; // 定义连接的对象
	private PreparedStatement ps = null; // 定义预准备的对象

	
	
	/**
	 * author Cong Shang
	 * Date:2020-04-26
	 */
	@Override
	public List<User> findUserList(User user) {
		
		List<User> listAll = new ArrayList<User>() ;   
		try {
			String sql = "select * from t_user";
			String where =" where 1>0 ";
			
			if (user.getId() > 0) {
				where = where + " and id ='" + user.getId() + "'";
			}
			
			if (user.getUserName() != null & user.getUserName() != "") {
				where = where + " and USERNAME like '%" + user.getUserName() + "%'";
			}
			if (user.getFirstName() != null & user.getFirstName() != "") {
				where = where + " and FIRST_NAME like '%" + user.getFirstName() + "%'";
			}
			if (user.getLastName() != null & user.getLastName() != "") {
				where = where + " and LAST_NAME like '%" + user.getLastName() + "%'";
			}
			if (user.getPassword() != null & user.getPassword() != "") {
				where = where + " and PASSWORD like '%" + user.getPassword() + "%'";
			}
			if (user.getGender() > 0) {
				where = where + " and GENDER ='" + user.getGender() + "'";
			}
			if (user.getMobile() != null & user.getMobile() != "") {
				where = where + " and MOBILE like '%" + user.getMobile() + "%'";
			}
			if (user.getAddress() != null & user.getAddress() != "") {
				where = where + " and ADDRESS like '%" + user.getAddress() + "%'";
			}
			if (user.getEmail() != null & user.getEmail() != "") {
				where = where + " and EMAIL like '%" + user.getEmail() + "%'";
			}
			if (user.getAdmin() > 0) {
				where = where + " and ADMIN ='" + user.getAdmin() + "'";
			}
			if (user.getState() > 0) {
				where = where + " and STATE ='" + user.getState() + "'";
			}
			if (user.getOrderBy() != null & user.getOrderBy() != "") {
				where = where + " " + user.getOrderBy() + "";
			}

			if(user.getLimitBegin()>0&&user.getLimitEnd()>0 ) {
				where = where + " limit  " + user.getLimitBegin()+" , "+ user.getPageSize();
			}
		 
			
			
			connection=DBCPUtil.getConnection();
			Statement statement = connection.createStatement();
			System.out.println("findUserList"+sql);
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// 如果有记录（登陆成功）
				User u = new User();
				// 从数据库获取用户信息，并创建成bean返回
				u.setId(rs.getInt("ID"));
				u.setUserName(rs.getString("USERNAME"));
				u.setFirstName(rs.getString("FIRST_NAME"));
				u.setLastName(rs.getString("LAST_NAME"));
				u.setPassword(rs.getString("PASSWORD"));
				u.setGender(rs.getInt("GENDER"));
				u.setMobile(rs.getString("MOBILE"));
				u.setAddress(rs.getString("ADDRESS"));
				u.setAdmin(rs.getInt("ADMIN"));
				u.setEmail(rs.getString("EMAIL"));
				u.setState(rs.getInt("STATE"));
				listAll.add(u);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
        return listAll;
	}
	
	
	@Override
	public boolean updateState(int userId, int state) {
		try {
			String sql = "update T_USER set state=" + state + " where id=" + userId;
			System.out.println("更改用户狀態 ID=" + sql);
			connection=DBCPUtil.getConnection();
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			connection.close();
			if (updateCount == 1) {
				// 修改成功
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	// 找回密码
		public User getUserByName(String username) {
			User user = null;
			// sql语句
			String querySql = "select * from t_user where username='" + username + "'";
			try {
				connection=DBCPUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(querySql);
				if (rs.next()) {
					// 有该用户，返回User对象;
					user = new User();
					user.setId(rs.getInt("ID"));
					user.setUserName(rs.getString("USERNAME"));
					user.setFirstName(rs.getString("FIRST_NAME"));
					user.setLastName(rs.getString("LAST_NAME"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setGender(rs.getInt("GENDER"));
					user.setMobile(rs.getString("MOBILE"));
					user.setAddress(rs.getString("ADDRESS"));
					user.setAdmin(rs.getInt("ADMIN"));
					user.setEmail(rs.getString("EMAIL"));
					user.setState(rs.getInt("STATE"));
					statement.close();
					rs.close();
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return user;
		}
		
		public boolean changeUserPassword(int user_id, String password) {
			try {
				String sql = "update t_user set password='" + password + "' where id=" + user_id;
				connection=DBCPUtil.getConnection();
				Statement statement = connection.createStatement();
				int updateCount = statement.executeUpdate(sql);
				connection.close();
				if (updateCount == 1) {
				 
					return true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		
		@Override
		public User getUserById(int user_id) {
			User user = null;
			try {
				String sql = "select * from t_user where id=" + user_id;
				connection=DBCPUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					// 如果有记录（登陆成功）
					user = new User();
					user.setId(rs.getInt("ID"));
					user.setUserName(rs.getString("USERNAME"));
					user.setFirstName(rs.getString("FIRST_NAME"));
					user.setLastName(rs.getString("LAST_NAME"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setGender(rs.getInt("GENDER"));
					user.setMobile(rs.getString("MOBILE"));
					user.setAddress(rs.getString("ADDRESS"));
					user.setAdmin(rs.getInt("ADMIN"));
					user.setEmail(rs.getString("EMAIL"));
					user.setState(rs.getInt("STATE"));
				}
				statement.close();
				rs.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		}
		
		
		
		@Override
		public int updateUser(User user) {
			int updateCount=0;
			try {
				
				connection=DBCPUtil.getConnection();
				
				String sql = "UPDATE  T_USER  SET FIRST_NAME =? ,LAST_NAME=?,PASSWORD=?,GENDER=?,MOBILE=?,ADDRESS=?,EMAIL=? WHERE ID=?";
				
				PreparedStatement ps = connection.prepareStatement(sql);
				System.out.println("update user information ,userID="+user.getId());
				
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getLastName());
				ps.setString(3, user.getPassword());
				ps.setInt(4, user.getGender());
				ps.setString(5, user.getMobile());
				ps.setString(6, user.getAddress());
				ps.setString(7, user.getEmail());
				ps.setInt(8, user.getId());
				
				updateCount= ps.executeUpdate();
				System.out.println("更新用戶信息，更新了N條記錄"+updateCount);
				connection.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 
				return updateCount;
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
 

 
	//变为管理员
	public boolean changeAdmin(int id) {
		boolean isOk = false;
		try {
			String sql = "update t_user set admin='"+0+"' where id="+id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			if(updateCount == 1){
				//更新成功
				isOk = true;
			}else{
				//更新失败
				isOk = false;
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOk;
	}
	//变为普通用户
	public boolean changeOrdinary(int id) {
		boolean isOk = false;
		try {
			String sql = "update t_user set admin='"+1+"' where id="+id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			if(updateCount == 1){
				//更新成功
				isOk = true;
			}else{
				//更新失败
				isOk = false;
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOk;
	}
 
	  


	// 登录操作
	public User login(String username, String password) throws Exception {
		User user = null;
		String sql = "select * from t_user where username=? and password=? and STATE=?";
		
		connection=DBCPUtil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setInt(3, Content.USER_STATE_ENABLE);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			// 如果有记录（登陆成功）
			user = new User();
			// 从数据库获取用户信息，并创建成bean返回
			
			user.setId(rs.getInt("ID"));
			user.setUserName(rs.getString("USERNAME"));
			user.setFirstName(rs.getString("FIRST_NAME"));
			user.setLastName(rs.getString("LAST_NAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setGender(rs.getInt("GENDER"));
			user.setAddress(rs.getString("ADDRESS"));
			user.setMobile(rs.getString("MOBILE"));
			user.setEmail(rs.getString("EMAIL"));
			user.setState(rs.getInt("STATE"));
			user.setAdmin(rs.getInt("ADMIN"));
		}
		ps.close();
		connection.close();
		return user;
	}

	// 注册操作
	public int register(String username, String password) {
		int updateCount = 0;
		try {
			// 先查询是否有该用户
			String querySql = "select * from t_user where name='" + username + "'";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(querySql);
			if (result.next()) {
				// 有该用户，返回false;
				connection.close();
				return 1;
			} else {
				// 没有该用户，可以注册
				String sql = "insert into t_user(name,password) values(?,?)";
				ps = connection.prepareStatement(sql);
				// id自动增加
				ps.setString(1, username);
				ps.setString(2, password);
				updateCount = ps.executeUpdate();
				System.out.println(updateCount);
				connection.close();
				// 看看更新的条数
				if (updateCount == 1) {
					return 0;
				} else {
					return 1;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	

	// 根据用户名查找是否有重名
	public int JudgeName(String username) throws SQLException {
		// 先查询是否有该用户
		String querySql = "select * from t_user where name='" + username + "'";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(querySql);
		if (result.next()) {
			// 有该用户，返回false;
			connection.close();
			return 1;
		} else {
			// 沒有该用户
			return 0;
		}
	}
 

	 

	 
	// 添加用户的出售数量
	public boolean addUserAuctionNumber(int user_id, int count) {
		// 参数是修改的用户id和要添加的数量
		try {
			String sql = "update t_user set auction_number=auction_number+" + count + " where id=" + user_id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			if (updateCount == 1) {
				// 修改成功
				return true;
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 添加用户的购买数量
	public boolean addUserBoughtNumber(int user_id) {
		// 参数是修改的用户id和要添加的数量
		try {
			String sql = "update t_user set bought_number=bought_number+" + 1 + " where id=" + user_id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			if (updateCount == 1) {
				// 修改成功
				return true;
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 减少用户的出售数量
	public boolean decreaseUserAuctionNumber(int user_id, int count) {
			// 参数是修改的用户id和要添加的数量
			try {
				String sql = "update t_user set auction_number=auction_number-" + count + " where id=" + user_id;
				Statement statement = connection.createStatement();
				int updateCount = statement.executeUpdate(sql);
				if (updateCount == 1) {
					// 修改成功
					return true;
				}
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	

	
	public static void main(String[] args) throws Exception {
//		UserDao cc = UserDaoFactory.getDaoInstance();
 
		 
	}

	@Override
	public int saveUser(User user) {
		
		
		int updateCount = 0;
		try {
			// 先查询是否有该用户
			String querySql = "select * from t_user where username='" + user.getUserName() + "'";
			connection=DBCPUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(querySql);
			if (result.next()) {
				// 有该用户，返回false;
				connection.close();
				return 1;
			} else {
				// 没有该用户，可以注册
				String sql = "INSERT INTO T_USER(USERNAME,FIRST_NAME,LAST_NAME,PASSWORD,GENDER,MOBILE,ADDRESS,EMAIL) values('"+user.getUserName()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getPassword()+"','"+user.getGender()+"','"+user.getMobile()+"','"+user.getAddress()+"','"+user.getEmail()+"')";
				
				System.out.println("Saving a new user:"+sql);
				
				statement = connection.createStatement();
				// id自动增加
				
				updateCount = statement.executeUpdate(sql);
				System.out.println(updateCount);
				connection.close();
				// 看看更新的条数
				if (updateCount == 1) {
					return 0;
				} else {
					return 1;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
		
		
 
	}




	 


	
}