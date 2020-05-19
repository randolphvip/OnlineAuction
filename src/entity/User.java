package entity;


/**
*/
public class User extends BaseBean{
	private int id;//int类型
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private int gender;
	private String mobile;
	private int admin;
	private String address;
	
	private String email;
	private int state;
	
	
//	
//	private String name;//计划删除
//	private String phone;//计划删除
//	
//	private int bought_number;//计划删除
//	private int auction_number;//计划删除
//	
//	
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public int getBought_number() {
//		return bought_number;
//	}
//
//	public void setBought_number(int bought_number) {
//		this.bought_number = bought_number;
//	}
//
//	public int getAuction_number() {
//		return auction_number;
//	}
//
//	public void setAuction_number(int auction_number) {
//		this.auction_number = auction_number;
//	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
