package xmu.mystore.ordersmgt.zyd.entities;

import java.util.List;

public class Order {
	long id;
	String time;
	String consignee;
	String address;
	String phone;
	double total;
	long userId; 
	int state;
	String remark;
	String awb;
	String isUrgency;
	String order_sn;
	String shipped_time;
	String goods;
	List<Goods> goodslist;
	
	public List<Goods> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(List<Goods> goodslist) {
		this.goodslist = goodslist;
	}
	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getShipped_time() {
		return shipped_time;
	}

	public void setShipped_time(String shipped_time) {
		this.shipped_time = shipped_time;
	}

	public String getOrder_sn() {
		return order_sn;
	}

	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}

	public String getIsUrgency() {
		return isUrgency;
	}

	public void setIsUrgency(String isUrgency) {
		this.isUrgency = isUrgency;
	}

	public Order(long id, String time, String consignee, String address,
			String phone, double total, long userId, int state,
			String remark, String awb,String isUrgency) {
		super();
		this.id = id;
		this.time = time;
		this.consignee = consignee;
		this.address = address;
		this.phone = phone;
		this.total = total;
		this.userId = userId;
		this.state = state;
		this.remark = remark;
		this.awb = awb;
		this.isUrgency=isUrgency;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAwb() {
		return awb;
	}

	public void setAwb(String awb) {
		this.awb = awb;
	}

	public Order(){
		
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
	
}
