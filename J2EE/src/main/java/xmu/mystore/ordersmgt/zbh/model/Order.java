package xmu.mystore.ordersmgt.zbh.model;

public class Order {

	long orderId; //订单ID
	String orderSn;//订单编号
	long userId;  //用户ID
	int orderStatus;    //订单状态（0：未付款；1：已付款；2：定制中；3：已发货；4：已收货；5：取消）
	String consignee;    //收货人
	String address;      //地址
	String zipcode;     //邮编
	String telephone;   //电话
	String email;       //邮箱
	double goodsPrice; //商品总价
	double orderPrice; //订单总价
	String remark;      //备注
	double totalWeight; //订单总重
	String signatureCharacters;  //签名编码（【有问题可以问曹将将】）
	String addTime;       //下单时间（用int类型来保存时间戳）
	int payTime;       //支付时间
	int makeTime;      //状态变为定制中的时间
	int shippedTime;   //状态变为已发货的时间
	int receiveTime;   //状态变为已收货的时间
	int cancelTime;    //状态变为已取消的时间
	String expressCode; //快递单号
	String isUrgency;   //是否加急  （可以用Y/N来表示）
	//String addTimeToString;
	
	public String getIsUrgency() {
		return isUrgency;
	}

	public void setIsUrgency(String isUrgency) {
		this.isUrgency = isUrgency;
	}
	

	public Order(){
		
	}
	public Order(String orderSn,String addTime,String consignee,int orderStatus,String isUrgency){
		super();
		this.orderSn = orderSn;
		this.addTime = addTime;
		this.consignee = consignee;

		this.orderStatus = orderStatus;

		this.isUrgency = isUrgency;
		
	}
	
	public Order(String orderSn,String addTime,String consignee,String address,String zipcode,String telephone,double orderPrice, 
    		long userId,int orderStatus,String remark,String expressCode,String isUrgency){
		super();
		this.orderSn = orderSn;
		this.addTime = addTime;
		this.consignee = consignee;
		this.address = address;
		this.zipcode = zipcode;
		this.telephone = telephone;
		this.orderPrice = orderPrice;
		this.userId = userId;
		this.orderStatus = orderStatus;
		this.remark = remark;
		this.expressCode = expressCode;
		this.isUrgency = isUrgency;
		
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
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

	public double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public String getSignatureCharacters() {
		return signatureCharacters;
	}

	public void setSignatureCharacters(String signatureCharacters) {
		this.signatureCharacters = signatureCharacters;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public int getPayTime() {
		return payTime;
	}

	public void setPayTime(int payTime) {
		this.payTime = payTime;
	}

	public int getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(int makeTime) {
		this.makeTime = makeTime;
	}

	public int getShippedTime() {
		return shippedTime;
	}

	public void setShippedTime(int shippedTime) {
		this.shippedTime = shippedTime;
	}

	public int getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(int receiveTime) {
		this.receiveTime = receiveTime;
	}

	public int getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(int cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}
/*
	public String getAddTimeToString() {
		return addTimeToString;
	}

	public void setAddTimeToString(String addTimeToString) {
		this.addTimeToString = addTimeToString;
	}
*/
	
}
