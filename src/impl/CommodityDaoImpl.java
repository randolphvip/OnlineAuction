package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AuctionDao;
import dao.CommodityDao;
import dao.DaoFactory;
import entity.Bid;
import entity.Commodity;
import util.Content;
import util.DBCPUtil;

/**
 */
public class CommodityDaoImpl implements CommodityDao {

	private Connection connection = null; // 定义连接的对象
	private PreparedStatement ps = null; // 定义预准备的对象

	public CommodityDaoImpl() {
//		jdbc = new DbConnection();
//		connection = jdbc.connection; // 利用构造方法取得数据库连接
	}

	@Override
	public List<Commodity> getCommodityList(Commodity obj) {
		List<Commodity> ListAll = new ArrayList<Commodity>();

		String where = " where  1>0 ";

		if (obj.getId() > 0) {
			where = where + " and id ='" + obj.getType() + "'";
		}
		if (obj.getType() != null & obj.getType() != "") {
			where = where + " and type like '%" + obj.getType() + "%'";
		}
		if (obj.getPrice() > 0) {
			where = where + " and type ='" + obj.getType() + "'";
		}
		if (obj.getIntroduce() != null & obj.getIntroduce() != "") {
			where = where + " and introduce like'%" + obj.getIntroduce() + "%'";
		}
		if (obj.getCloseDate() != null) {
			where = where + " and Close_date ='" + obj.getCloseDate() + "'";
		}
		if (obj.getPublishDate() != null) {
			where = where + " and publish_date ='" + obj.getPublishDate() + "'";
		}
		if (obj.getMaxPrice() > 0) {
			where = where + " and maxPrice ='" + obj.getIntroduce() + "'";
		}
		if (obj.getWinnerId() > 0) {
			where = where + " and winnerId ='" + obj.getWinnerId() + "'";
		}
		if (obj.getUserId() > 0) {
			where = where + " and userId ='" + obj.getUserId() + "'";
		}
		if (obj.getState() > 0) {
			where = where + " and state ='" + obj.getState() + "'";
		}
		if (obj.getCategory() > 0) {
			where = where + " and category ='" + obj.getCategory() + "'";
		}
		if (obj.getTitle() != null & obj.getTitle() != "") {
			where = where + " and title like'%" + obj.getTitle() + "%'";
		}
		if (obj.getOrderBy() != null & obj.getOrderBy() != "") {
			where = where + " " + obj.getOrderBy() + "";
		}

		if (obj.getLimit() > 0) {
			where = where + " limit  " + obj.getLimit();
		}
		String sql = "select * from t_commodity";
		try {
			System.out.println("执行的SQL语句为:........" + sql + where);
			connection = DBCPUtil.getConnection(); // 利用构造方法取得数据库连接
			ps = connection.prepareStatement(sql + where);
			ResultSet rs = null;
			rs = ps.executeQuery();

			while (rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setId(rs.getInt("ID"));
				commodity.setUserId(rs.getInt("USER_ID"));
				// commodity.setType(rs.getString("TYPE"));
				commodity.setWinnerId(rs.getInt("WINNER_ID"));
				commodity.setMaxPrice(rs.getFloat("MAX_PRICE"));
				commodity.setPrice(rs.getFloat("PRICE"));
				commodity.setIntroduce(rs.getString("INTRODUCE"));
				commodity.setPicture(rs.getString("PICTURE"));
				commodity.setCloseDate(rs.getTimestamp("CLOSE_DATE"));
				commodity.setState(rs.getInt("STATE"));
				commodity.setCategory(rs.getInt("CATEGORY"));
				commodity.setTitle(rs.getString("TITLE"));
				commodity.setPublishDate(rs.getTimestamp("PUBLISH_DATE"));
				ListAll.add(commodity);

			}

			rs.close();
			ps.close();
			connection.close();
		} catch (Exception ex) {

		}
		return ListAll;
	}

