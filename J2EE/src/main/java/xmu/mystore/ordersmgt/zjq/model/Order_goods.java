package xmu.mystore.ordersmgt.zjq.model;

/**
 * Created by Administrator on 2017/5/20.
 */
public class Order_goods {
    private long id;                //主码
    private long order_id;         //订单ID
    private long goods_id;         //商品ID
    private String goods_name;     //商品名称
    private int goods_number;     //商品数量
    private double goods_price;   //商品单价

    public Order_goods() {
    }

    public Order_goods(long id, long order_id, long goods_id, String goods_name, int goods_number, double goods_price) {
        this.id = id;
        this.order_id = order_id;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_number = goods_number;
        this.goods_price = goods_price;
    }

    public long getId() {
        return id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public long getGoods_id() {
        return goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public int getGoods_number() {
        return goods_number;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public void setGoods_id(long goods_id) {
        this.goods_id = goods_id;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public void setGoods_number(int goods_number) {
        this.goods_number = goods_number;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }
}
