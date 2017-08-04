package xmu.mystore.goodsmgt.cwh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import xmu.mystore.goodsmgt.cwh.service.GoodsExist;

@Entity
@Table(name = "goods")
@DynamicUpdate(true)
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "goods_id", nullable = false)
	private Long id; // 商品id

	@Column(name = "goods_name", nullable = false, unique = true)
	@Pattern(regexp = "[\\S]{1,20}", message = "{valid.name}")
	private String name; // 商品名(1-20个字，不能有空白字符)

	@Column(name = "goods_serial_code", nullable = false)
	@GoodsExist(min = 1, max = 10, message = "{valid.serial_code}")
	private String serial_code; // 商品编码

	@Column(name = "goods_weight")
	@NotNull(message = "{valid.weight.null}")
	@DecimalMin(value = "0.00", message = "{valid.weight}")
	private Double weight;// 商品重量

	@Column(name = "goods_stock_count")
	@NotNull(message = "{valid.stock_count.null}")
	@Min(value = 0, message = "{valid.stock_count}")
	private Integer stock_count;// 商品库存

	@Column(name = "goods_pre_sale_number")
	@NotNull(message = "{valid.pre_sale_number.null}")
	@Min(value = 0, message = "{valid.pre_sale_number}")
	private Integer pre_sale_number;// 商品预售数量

	@Column(name = "goods_store_id")
	private String store_id;// 商店id

	@Column(name = "goods_mid_user_price")
	@NotNull(message = "{valid.mid_user_price.null}")
	@DecimalMin(value = "0.00", message = "{valid.mid_user_price}")
	private Double mid_user_price;// 中介价格

	@Column(name = "goods_market_price")
	@NotNull(message = "{valid.market_price.null}")
	@DecimalMin(value = "0.00", message = "{valid.market_price}")
	private Double market_price;// 市场价格

	@Column(name = "goods_real_price")
	@NotNull(message = "{valid.real_price.null}")
	@DecimalMin(value = "0.00", message = "{valid.real_price}")
	private Double real_price;// 真实价格

	@Column(name = "goods_redeem_point")
	private Integer redeem_point;// 商品积分

	@JoinColumn(name = "goods_category_id", referencedColumnName = "goods_category_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Goods_Category category;// 品类

	@JoinColumn(name = "goods_brand_id", referencedColumnName = "goods_brand_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Goods_Brand brand;// 品牌

	@OneToOne
	@JoinColumn(name = "goods_stand_id")
	private Goods_Stand stand;// 上下架

	@Column(name = "goods_add_time")
	private String add_time;// 增加商品时间

	@Column(name = "goods_last_modified_time")
	private String last_modified_time;// 最后修改商品信息时间

	@Column(name = "goods_description")
	private String description;// 商品描述

	@Column(name = "goods_image_path")
	private String image_path;// 商品图片

	@Column(name = "goods_is_dividable")
	private Boolean is_dividable;// 是否允许分单

	@Column(name = "goods_default_express")
	private String default_express;// 默认快递

	@Column(name = "goods_signal")
	private String signal;// 签名

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getStock_count() {
		return stock_count;
	}

	public void setStock_count(Integer stock_count) {
		this.stock_count = stock_count;
	}

	public Integer getPre_sale_number() {
		return pre_sale_number;
	}

	public void setPre_sale_number(Integer pre_sale_number) {
		this.pre_sale_number = pre_sale_number;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public Double getMid_user_price() {
		return mid_user_price;
	}

	public void setMid_user_price(Double mid_user_price) {
		this.mid_user_price = mid_user_price;
	}

	public Double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	public Double getReal_price() {
		return real_price;
	}

	public void setReal_price(Double real_price) {
		this.real_price = real_price;
	}

	public Integer getRedeem_point() {
		return redeem_point;
	}

	public void setRedeem_point(Integer redeem_point) {
		this.redeem_point = redeem_point;
	}

	public Goods_Category getCategory() {
		return category;
	}

	public void setCategory(Goods_Category category) {
		this.category = category;
	}

	public Goods_Brand getBrand() {
		return brand;
	}

	public void setBrand(Goods_Brand brand) {
		this.brand = brand;
	}

	public Goods_Stand getStand() {
		return stand;
	}

	public void setStand(Goods_Stand stand) {
		this.stand = stand;
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

	public Boolean getIs_dividable() {
		return is_dividable;
	}

	public void setIs_dividable(Boolean is_dividable) {
		this.is_dividable = is_dividable;
	}

	public String getDefault_express() {
		return default_express;
	}

	public void setDefault_express(String default_express) {
		this.default_express = default_express;
	}

	public String getSignal() {
		return signal;
	}

	public void setSignal(String signal) {
		this.signal = signal;
	}

	public String toString() {
		return "id:" + id + "\n" + "name:" + name + "\n" + "serial_code:" + serial_code + "\n" + "weight:" + weight
				+ "\n" + "pre_sale_number:" +pre_sale_number+"\n"+
						 "real_price"+real_price+"\n"+".....\n";
	}
}
