package dao;

import java.sql.SQLException;
import java.util.List;

import entity.User;

/**
 */
public interface UserDao {

  
	//变为管理员
	public boolean changeAdmin(int id);
	//变为普通用户
	public boolean changeOrdinary(int id);
	// 查询全部
 


	//登录操作
	public User login(String username,String password) throws Exception;
	// 注册操作
	public int register(String username, String password);
	//根据用户名查询用户
	
	//判断是否有重名
	public int JudgeName(String username) throws SQLException;
	 

	
	//----------------------------------------------------------------
	
	public int updateUser(User user);
	public int saveUser(User user);
	
	public List<User> findUserList(User user);
	
	public  boolean updateState(int userId, int state);
	
	//refind password
	public User getUserByName(String username);
	//change password
	public boolean changeUserPassword(int user_id,String password);
	// 以id查询
	public User getUserById(int index);
	
	public  boolean updateAdmin(int userId, int admin);
}
