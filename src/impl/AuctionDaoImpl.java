package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AuctionDao;
import dao.AuctionDaoFactory;
import entity.Bid;
import util.DbConnection;

/**
 * @author rhythm
 * @date 2019年5月8日 下午5:21:50 相关说明
 */
public class AuctionDaoImpl implements AuctionDao {
	private Connection connection = null; // 定义连接的对象
	private PreparedStatement ps = null; // 定义预准备的对象
	private DbConnection jdbc = null; // 定义数据库连接对象

	public AuctionDaoImpl() {
		jdbc = new DbConnection();
		connection = jdbc.connection; // 利用构造方法取得数据库连接
	}

	@Override
	public int saveBid(Bid bid) {
		try {
			String sql = "insert into T_BID (COMMODITY_ID,USER_ID,USER_NAME,PRICE) values('" + bid.getCommodityID()
					+ "','" + bid.getUserID() + "','" + bid.getUserName() + "','" + bid.getPrice() + "')";

			Statement statement = connection.createStatement();

			statement.executeUpdate(sql);
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		AuctionDao bb = AuctionDaoFactory.getDaoInstance();

	}

	@Override
	public List<Bid> getBids(Bid bid) {
		List<Bid> bids = new ArrayList<Bid>();

		String where = " where  1>0 ";

		if (bid.getCommodityID() > 0) {
			where = where + " and COMMODITY_ID ='" + bid.getCommodityID() + "'";
		}

		if (bid.getUserID() > 0) {
			where = where + " and USER_ID ='" + bid.getUserID() + "'";
		}

		if (bid.getUserName() != null & bid.getUserName() != "") {
			where = where + " and user_name like'%" + bid.getUserName() + "%'";
		}
		if (bid.getOrderBy() != null & bid.getOrderBy() != "") {
			where = where + " " + bid.getOrderBy() + "";
		}

		if (bid.getLimit() > 0) {
			where = where + " limit  " + bid.getLimit();
		}
		String sql = "SELECT * FROM T_BID";
		try {
			System.out.println("执行的SQL语句为:........" + sql + where);
			ps = connection.prepareStatement(sql + where);
			ResultSet rs = null;
			rs = ps.executeQuery();

			while (rs.next()) {
				Bid newBid = new Bid();

				newBid.setId(rs.getInt("ID"));
				newBid.setCommodityID(rs.getInt("COMMODITY_ID"));
				newBid.setUserID(rs.getInt("USER_ID"));
				newBid.setUserName(rs.getString("USER_NAME"));
				newBid.setPrice(rs.getFloat("PRICE"));
				newBid.setDate(rs.getTimestamp("DATE"));
				bids.add(newBid);
			}

			rs.close();
			ps.close();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bids;

	}

}