	@Override
	public Commodity getCommodity(Commodity commodityPara) {
		String sql = "select * from t_commodity where id ='" + commodityPara.getId() + "'";
		System.out.println("执行的SQL语句为:........" + sql);
		Commodity commodity = new Commodity();
		try {
			connection = DBCPUtil.getConnection(); // 利用构造方法取得数据库连接
			ps = connection.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();
			if (rs.next()) {

				commodity.setId(rs.getInt("ID"));
				commodity.setUserId(rs.getInt("USER_ID"));
				commodity.setWinnerId(rs.getInt("WINNER_ID"));
				commodity.setMaxPrice(rs.getFloat("MAX_PRICE"));
				commodity.setPrice(rs.getFloat("PRICE"));
				commodity.setIntroduce(rs.getString("INTRODUCE"));
				commodity.setPicture(rs.getString("PICTURE"));
				commodity.setCloseDate(rs.getTimestamp("CLOSE_DATE"));
				commodity.setState(rs.getInt("STATE"));
				commodity.setCategory(rs.getInt("CATEGORY"));
				commodity.setTitle(rs.getString("TITLE"));
				commodity.setPublishDate(rs.getTimestamp("PUBLISH_DATE"));

				// 添加出价信息。
				AuctionDao auctionDao = DaoFactory.getAuctionDaoInstance();
				Bid bid = new Bid();
				bid.setCommodityID(commodity.getId());
				bid.setLimit(20);
				bid.setOrderBy(" order by date desc ");
				List<Bid> bids = auctionDao.getBids(bid);
				commodity.setBids(bids);
			}
			rs.close();
			ps.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return commodity;
	}
	
	@Override
	public Commodity getCommodityByID(int commodityID) {
		String sql = "select * from t_commodity where id ='" + commodityID + "'";
		System.out.println("执行的SQL语句为:........" + sql);
		Commodity commodity = new Commodity();
		try {
			connection = DBCPUtil.getConnection(); // 利用构造方法取得数据库连接
			ps = connection.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();
			if (rs.next()) {

				commodity.setId(rs.getInt("ID"));
				commodity.setUserId(rs.getInt("USER_ID"));
				commodity.setWinnerId(rs.getInt("WINNER_ID"));
				commodity.setMaxPrice(rs.getFloat("MAX_PRICE"));
				commodity.setPrice(rs.getFloat("PRICE"));
				commodity.setIntroduce(rs.getString("INTRODUCE"));
				commodity.setPicture(rs.getString("PICTURE"));
				commodity.setCloseDate(rs.getTimestamp("CLOSE_DATE"));
				commodity.setState(rs.getInt("STATE"));
				commodity.setCategory(rs.getInt("CATEGORY"));
				commodity.setTitle(rs.getString("TITLE"));
				commodity.setPublishDate(rs.getTimestamp("PUBLISH_DATE"));

				// 添加出价信息。
				AuctionDao auctionDao = DaoFactory.getAuctionDaoInstance();
				Bid bid = new Bid();
				bid.setCommodityID(commodity.getId());
				bid.setLimit(20);
				bid.setOrderBy(" order by date desc ");
				List<Bid> bids = auctionDao.getBids(bid);
				commodity.setBids(bids);
			}
			rs.close();
			ps.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return commodity;
	}


	@Override
	public boolean updateMaxPrice(int commodityId, float price, int winnerId) {
		try {

			String sql = "update T_COMMODITY set max_price=" + price + ",winner_id=" + winnerId + " where id="
					+ commodityId;
			System.out.println("出价信息： 出价人ID=" + winnerId + "    价格=" + price + "   商品编号=" + commodityId);
			System.out.println(sql);
			connection = DBCPUtil.getConnection(); // 利用构造方法取得数据库连接
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

	@Override
	public boolean updateState(int commodityId, int state) {
		try {
			String sql = "update T_COMMODITY set state=" + state + " where id=" + commodityId;
			System.out.println("更改商品狀態 ID=" + sql);
			connection = DBCPUtil.getConnection(); // 利用构造方法取得数据库连接
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
	
	
	
	
	
	
	
	
	

	
	@Override
	public Commodity saveCommodity(Commodity commodity) {
		
		try {
			String sql="INSERT into T_COMMODITY(USER_ID,MAX_PRICE,PRICE,INTRODUCE,PICTURE,STATE,TITLE,CLOSE_DATE,CATEGORY) values(?,?,?,?,?,?,?,?,?)";
		System.out.println("新增商品 ID=" + sql);
		connection = DBCPUtil.getConnection(); // 利用构造方法取得数据库连接
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, commodity.getUserId());
	    ps.setFloat(2, commodity.getMaxPrice());
	    ps.setFloat(3,commodity.getPrice());
	    
	    ps.setString(4, commodity.getIntroduce());
	    ps.setString(5, commodity.getPicture());
	    ps.setInt(6, Content.COMMODITY_STATE_SELLING);
	    ps.setString(7, commodity.getTitle());
	    ps.setTimestamp(8, commodity.getCloseDate());
	    ps.setInt(9, commodity.getCategory());
	    ps.executeUpdate();
		ps.close();
	    connection.close();
	    
	    
	      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commodity;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	  
 
	 

	public static void main(String[] args) throws Exception {
		CommodityDao bb = DaoFactory.getCommodityDaoInstance();
		Commodity c = new Commodity();
		c.setCategory(2);

		List<Commodity> commodities = new ArrayList<Commodity>();
		commodities = bb.getCommodityList(c);
		System.out.println(commodities.size());
		for (Commodity commodity : commodities) {
			System.out.println(commodity.getId());
		}

	}


 

}
