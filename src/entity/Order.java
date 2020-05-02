package entity;

import java.sql.Timestamp;

/**
*/
public class Order extends BaseBean {
	private int id;//int类型
	private int commodityId;
	private float price;
	private int winnerId;
	private String userName;
	private Timestamp dealDate;
	private Timestamp pickUpDate;
	private int pickUpState;
	private String message;
	
	public Timestamp getDealDate() {
		return dealDate;
	}
	public void setDealDate(Timestamp dealDate) {
		this.dealDate = dealDate;
	}
	private String type;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(Timestamp pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public int getPickUpState() {
		return pickUpState;
	}
	public void setPickUpState(int pickUpState) {
		this.pickUpState = pickUpState;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(int winnerId) {
		this.winnerId = winnerId;
	}
	 
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
 
	
}
