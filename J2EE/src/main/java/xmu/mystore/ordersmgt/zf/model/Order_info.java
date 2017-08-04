package xmu.mystore.ordersmgt.zf.model;

import java.io.Serializable;
import java.util.List;

public class Order_info implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3000882034340000296L;
		
	private long order_id; 				//订单ID
	private String order_sn;			//订单编号
	private Users user;  				//用户
	private int order_status;   		//订单状态（0：未付款；1：已付款；2：定制中；3：已发货；4：已收货；5：取消）
	private String consignee;   		//收货人
	private String address;     		//地址
	private String zipcode;    			//邮编
	private String telephone;   		//电话
	private String email;      		 	//邮箱
	private List<Order_goods> goods;	//订单商品
	private double goods_price; 		//商品总价
	private double order_price; 		//订单总价
	private String remark;      		//备注
	private double total_weight; 		//订单总重
	private String signature_characters;//签名编码
	private int add_time;       		//下单时间
	private int pay_time;       		//支付时间
	private int make_time;      		//状态变为定制中的时间
	private int shipped_time;   		//状态变为已发货的时间
	private int receive_time;   		//状态变为已收货的时间
	private int cancel_time;    		//状态变为已取消的时间
	private String expressCode; 		//快递单号
	private String isUrgency;   		//是否加急  （可以用Y/N来表示）
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
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
	public List<Order_goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Order_goods> goods) {
		this.goods = goods;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public double getOrder_price() {
		return order_price;
	}
	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public double getTotal_weight() {
		return total_weight;
	}
	public void setTotal_weight(double total_weight) {
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
	public int getReceive_time() {
		return receive_time;
	}
	public void setReceive_time(int receive_time) {
		this.receive_time = receive_time;
	}

}
