package entity;

import java.sql.Timestamp;

/**
* @author rhythm
* @date 2019年5月7日 下午5:44:01
*  相关说明
*/
public class Stamp extends Commodity{
	private int id;//int类型
	private String type;
	private float price;
	private String introduce;
	private String picture;
	private Timestamp date;
	private float maxPrice;
	private int winnerId;
	private int userId;
	private int state;
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Stamp() {
		super();
	}
	
public float getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(int winnerId) {
		this.winnerId = winnerId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Timestamp getCloseDate() {
		return date;
	}
	public void setCloseDate(Timestamp date) {
		this.date = date;
	}
	
}
