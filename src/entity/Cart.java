package entity;

/**
 */
public class Cart extends Commodity {
	private int id;
	private int commodityId;
	private int userId;
	private int cartState;
	private java.sql.Timestamp date;

	public java.sql.Timestamp getDate() {
		return date;
	}

	public void setDate(java.sql.Timestamp date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCartState() {
		return cartState;
	}

	public void setCartState(int cartState) {
		this.cartState = cartState;
	}

}
