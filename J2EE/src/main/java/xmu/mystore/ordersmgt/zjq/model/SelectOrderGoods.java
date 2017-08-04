package xmu.mystore.ordersmgt.zjq.model;

/**
 * Created by Administrator on 2017/5/22.
 */
public class SelectOrderGoods {
    private long order_id;
    private long goods_id;

    public SelectOrderGoods() {
    }

    public SelectOrderGoods(long order_id, long goods_id) {
        this.order_id = order_id;
        this.goods_id = goods_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public long getGoods_id() {
        return goods_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public void setGoods_id(long goods_id) {
        this.goods_id = goods_id;
    }
}
