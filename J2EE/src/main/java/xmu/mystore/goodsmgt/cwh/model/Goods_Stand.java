package xmu.mystore.goodsmgt.cwh.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

import org.hibernate.annotations.DynamicUpdate;

import xmu.mystore.goodsmgt.cwh.service.StringFuture;

@Entity
@Table(name="goods_stand")
@DynamicUpdate(true)
public class Goods_Stand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="goods_stand_id")
	private Long id;//上下架id
	
	@OneToOne
	@JoinColumn(name="goods_stand_goods_id")
	private Goods goods;//商品
	
	@Column(name="goods_stand_mid_user_price")
	private Double mid_user_price;//中介价格
	
	@Column(name="goods_stand_market_price")
	private Double market_price;//市场价格
	
	@Column(name="goods_stand_real_price")
	private Double real_price;//真实价格
	
	@Column(name="goods_stand_on_market_time",columnDefinition="varchar(20) default '0000-00-00 00:00:00'")
	@StringFuture(message="{valid.on_market_time}")
	private String on_market_time;//上架时间
	
	@Column(name="goods_stand_off_market_time",columnDefinition="varchar(20) default '0000-00-00 00:00:00'")
	@StringFuture(message="{valid.off_market_time}")
	private String off_market_time;//下架时间
	
	@Column(name="goods_stand_pre_sale_count",columnDefinition="int default 0")
	@Min(value=0,message="{valid.pre_sale_count}")
	private Integer pre_sale_count;//预售数量
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
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
	public String getOn_market_time() {
		return on_market_time;
	}
	public void setOn_market_time(String on_market_time) {
		this.on_market_time = on_market_time;
	}
	public String getOff_market_time() {
		return off_market_time;
	}
	public void setOff_market_time(String off_market_time) {
		this.off_market_time = off_market_time;
	}
	public Integer getPre_sale_count() {
		return pre_sale_count;
	}
	public void setPre_sale_count(Integer pre_sale_count) {
		this.pre_sale_count = pre_sale_count;
	}
	
	public String toString(){
		return "id:"+id+"\n"+
				"mid_user_price:"+mid_user_price+"\n"+
				"market_price:"+market_price+"\n"+
				"real_price:"+real_price+"\n"+
				".....\n";
	}
}
