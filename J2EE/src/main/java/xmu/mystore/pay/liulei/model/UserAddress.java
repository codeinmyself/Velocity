package xmu.mystore.pay.liulei.model;

public class UserAddress {
	long address_id; // 主码，地址ID
	long user_id; // 用户ID
	String consignee; // 收件人
	String zipcode; // 邮编
	String telephone; // 电话
	int country; // 国家ID
	int province; // 省ID
	int city; // 城市ID
	int district; // 区ID
	String detail; // 详细地址
	boolean isdefault; // 是否为默认地址。注：一个用户常用地址可以是多个，默认地址就只有一个(⊙o⊙)哦

	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public boolean isIsdefault() {
		return isdefault;
	}

	public void setIsdefault(boolean isdefault) {
		this.isdefault = isdefault;
	}

	@Override
	public String toString() {
		return "User_address [address_id=" + address_id + ", user_id=" + user_id + ", consignee=" + consignee
				+ ", zipcode=" + zipcode + ", telephone=" + telephone + ", country=" + country + ", province="
				+ province + ", city=" + city + ", district=" + district + ", detail=" + detail + ", isdefault="
				+ isdefault + "]";
	}

}
