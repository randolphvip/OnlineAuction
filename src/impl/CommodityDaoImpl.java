package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import dao.BookDaoFactory;
import dao.CommodityDao;
import dao.CommodityDaoFactory;
import dao.StampDao;
import dao.StampDaoFactory;
import dao.WatchDao;
import dao.WatchDaoFactory;
import dao.WineDao;
import dao.WineDaoFactory;
import entity.Commodity;
import util.DbConnection;

/**
 * @author rhythm
 * @date 2019年5月19日 下午6:01:21 相关说明
 */
public class CommodityDaoImpl implements CommodityDao {

	private Connection connection = null; // 定义连接的对象
	private PreparedStatement ps = null; // 定义预准备的对象
	private DbConnection jdbc = null; // 定义数据库连接对象

	public CommodityDaoImpl() {
		jdbc = new DbConnection();
		connection = jdbc.connection; // 利用构造方法取得数据库连接
	}

	// 模糊查询
	public List fuzzySerchBookList(String keyword) {
		List<Commodity> ListAll = new ArrayList<Commodity>();
		String sql = "select * from t_book where (category like '%" + keyword + "%')or(introduce like '%" + keyword
				+ "%')";
//			Statement statement = connection.createStatement();
		// 下面是针对数据库的具体操作
		// 连接数据库
		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 进行数据库查询操作
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int i = 1;
			while (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给book对象
				Commodity commodity = new Commodity();
				commodity.setId(i);
				i++;
				commodity.setUserId(rs.getInt(2));
				commodity.setType(rs.getString(3));
				commodity.setWinnerId(rs.getInt(4));
				commodity.setMaxPrice(rs.getInt(5));
				commodity.setPrice(rs.getFloat(6));

				commodity.setIntroduce(rs.getString(7));
				commodity.setPicture(rs.getString(8));
				commodity.setDate(rs.getTimestamp(9));
				commodity.setState(rs.getInt(10));
				// 商品的id
				commodity.setCommodityId(rs.getInt(1));
				// 将查询出来的数据加入到List对象之中
				ListAll.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭数据库连接
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListAll;
	}

	// 模糊查询
	public List fuzzySerchWatchList(String keyword) {
		List<Commodity> ListAll = new ArrayList<Commodity>();
		String sql = "select * from t_watch where (category like '%" + keyword + "%')or(introduce like '%" + keyword
				+ "%')";
//				Statement statement = connection.createStatement();
		// 下面是针对数据库的具体操作
		// 连接数据库
		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 进行数据库查询操作
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int i = 1;
			while (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给book对象
				Commodity commodity = new Commodity();
				commodity.setId(i);
				i++;
				commodity.setUserId(rs.getInt(2));
				commodity.setType(rs.getString(3));
				commodity.setWinnerId(rs.getInt(4));
				commodity.setMaxPrice(rs.getInt(5));
				commodity.setPrice(rs.getFloat(6));

				commodity.setIntroduce(rs.getString(7));
				commodity.setPicture(rs.getString(8));
				commodity.setDate(rs.getTimestamp(9));
				commodity.setState(rs.getInt(10));
				// 商品的id
				commodity.setCommodityId(rs.getInt(1));
				// 将查询出来的数据加入到List对象之中
				ListAll.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭数据库连接
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListAll;
	}

	// 模糊查询
	public List fuzzySerchStampList(String keyword) {
		List<Commodity> ListAll = new ArrayList<Commodity>();
		String sql = "select * from t_stamp where (category like '%" + keyword + "%')or(introduce like '%" + keyword
				+ "%')";
//				Statement statement = connection.createStatement();
		// 下面是针对数据库的具体操作
		// 连接数据库
		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 进行数据库查询操作
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int i = 1;
			while (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给book对象
				Commodity commodity = new Commodity();
				commodity.setId(i);
				i++;
				commodity.setUserId(rs.getInt(2));
				commodity.setType(rs.getString(3));
				commodity.setWinnerId(rs.getInt(4));
				commodity.setMaxPrice(rs.getInt(5));
				commodity.setPrice(rs.getFloat(6));

				commodity.setIntroduce(rs.getString(7));
				commodity.setPicture(rs.getString(8));
				commodity.setDate(rs.getTimestamp(9));
				commodity.setState(rs.getInt(10));
				// 商品的id
				commodity.setCommodityId(rs.getInt(1));
				// 将查询出来的数据加入到List对象之中
				ListAll.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭数据库连接
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListAll;
	}

	// 模糊查询
	public List fuzzySerchWineList(String keyword) {
		List<Commodity> ListAll = new ArrayList<Commodity>();
		String sql = "select * from t_wine where (category like '%" + keyword + "%')or(introduce like '%" + keyword
				+ "%')";
		// 下面是针对数据库的具体操作
		// 连接数据库
		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 进行数据库查询操作
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int i = 1;
			while (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给book对象
				Commodity commodity = new Commodity();
				commodity.setId(i);
				i++;
				commodity.setUserId(rs.getInt(2));
				commodity.setType(rs.getString(3));
				commodity.setWinnerId(rs.getInt(4));
				commodity.setMaxPrice(rs.getInt(5));
				commodity.setPrice(rs.getFloat(6));

				commodity.setIntroduce(rs.getString(7));
				commodity.setPicture(rs.getString(8));
				commodity.setDate(rs.getTimestamp(9));
				commodity.setState(rs.getInt(10));
				// 商品的id
				commodity.setCommodityId(rs.getInt(1));
				// 将查询出来的数据加入到List对象之中
				ListAll.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭数据库连接
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListAll;
	}

	public List fuzzySerch(String keyWord) {
		List<Commodity> thisList = new ArrayList<Commodity>();

		// 模糊查询book
		CommodityDao commDao1 = CommodityDaoFactory.getDaoInstance();
		List<Commodity> commodityBook = new ArrayList<Commodity>();
		commodityBook = commDao1.fuzzySerchBookList(keyWord);
		for (int i = 0; i < commodityBook.size(); i++) {
			Commodity thiscommodity = commodityBook.get(i);
//			System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		// 模糊查询watch
		CommodityDao commDao2 = CommodityDaoFactory.getDaoInstance();
		List<Commodity> commodityWatch = new ArrayList<Commodity>();
		commodityWatch = commDao2.fuzzySerchWatchList(keyWord);
		for (int i = 0; i < commodityWatch.size(); i++) {
			Commodity thiscommodity = commodityWatch.get(i);
//			System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		// 模糊查询stamp
		CommodityDao commDao3 = CommodityDaoFactory.getDaoInstance();
		List<Commodity> commodityStamp = new ArrayList<Commodity>();
		commodityStamp = commDao3.fuzzySerchStampList(keyWord);
		for (int i = 0; i < commodityStamp.size(); i++) {
			Commodity thiscommodity = commodityStamp.get(i);
//			System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		// 模糊查询wine
		CommodityDao commDao4 = CommodityDaoFactory.getDaoInstance();
		List<Commodity> commodityWine = new ArrayList<Commodity>();
		commodityWine = commDao4.fuzzySerchWineList(keyWord);
		for (int i = 0; i < commodityWine.size(); i++) {
			Commodity thiscommodity = commodityWine.get(i);
//					System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		return thisList;
	}

	// 获取所有
	@Override
	public List getAllList() {
		// TODO Auto-generated method stub
		List<Commodity> thisList = new ArrayList<Commodity>();

		// book
		BookDao bookDao = BookDaoFactory.getBookDaoInstance();
		List<Commodity> commodityBook = new ArrayList<Commodity>();
		commodityBook = bookDao.getBookAll();
		for (int i = 0; i < commodityBook.size(); i++) {
			Commodity thiscommodity = commodityBook.get(i);
			thiscommodity.setCommodityId(commodityBook.get(i).getId());
//			System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}

		// watch
		WatchDao watchDao = WatchDaoFactory.getWatchDaoInstance();
		List<Commodity> commodityWatch = new ArrayList<Commodity>();
		commodityWatch = watchDao.getWatchAll();
		for (int i = 0; i < commodityWatch.size(); i++) {
			Commodity thiscommodity = commodityWatch.get(i);
			thiscommodity.setCommodityId(commodityWatch.get(i).getId());
//			System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		// stamp
		StampDao stampDao = StampDaoFactory.getDaoInstance();
		List<Commodity> commodityStamp = new ArrayList<Commodity>();
		commodityStamp = stampDao.getListAll();
		for (int i = 0; i < commodityStamp.size(); i++) {
			Commodity thiscommodity = commodityStamp.get(i);
			thiscommodity.setCommodityId(commodityStamp.get(i).getId());
//			System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		// wine
		WineDao wineDao = WineDaoFactory.getDaoInstance();
		List<Commodity> commodityWine = new ArrayList<Commodity>();
		commodityWine = wineDao.getListAll();
		for (int i = 0; i < commodityWine.size(); i++) {
			Commodity thiscommodity = commodityWine.get(i);
			thiscommodity.setCommodityId(commodityWine.get(i).getId());
//					System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		return thisList;
	}

	public static void main(String[] args) throws Exception {
		CommodityDao bb = CommodityDaoFactory.getDaoInstance();
		Commodity c = new Commodity();
		c.setCategory(2);

		List<Commodity> commodities = new ArrayList<Commodity>();
		commodities = bb.getCommodityList(c);
		System.out.println(commodities.size());
		for (Commodity commodity : commodities) {
			System.out.println(commodity.getId());
		}

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
		if (obj.getDate() != null) {
			where = where + " and date ='" + obj.getDate() + "'";
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
				commodity.setDate(rs.getTimestamp("DATE"));
				commodity.setState(rs.getInt("STATE"));
				commodity.setCategory(rs.getInt("CATEGORY"));
				commodity.setTitle(rs.getString("TITLE"));
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
		String sql ="select * from t_commodity where id ='"+commodityPara.getId()+"'";
		System.out.println("执行的SQL语句为:........" + sql );
		Commodity commodity = new Commodity();
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();
			if(rs.next()) {
				
				commodity.setId(rs.getInt("ID"));
				commodity.setUserId(rs.getInt("USER_ID"));
				// commodity.setType(rs.getString("TYPE"));
				commodity.setWinnerId(rs.getInt("WINNER_ID"));
				commodity.setMaxPrice(rs.getFloat("MAX_PRICE"));
				commodity.setPrice(rs.getFloat("PRICE"));
				commodity.setIntroduce(rs.getString("INTRODUCE"));
				commodity.setPicture(rs.getString("PICTURE"));
				commodity.setDate(rs.getTimestamp("DATE"));
				commodity.setState(rs.getInt("STATE"));
				commodity.setCategory(rs.getInt("CATEGORY"));
				commodity.setTitle(rs.getString("TITLE"));
			}
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commodity;
	}

}
