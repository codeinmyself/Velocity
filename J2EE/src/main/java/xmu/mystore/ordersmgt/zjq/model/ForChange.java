package xmu.mystore.ordersmgt.zjq.model;

/**
 * Created by Administrator on 2017/5/23.
 */
public class ForChange {
    private String order_id;
    private int status;

    public ForChange() {
    }

    public ForChange(String order_id, int status) {
        this.order_id = order_id;
        this.status = status;
    }

    public String getOrder_id() {
        return order_id;
    }

    public int getStatus() {
        return status;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
