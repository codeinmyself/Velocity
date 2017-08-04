package xmu.mall.usercenter.ghz.entity;

public class Address {
    private Integer id;//id
    private Integer user_id;//用户id
    private String consignee = null;//收件人
    private String zipcode = null;//邮政编码
    private String telephone = null;//电话号码
    private String country = null;//国家
    private String province = null;//省份
    private String city = null;//诚实
    private String district = null;//区
    private String detail = null;//详细地址
    private boolean is_default = false;//是否默认

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
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

    public void setTelephone(String telphone) {
        this.telephone = telphone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

	@Override
	public String toString() {
		return "Address [id=" + id + ", user_id=" + user_id + ", consignee=" + consignee + ", zipcode=" + zipcode
				+ ", telephone=" + telephone + ", country=" + country + ", province=" + province + ", city=" + city
				+ ", district=" + district + ", detail=" + detail + ", is_default=" + is_default + "]";
	}
    
    
}