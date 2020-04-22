package entity;

import java.sql.Timestamp;

/**
 * @author rhythm
 * @date 2019年5月18日 下午9:30:10 相关说明
 */
public class Commodity extends BaseBean {
	private int id;// int类型
	private int category;
	private String type;
	private float price;
	private String introduce;
	private String picture;
	private Timestamp closeDate;
	private Timestamp publishDate;
	private float maxPrice;
	private int winnerId;
	private int userId;
	private int state;
	// 商品的id
	private int commodityId;
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
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
		return closeDate;
	}

	public void setCloseDate(Timestamp date) {
		this.closeDate = date;
	}

	public Timestamp getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public static void main(String a[]) {
		Commodity c = new Commodity();
		if (c.getId() > 0) {
			System.out.println("---------");
		} else {
			System.out.println(c.getId());
		}

		System.out.println(c.getPrice());
	}

 
}
