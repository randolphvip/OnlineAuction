package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import entity.Commodity;
import entity.Order;
import util.DBCPUtil;

/**
*/
public class OrderDaoImpl implements OrderDao{
	
	private Connection connection = null; // 定义连接的对象
	private PreparedStatement ps = null; // 定义预准备的对象


	@Override
	public List<Order> getOrderList(Order order) {
		List<Order> listAll = new ArrayList<Order>() ;   
		try {
			String sql = "SELECT O.*, C.CATEGORY , C.PICTURE ,C.TITLE, U.USERNAME FROM T_ORDER O, T_COMMODITY C ,T_USER U WHERE O.COMMODITY_ID= C.ID and U.ID= O.WINNER_ID";
			String where ="  ";
			
			if (order.getId() > 0) {
				where = where + " AND o.ID ='" + order.getId() + "'";
			}
			
			if (order.getCommodityId() > 0) {
				where = where + " AND o.COMMODITY_ID = '" + order.getCommodityId() + "'";
			}
			if (order.getWinnerId() > 0) {
				where = where + " AND o.WINNER_ID = '" + order.getWinnerId() + "'";
			}
			if (order.getPickUpState() > 0) {
				where = where + " AND o.PICK_UP_STATE = '" + order.getPickUpState() + "'";
			}
				
			if (order.getMessage() != null & order.getMessage() != "") {
				where = where + " and o.MESSAGE like '%" + order.getMessage() + "%'";
			}
			
			
			if (order.getPrice() > 0) {
				where = where + " AND o.PRICE = '" + order.getPrice() + "'";
			}
			
			if (order.getOrderBy() != null & order.getOrderBy() != "") {
				where = where + " " + order.getOrderBy() + "";
			}

			if(order.getLimitBegin()>=0 ) {
				where = where + " limit  " + order.getLimitBegin()+" , "+ order.getPageSize();
			}
		 
			
			
			connection=DBCPUtil.getConnection();
			Statement statement = connection.createStatement();
			System.out.println(sql+where);
			ResultSet rs = statement.executeQuery(sql+where);
			
			
			while (rs.next()) {
				// 如果有记录（登陆成功）
				Order o = new Order();
				// 从数据库获取用户信息，并创建成bean返回
				o.setId(rs.getInt("ID"));
				o.setCommodityId(rs.getInt("COMMODITY_ID"));
				o.setWinnerId(rs.getInt("WINNER_ID"));
				o.setDealDate(rs.getTimestamp("DEAL_DATE"));
				o.setPickUpDate(rs.getTimestamp("PICK_UP_DATE"));
				o.setPickUpState(rs.getInt("PICK_UP_STATE"));
				o.setMessage(rs.getString("MESSAGE"));
				o.setPrice(rs.getFloat("PRICE"));
				o.setUserName(rs.getString("USERNAME"));
				//add commodity information;
			 
				
				Commodity commodity = new Commodity();
				commodity.setId(rs.getInt("COMMODITY_ID"));
				commodity.setCategory(rs.getInt("CATEGORY"));
				commodity.setPicture(rs.getString("PICTURE"));
				commodity.setTitle(rs.getString("TITLE"));
				o.setCommodity(commodity);
				listAll.add(o);
			}
			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
        return listAll;
	}
	
	
	@Override
	public Order getOrderByCommodityId(int commodityID) {
		
		String querySql = "select * from T_ORDER where COMMODITY_ID='" + commodityID + "'";
		Order order=null;
		try {
			connection=DBCPUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(querySql);
			System.out.println("执行的SQL语句为:........"+querySql);
			if (rs.next()) {
				// 有该用户，返回User对象;
				order=new Order();
				order.setId(rs.getInt("ID"));
				order.setCommodityId(rs.getInt("COMMODITY_ID"));
				order.setWinnerId(rs.getInt("WINNER_ID"));
				order.setUserName(rs.getString("USER_NAME"));
				order.setDealDate(rs.getTimestamp("DEAL_DATE"));
				order.setPickUpDate(rs.getTimestamp("PICK_UP_DATE"));
				order.setPickUpState(rs.getInt("PICK_UP_STATE"));
				order.setMessage(rs.getString("MESSAGE"));
				order.setPrice(rs.getFloat("PRICE"));
				statement.close();
				rs.close();
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return order;
	}
 
	@Override
	public Order getOrderById(int orderID) {
		
		String querySql = "select * from T_ORDER where ID='" + orderID + "'";
		Order order=null;
		try {
			connection=DBCPUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(querySql);
			System.out.println("执行的SQL语句为:........"+querySql);
			if (rs.next()) {
				// 有该用户，返回User对象;
				order=new Order();
				order.setId(rs.getInt("ID"));
				order.setCommodityId(rs.getInt("COMMODITY_ID"));
				order.setWinnerId(rs.getInt("WINNER_ID"));
				order.setUserName(rs.getString("USER_NAME"));
				order.setDealDate(rs.getTimestamp("DEAL_DATE"));
				order.setPickUpDate(rs.getTimestamp("PICK_UP_DATE"));
				order.setPickUpState(rs.getInt("PICK_UP_STATE"));
				order.setMessage(rs.getString("MESSAGE"));
				order.setPrice(rs.getFloat("PRICE"));
				statement.close();
				rs.close();
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return order;
	}
	
	@Override
	public int createOrder(Order order) {
		try {
		String sql = "INSERT INTO T_ORDER(COMMODITY_ID,WINNER_ID,USER_NAME,PICK_UP_STATE,PRICE) values(?,?,?,?,?)";
		System.out.println("执行的SQL语句为:........"+sql);
		connection=DBCPUtil.getConnection();
		connection.setAutoCommit(false);
		PreparedStatement ps1 = connection.prepareStatement(sql);
		// id自动增加
		ps.setInt(1, order.getCommodityId());
		ps.setInt(2, order.getWinnerId());
		ps.setString(3, order.getUserName());
		ps.setInt(4, order.getPickUpState());
		ps.setFloat(5, order.getPrice());
		int updateCount = ps1.executeUpdate();
		System.out.println(updateCount);
		String sql2 ="UPDATE T_COMMODITY SET STATE='1' WHERE STATE =2 AND ID='"+order.getCommodityId()+"'";
		Statement stat2 = connection.createStatement();
		stat2.executeUpdate(sql2);
		
		connection.commit();
		
		
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 0;
	}
	


	@Override
	public int createOrder(int commodityID) {
		int cout = 0;
		try {
			String sql = "INSERT INTO  T_ORDER (COMMODITY_ID,WINNER_ID,DEAL_DATE,PICK_UP_STATE,PRICE) SELECT ID, WINNER_ID, CLOSE_DATE,2,MAX_PRICE FROM T_COMMODITY WHERE STATE =2 AND WINNER_ID IS NOT NULL AND CLOSE_DATE< SYSDATE() ";
			if(commodityID>0) {
				sql=sql+" and id='"+commodityID+"' ";
			}
			System.out.println("执行的SQL语句为:........"+sql);
			connection=DBCPUtil.getConnection();
			connection.setAutoCommit(false);
			Statement stat = connection.createStatement();
			 cout = stat.executeUpdate(sql);
			System.out.println("共生成订单数量："+cout);
			String sql2 ="UPDATE T_COMMODITY SET STATE='1' WHERE STATE =2 AND CLOSE_DATE< SYSDATE()";
			if(commodityID>0) {
				sql2=sql2+" and id='"+commodityID+"' ";
			}
			System.out.println("执行的SQL语句为:........"+sql2);
			Statement stat2 = connection.createStatement();
			stat2.executeUpdate(sql2);
			connection.commit();
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return cout;
		 
	}


	@Override
	public int createOrder() {
		return createOrder(0);
	}
	@Override
	public int changeOrderState(int orderId, int pickUpState) {
		int cout=0;
		try {
		String sql="UPDATE T_ORDER SET PICK_UP_STATE= '"+pickUpState+"' WHERE ID='"+orderId+"'";
		connection=DBCPUtil.getConnection();
		Statement stat = connection.createStatement();
		System.out.println("更改订单状态:........"+sql);
		 cout = stat.executeUpdate(sql);
		 stat.close();
		 connection.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return cout;
	}
	
	
	@Override
	public boolean makeAppointment(Order order) {
		try {
			String sql = "update T_ORDER set PICK_UP_STATE=3, PICK_UP_DATE='" + order.getPickUpDate() + "' , MESSAGE= '"+order.getMessage()+"'where id=" + order.getId();
			
			System.out.println("Make appiontment=" + sql);
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

	
	
	
	
//	
//	public boolean addOrder(int commodityId,float price,int winnerId, int userId,String type){
//		boolean state = false;
//		try {
//			
//			String sql = "insert into t_order(commodity_id,price,winner_id,user_id,type) values(?,?,?,?,?);";
//			ps = connection.prepareStatement(sql);
//			ps.setInt(1, commodityId);
//			ps.setFloat(2, price);
//			ps.setInt(3, winnerId);
//			ps.setInt(4, userId);
//			ps.setString(5, type);
//			int updateCount = ps.executeUpdate();
//			if(updateCount == 1){
//				state = true;
//			}
//			connection.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return state;
//	}
//	// 根据类型和id寻找订单id
//	public int selectId(int id,String type) {
//		int orderId = 0;
//		String sql = "select * from t_order where commodity_id= '"+ id+"' and category='"+type+"'";
//		Statement statement = null;
//		try {
//			statement = connection.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ResultSet rs = null;
//		try {
//			rs = statement.executeQuery(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			rs.next();
//			orderId=rs.getInt("id");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return orderId;
//	}
//	//删除订单
//	public boolean deleteById(int id) {
//		boolean state = false;
//		String sql = "delete from t_order where id= '"+ id+"'";
//		try {
//			ps = connection.prepareStatement(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//更新
//		int updateCount = 0;
//		try {
//			updateCount = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		System.out.println(updateCount);
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 看看更新的条数
//		if (updateCount == 1) {
//			state =true;
//		} 
//		return state;
//	}

	 

	public static void main(String[] args) {
		
//		OrderDao thisDao = OrderDaoFactory.getDaoInstance();
//		System.out.println(thisDao.addOrder(10,20,10,10,"book"));
		
	}


	





}
