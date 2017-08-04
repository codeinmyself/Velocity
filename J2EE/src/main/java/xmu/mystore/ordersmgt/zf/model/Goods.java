package xmu.mystore.ordersmgt.zf.model;

import java.io.Serializable;

public class Goods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6644434760198003107L;
	
	private long id;                 	//商品id
	private String name;		 		//商品名
	private String serial_code;      	//商品编码
	private double weight;		 		//商品重量
	private int stock_count;			//商品库存
	private int pre_sale_number;		//预售数量
	private String store_id;			//商店id
	private double mid_user_price;	 	//中介价格
	private double market_price;		//市场价格
	private double real_price;			//真实价格
	private int redeem_point; 	 		//商品积分
	private int category_id;			//品类id
	private int brand_id;				//品牌id
	private int Stand_id;       	    //上下架id
	private String add_time;		 	//增加商品时间
	private String last_modified_time;	//最后修改商品信息时间
	private String description;	 		//商品描述
	private String image_path;			//商品图片
	private int is_dividable;			//是否允许分单
	private String default_express;  	//默认快递
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSerial_code() {
		return serial_code;
	}
	public void setSerial_code(String serial_code) {
		this.serial_code = serial_code;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getStock_count() {
		return stock_count;
	}
	public void setStock_count(int stock_count) {
		this.stock_count = stock_count;
	}
	public int getPre_sale_number() {
		return pre_sale_number;
	}
	public void setPre_sale_number(int pre_sale_number) {
		this.pre_sale_number = pre_sale_number;
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public double getMid_user_price() {
		return mid_user_price;
	}
	public void setMid_user_price(double mid_user_price) {
		this.mid_user_price = mid_user_price;
	}
	public double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}
	public double getReal_price() {
		return real_price;
	}
	public void setReal_price(double real_price) {
		this.real_price = real_price;
	}
	public int getRedeem_point() {
		return redeem_point;
	}
	public void setRedeem_point(int redeem_point) {
		this.redeem_point = redeem_point;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public int getStand_id() {
		return Stand_id;
	}
	public void setStand_id(int stand_id) {
		Stand_id = stand_id;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public String getLast_modified_time() {
		return last_modified_time;
	}
	public void setLast_modified_time(String last_modified_time) {
		this.last_modified_time = last_modified_time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public int getIs_dividable() {
		return is_dividable;
	}
	public void setIs_dividable(int is_dividable) {
		this.is_dividable = is_dividable;
	}
	public String getDefault_express() {
		return default_express;
	}
	public void setDefault_express(String default_express) {
		this.default_express = default_express;
	}

}
