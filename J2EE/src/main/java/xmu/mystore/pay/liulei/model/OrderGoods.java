package xmu.mystore.pay.liulei.model;

public class OrderGoods {
	long id; // 主码
	long order_id; // 订单ID
	long goods_id; // 商品ID
	String goods_name; // 商品名称
	int goods_number; // 商品数量
	Double goods_price; // 商品单价

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(long goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}

	public Double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}

	@Override
	public String toString() {
		return "Order_goods [id=" + id + ", order_id=" + order_id + ", goods_id=" + goods_id + ", goods_name="
				+ goods_name + ", goods_number=" + goods_number + ", goods_price=" + goods_price + "]";
	}

}
