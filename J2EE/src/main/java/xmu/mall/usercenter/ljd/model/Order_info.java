package xmu.mall.usercenter.ljd.model;

import java.util.Set;

import xmu.mall.usercenter.ljd.model.Goods;

public class Order_info
{
	private long order_id;
	private String order_sn;
	private long user_id;
	private int order_status;
	private String consignee;
	private String address;
	private String zipcode;
	private String telephone;
	private String email;
	private Double goods_price;
	private Double order_price;
	private String remark;
	private Double total_weight;
	private String signature_characters;
	private int add_time;
	private int pay_time;
	private int make_time;
	private int shipped_time;
	private int receive_time;
	private int cancel_time;
	private String expressCode;
	private String isUrgency;
	
	public Order_info()
	{
		;
	}
	
	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public String getOrder_sn() {
		return order_sn;
	}

	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}

	public Double getOrder_price() {
		return order_price;
	}

	public void setOrder_price(Double order_price) {
		this.order_price = order_price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getTotal_weight() {
		return total_weight;
	}

	public void setTotal_weight(Double total_weight) {
		this.total_weight = total_weight;
	}

	public String getSignature_characters() {
		return signature_characters;
	}

	public void setSignature_characters(String signature_characters) {
		this.signature_characters = signature_characters;
	}

	public int getAdd_time() {
		return add_time;
	}

	public void setAdd_time(int add_time) {
		this.add_time = add_time;
	}

	public int getPay_time() {
		return pay_time;
	}

	public void setPay_time(int pay_time) {
		this.pay_time = pay_time;
	}

	public int getMake_time() {
		return make_time;
	}

	public void setMake_time(int make_time) {
		this.make_time = make_time;
	}

	public int getShipped_time() {
		return shipped_time;
	}

	public void setShipped_time(int shipped_time) {
		this.shipped_time = shipped_time;
	}

	public int getReceive_time() {
		return receive_time;
	}

	public void setReceive_time(int receive_time) {
		this.receive_time = receive_time;
	}

	public int getCancel_time() {
		return cancel_time;
	}

	public void setCancel_time(int cancel_time) {
		this.cancel_time = cancel_time;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getIsUrgency() {
		return isUrgency;
	}

	public void setIsUrgency(String isUrgency) {
		this.isUrgency = isUrgency;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

}
