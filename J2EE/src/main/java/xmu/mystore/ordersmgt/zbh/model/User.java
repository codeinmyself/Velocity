package xmu.mystore.ordersmgt.zbh.model;

public class User {
	long userId;
	
	String userName;
	
	String password;
	
	String mobilePhone;
	
	public long getUserId() {
		return userId;
	}
	public void setUseId(long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
}
