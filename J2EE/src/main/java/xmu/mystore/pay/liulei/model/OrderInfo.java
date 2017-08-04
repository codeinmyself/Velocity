package xmu.mystore.pay.liulei.model;

public class OrderInfo {
	long order_id; // 订单ID
	String order_sn;// 订单编号
	long user_id; // 用户ID
	int order_status; // 订单状态（0：未付款；1：已付款；2：定制中；3：已发货；4：已收货；5：取消）
	String consignee; // 收货人
	long address_id; // 地址
	String zipcode; // 邮编
	String telephone; // 电话
	String email; // 邮箱
	Double goods_price; // 商品总价
	Double order_price; // 订单总价
	String remark; // 备注
	Double total_weight; // 订单总重
	String signature_characters; // 签名编码（【有问题可以问曹将将】）
	int add_time; // 下单时间（用int类型来保存时间戳）
	int pay_time; // 支付时间
	int make_time; // 状态变为定制中的时间
	int shipped_time; // 状态变为已发货的时间
	int receive_time; // 状态变为已收货的时间
	int cancel_time; // 状态变为已取消的时间
	String expressCode; // 快递单号
	String isUrgency; // 是否加急 （可以用Y/N来表示）
						// 原本还有一个字段是显示订单来源平台的，经过讨论把这个字段取消了

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

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
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

	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(long address_id) {
		this.address_id = address_id;
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

	@Override
	public String toString() {
		return "OrderInfo [order_id=" + order_id + ", order_sn=" + order_sn + ", user_id=" + user_id + ", order_status="
				+ order_status + ", consignee=" + consignee + ", address_id=" + address_id + ", zipcode=" + zipcode
				+ ", telephone=" + telephone + ", email=" + email + ", goods_price=" + goods_price + ", order_price="
				+ order_price + ", remark=" + remark + ", total_weight=" + total_weight + ", signature_characters="
				+ signature_characters + ", add_time=" + add_time + ", pay_time=" + pay_time + ", make_time="
				+ make_time + ", shipped_time=" + shipped_time + ", receive_time=" + receive_time + ", cancel_time="
				+ cancel_time + ", expressCode=" + expressCode + ", isUrgency=" + isUrgency + "]";
	}

}
