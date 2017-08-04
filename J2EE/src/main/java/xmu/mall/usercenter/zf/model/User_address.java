package xmu.mall.usercenter.zf.model;

import java.io.Serializable;

/**
 * Created by 63520 on 2017/5/26.
 */
public class User_address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4964182355909633539L;
	
	private long address_id;          //主码，地址ID
	private long user_id;             //用户ID
	private String consignee;         //收件人
	private String zipcode;     	  //邮编
	private String telephone;   	  //电话
	private int  country;             //国家ID
	private String country_name;		  	  //国家名
	private int  province;            //省ID
	private String province_name;
	private int  city;                //城市ID
	private String city_name;
	private int  district;            //区ID
	private String district_name;
	private String detail;            //详细地址
	private boolean is_default;       //是否为默认地址
	
	public User_address(){
		this.address_id = 0;
		this.user_id = 0;
		this.consignee = "";
		this.zipcode = "";
		this.telephone = "";
		this.country = 1;
		this.country_name = "中国";
		this.province = 0;
		this.province_name = "";
		this.city = 0;
		this.city_name = "";
		this.district = 0;
		this.district_name = "";
		this.detail = "";
		this.is_default = false;
	}
	
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
	public boolean getIs_default() {
		return is_default;
	}
	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	
}
