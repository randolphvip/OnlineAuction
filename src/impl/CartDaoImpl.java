package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.CartDao;
import entity.Cart;
import util.DBCPUtil;

/**
*/
public class CartDaoImpl implements CartDao {

	private Connection connection = null; // 定义连接的对象

	@Override
	public boolean cartAdd(Cart cart) {
		try {

			connection = DBCPUtil.getConnection();
			String sql = "INSERT INTO T_CART(COMMODITY_ID,USER_ID,CART_STATE) values(?,?,?)";
			System.out.println("SQL:........" + sql);
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, cart.getCommodityId());
			ps.setInt(2, cart.getUserId());
			ps.setInt(3, util.Content.CART_STATE_ACTIVE);
			int updateCount = ps.executeUpdate();

			System.out.println(updateCount);
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Cart getCart(Cart cart) {
		List<Cart> cartList = getCartList(cart);
		if (cartList.size() > 0) {
			return cartList.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<Cart> getCartList(Cart cart) {
		List<Cart> listAll = new ArrayList<Cart>();
		try {
			String sql = "SELECT C.ID, C.COMMODITY_ID ,C.CART_STATE ,C.USER_ID,C.DATE ,o.WINNER_ID ,o.TITLE, o.PICTURE, o.STATE, o.CLOSE_DATE, o.MAX_PRICE, o.PRICE, o.INTRODUCE ,o.PUBLISH_DATE FROM T_CART c, T_COMMODITY o WHERE C.COMMODITY_ID = O.ID";
			String where = "  ";

			if (cart.getId() > 0) {
				where = where + " AND C.ID ='" + cart.getId() + "'";
			}

			if (cart.getCommodityId() > 0) {
				where = where + " AND COMMODITY_ID = '" + cart.getCommodityId() + "'";
			}
			
			if (cart.getUserId() > 0) {
				where = where + " AND C.USER_ID = '" + cart.getUserId() + "'";
			}
			
			if (cart.getCartState() > 0) {
				where = where + " AND c.CART_STATE = '" + cart.getCartState() + "'";
			}
			
			if (cart.getOrderBy() != null & cart.getOrderBy() != "") {
				where = where + " " + cart.getOrderBy() + "";
			}

			if (cart.getLimitBegin() >= 0) {
				where = where + " limit  " + cart.getLimitBegin() + " , " + cart.getPageSize();
			}

			connection = DBCPUtil.getConnection();
			Statement statement = connection.createStatement();
			System.out.println(sql + where);
			ResultSet rs = statement.executeQuery(sql + where);

			while (rs.next()) {
				// 如果有记录（登陆成功）
				Cart c = new Cart();
				// 从数据库获取用户信息，并创建成bean返回
				c.setId(rs.getInt("ID"));
				c.setCommodityId(rs.getInt("COMMODITY_ID"));
				c.setUserId(rs.getInt("USER_ID"));
				c.setCartState(rs.getInt("CART_STATE"));
				c.setDate(rs.getTimestamp("DATE"));
				c.setWinnerId(rs.getInt("WINNER_ID"));
				c.setMaxPrice(rs.getFloat("MAX_PRICE"));
				c.setPrice(rs.getFloat("PRICE"));
				c.setIntroduce(rs.getString("INTRODUCE"));
				c.setPicture(rs.getString("PICTURE"));
				c.setCloseDate(rs.getTimestamp("CLOSE_DATE"));
				c.setState(rs.getInt("STATE"));
				c.setTitle(rs.getString("TITLE"));
				c.setPublishDate(rs.getTimestamp("PUBLISH_DATE"));

				listAll.add(c);
			}
			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listAll;
	}

	@Override
	public boolean changeCartState(int cartId, int state) {
		try {
			String sql = "UPDATE T_CART SET CART_STATE =" + state + " WHERE ID=" + cartId;
			System.out.println("Change cart satae SQL=" + sql);
			connection = DBCPUtil.getConnection(); // 利用构造方法取得数据库连接
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

//	@Override
//	public List<Order> getOrderList(Order order) {
//		List<Order> listAll = new ArrayList<Order>() ;   
//		try {
//			String sql = "SELECT o.*, c.CATEGORY , c.PICTURE ,c.TITLE from T_ORDER o, t_commodity c where o.COMMODITY_ID= c.ID";
//			String where ="  ";
//			
//			if (order.getId() > 0) {
//				where = where + " AND o.ID ='" + order.getId() + "'";
//			}
//			
//			if (order.getCommodityId() > 0) {
//				where = where + " AND o.COMMODITY_ID = '" + order.getCommodityId() + "'";
//			}
//			if (order.getWinnerId() > 0) {
//				where = where + " AND o.WINNER_ID = '" + order.getWinnerId() + "'";
//			}
//			if (order.getPickUpState() > 0) {
//				where = where + " AND o.PICK_UP_STATE = '" + order.getPickUpState() + "'";
//			}
//				
//			if (order.getMessage() != null & order.getMessage() != "") {
//				where = where + " and o.MESSAGE like '%" + order.getMessage() + "%'";
//			}
//			
//			
//			if (order.getPrice() > 0) {
//				where = where + " AND o.PRICE = '" + order.getPrice() + "'";
//			}
//			
//			if (order.getOrderBy() != null & order.getOrderBy() != "") {
//				where = where + " " + order.getOrderBy() + "";
//			}
//
//			if(order.getLimitBegin()>0&&order.getLimitEnd()>0 ) {
//				where = where + " limit  " + order.getLimitBegin()+" , "+ order.getPageSize();
//			}
//		 
//			
//			
//			connection=DBCPUtil.getConnection();
//			Statement statement = connection.createStatement();
//			System.out.println(sql+where);
//			ResultSet rs = statement.executeQuery(sql+where);
//			
//			
//			while (rs.next()) {
//				// 如果有记录（登陆成功）
//				Order u = new Order();
//				// 从数据库获取用户信息，并创建成bean返回
//				u.setId(rs.getInt("ID"));
//				u.setCommodityId(rs.getInt("COMMODITY_ID"));
//				u.setWinnerId(rs.getInt("WINNER_ID"));
//				u.setDealDate(rs.getTimestamp("DEAL_DATE"));
//				u.setPickUpDate(rs.getTimestamp("PICK_UP_DATE"));
//				u.setPickUpState(rs.getInt("PICK_UP_STATE"));
//				u.setMessage(rs.getString("MESSAGE"));
//				u.setPrice(rs.getFloat("PRICE"));
//				//add commodity information;
//			 
//				
//				Commodity commodity = new Commodity();
//				commodity.setId(rs.getInt("COMMODITY_ID"));
//				commodity.setCategory(rs.getInt("CATEGORY"));
//				commodity.setPicture(rs.getString("PICTURE"));
//				commodity.setTitle(rs.getString("TITLE"));
//				u.setCommodity(commodity);
//				listAll.add(u);
//			}
//			rs.close();
//			statement.close();
//			connection.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		
//        return listAll;
//	}

//	
//	@Override
//	public Order getOrderByCommodityId(int commodityID) {
//		
//		String querySql = "select * from T_ORDER where COMMODITY_ID='" + commodityID + "'";
//		Order order=null;
//		try {
//			connection=DBCPUtil.getConnection();
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery(querySql);
//			System.out.println("执行的SQL语句为:........"+querySql);
//			if (rs.next()) {
//				// 有该用户，返回User对象;
//				order=new Order();
//				order.setId(rs.getInt("ID"));
//				order.setCommodityId(rs.getInt("COMMODITY_ID"));
//				order.setWinnerId(rs.getInt("WINNER_ID"));
//				order.setUserName(rs.getString("USER_NAME"));
//				order.setDealDate(rs.getTimestamp("DEAL_DATE"));
//				order.setPickUpDate(rs.getTimestamp("PICK_UP_DATE"));
//				order.setPickUpState(rs.getInt("PICK_UP_STATE"));
//				order.setMessage(rs.getString("MESSAGE"));
//				order.setPrice(rs.getFloat("PRICE"));
//				statement.close();
//				rs.close();
//				connection.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		return order;
//	}
// 
//	@Override
//	public Order getOrderById(int orderID) {
//		
//		String querySql = "select * from T_ORDER where ID='" + orderID + "'";
//		Order order=null;
//		try {
//			connection=DBCPUtil.getConnection();
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery(querySql);
//			System.out.println("执行的SQL语句为:........"+querySql);
//			if (rs.next()) {
//				// 有该用户，返回User对象;
//				order=new Order();
//				order.setId(rs.getInt("ID"));
//				order.setCommodityId(rs.getInt("COMMODITY_ID"));
//				order.setWinnerId(rs.getInt("WINNER_ID"));
//				order.setUserName(rs.getString("USER_NAME"));
//				order.setDealDate(rs.getTimestamp("DEAL_DATE"));
//				order.setPickUpDate(rs.getTimestamp("PICK_UP_DATE"));
//				order.setPickUpState(rs.getInt("PICK_UP_STATE"));
//				order.setMessage(rs.getString("MESSAGE"));
//				order.setPrice(rs.getFloat("PRICE"));
//				statement.close();
//				rs.close();
//				connection.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		return order;
//	}
//	
//	
//	
//
//
//	@Override
//	public int createOrder(int commodityID) {
//		int cout = 0;
//		try {
//			String sql = "INSERT INTO  T_ORDER (COMMODITY_ID,WINNER_ID,DEAL_DATE,PICK_UP_STATE,PRICE) SELECT ID, WINNER_ID, CLOSE_DATE,2,MAX_PRICE FROM T_COMMODITY WHERE STATE =2 AND WINNER_ID IS NOT NULL AND CLOSE_DATE< SYSDATE() ";
//			if(commodityID>0) {
//				sql=sql+" and id='"+commodityID+"' ";
//			}
//			System.out.println("执行的SQL语句为:........"+sql);
//			connection=DBCPUtil.getConnection();
//			connection.setAutoCommit(false);
//			Statement stat = connection.createStatement();
//			 cout = stat.executeUpdate(sql);
//			System.out.println("共生成订单数量："+cout);
//			String sql2 ="UPDATE T_COMMODITY SET STATE='1' WHERE STATE =2 AND CLOSE_DATE< SYSDATE()";
//			if(commodityID>0) {
//				sql2=sql2+" and id='"+commodityID+"' ";
//			}
//			System.out.println("执行的SQL语句为:........"+sql2);
//			Statement stat2 = connection.createStatement();
//			stat2.executeUpdate(sql2);
//			connection.commit();
//			} catch (SQLException e) {
//				try {
//					connection.rollback();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//				e.printStackTrace();
//			}finally {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			return cout;
//		 
//	}
//
//
//	@Override
//	public int createOrder() {
//		return createOrder(0);
//	}
//	@Override
//	public int changeOrderState(int orderId, int pickUpState) {
//		int cout=0;
//		try {
//		String sql="UPDATE T_ORDER SET PICK_UP_STATE= '"+pickUpState+"' WHERE ID='"+orderId+"'";
//		connection=DBCPUtil.getConnection();
//		Statement stat = connection.createStatement();
//		System.out.println("更改订单状态:........"+sql);
//		 cout = stat.executeUpdate(sql);
//		 stat.close();
//		 connection.close();
//		}catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return cout;
//	}
//	
//	
//	@Override
//	public boolean cartAdd( order) {
//		try {
//			String sql = "update T_ORDER set PICK_UP_STATE=3, PICK_UP_DATE='" + order.getPickUpDate() + "' , MESSAGE= '"+order.getMessage()+"'where id=" + order.getId();
//			
//			System.out.println("Make appiontment=" + sql);
//			connection=DBCPUtil.getConnection();
//			Statement statement = connection.createStatement();
//			int updateCount = statement.executeUpdate(sql);
//			connection.close();
//			if (updateCount == 1) {
//				// 修改成功
//				return true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	
//	 
//	

}
