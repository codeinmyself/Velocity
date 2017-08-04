package xmu.mall.usercenter.pjx.model;

import java.util.List;
import xmu.mall.usercenter.pjx.model.Goods;
import xmu.mystore.ordersmgt.tangkai.model.OrderGoods;

public class Show_OrderItem
{
	private long order_id;
	private String order_sn;
	private long user_id;
	private String order_status;
	private Double order_price;
	private String brand_name;
	private List<OrderGoods> GoodsList;
	
	public Show_OrderItem()
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

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public void setOrder_status(int order_status) {
		if(order_status == 0)
			this.order_status = "未付款";
		if(order_status == 1)
			this.order_status = "已付款";
		if(order_status == 2)
			this.order_status = "定制中";
		if(order_status == 3)
			this.order_status = "已发货";
		if(order_status == 4)
			this.order_status = "已收货";
		if(order_status == 5)
			this.order_status = "取消";
	}
	
	public Double getOrder_price() {
		return order_price;
	}

	public void setOrder_price(Double order_price) {
		this.order_price = order_price;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public List<OrderGoods> getGoodsList() {
		return GoodsList;
	}

	public void setGoodsList(List<OrderGoods> goodsList) {
		GoodsList = goodsList;
	}

	

}
