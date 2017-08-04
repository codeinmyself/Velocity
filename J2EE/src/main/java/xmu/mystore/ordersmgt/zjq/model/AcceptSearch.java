package xmu.mystore.ordersmgt.zjq.model;

/**
 * Created by Administrator on 2017/5/23.
 */
public class AcceptSearch {
    private String ordersn;
    private String goodsname;
    private String addtimebegin;
    private String addtimeend;
    private String consignee;
    private String isUrgency;
    private String orderstatus;

    public AcceptSearch() {
    }

    public AcceptSearch(String ordersn, String goodsname, String addtimebegin, String addtimeend, String consignee, String isUrgency, String orderstatus) {
        this.ordersn = ordersn;
        this.goodsname = goodsname;
        this.addtimebegin = addtimebegin;
        this.addtimeend = addtimeend;
        this.consignee = consignee;
        this.isUrgency = isUrgency;
        this.orderstatus = orderstatus;
    }

    public String getOrdersn() {
        return ordersn;
    }

    public String getgoodsname() {
        return goodsname;
    }

    public String getAddtimebegin() {
        return addtimebegin;
    }

    public String getAddtimeend() {
        return addtimeend;
    }

    public String getConsignee() {
        return consignee;
    }

    public String getIsUrgency() {
        return isUrgency;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn;
    }

    public void setgoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setAddtimebegin(String addtimebegin) {
        this.addtimebegin = addtimebegin;
    }

    public void setAddtimeend(String addtimeend) {
        this.addtimeend = addtimeend;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public void setIsUrgency(String isUrgency) {
        this.isUrgency = isUrgency;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }
}
