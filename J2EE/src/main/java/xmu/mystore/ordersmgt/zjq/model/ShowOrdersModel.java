package xmu.mystore.ordersmgt.zjq.model;

/**
 * Created by Administrator on 2017/5/21.
 */
public class ShowOrdersModel {
    private String order_sn;      //订单编号
    private String name;          //商品名称
    private String add_time;        //下单时间
    private String consignee;    //收货人
    private String user_name;   //用户名
    private double order_price;//总价
    private String isUrgency;   //是否加急
    private String remark;      //备注
    private long user_id;     //用户ID
    private long order_id;      //订单id
    private String order_status;   //订单状态
    private String shipped_time;   //发货时间
    private String expressCode;     //快递单号
    public ShowOrdersModel() {
    }

    public ShowOrdersModel(String order_sn, String name, String add_time, String consignee, String user_name, double order_price,
                           String isUrgency, String remark, long user_id, long order_id, String order_status, String shipped_time, String expressCode) {
        this.order_sn = order_sn;
        this.name = name;
        this.add_time = add_time;
        this.consignee = consignee;
        this.user_name = user_name;
        this.order_price = order_price;
        this.isUrgency = isUrgency;
        this.remark = remark;
        this.user_id = user_id;
        this.order_id = order_id;
        this.order_status = order_status;
        this.shipped_time = shipped_time;
        this.expressCode = expressCode;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public String getName() {
        return name;
    }

    public String getAdd_time() {
        return add_time;
    }

    public String getConsignee() {
        return consignee;
    }

    public String getUser_name() {
        return user_name;
    }

    public double getOrder_price() {
        return order_price;
    }

    public String getIsUrgency() {
        return isUrgency;
    }

    public String getRemark() {
        return remark;
    }

    public long getUser_id() {
        return user_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public String getShipped_time() {
        return shipped_time;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public void setIsUrgency(String isUrgency) {
        this.isUrgency = isUrgency;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public void setShipped_time(String shipped_time) {
        this.shipped_time = shipped_time;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
}
