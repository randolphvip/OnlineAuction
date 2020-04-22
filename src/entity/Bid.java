package entity;

import java.sql.Timestamp;

/**
 * @author rhythm
 * @date 2019年5月7日 下午5:44:01 相关说明
 */
public class Bid extends  BaseBean {
	private int id;// int类型
	private int CommodityID;// int类型
	private int userID;
	private String userName;
	private float price;
	private Timestamp date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommodityID() {
		return CommodityID;
	}

	public void setCommodityID(int commodityID) {
		CommodityID = commodityID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}
