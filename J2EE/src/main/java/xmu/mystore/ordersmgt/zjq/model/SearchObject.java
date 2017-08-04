package xmu.mystore.ordersmgt.zjq.model;

/**
 * Created by Administrator on 2017/5/23.
 */
public class SearchObject {
    private String ordersn;
    private String goodsname;
    private int addtimebegin;
    private int addtimeend;
    private String consignee;
    private String isUrgency;
    private int orderstatus;

    public SearchObject() {
    }

    public SearchObject(String ordersn, String goodsname, int addtimebegin, int addtimeend, String consignee, String isUrgency, int orderstatus) {
        this.ordersn = ordersn;
        this.goodsname = goodsname;
        this.addtimebegin = addtimebegin;
        this.addtimeend = addtimeend;
        this.consignee = consignee;
        this.isUrgency = isUrgency;
        this.orderstatus = orderstatus;
    }

    public String getordersn() {
        return ordersn;
    }

    public String getgoodsname() {
        return goodsname;
    }

    public int getaddtimebegin() {
        return addtimebegin;
    }

    public int getaddtimeend() {
        return addtimeend;
    }

    public String getConsignee() {
        return consignee;
    }

    public String getIsUrgency() {
        return isUrgency;
    }

    public int getorderstatus() {
        return orderstatus;
    }

    public void setordersn(String ordersn) {
        this.ordersn = ordersn;
    }

    public void setgoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setaddtimebegin(int addtimebegin) {
        this.addtimebegin = addtimebegin;
    }

    public void setaddtimeend(int addtimeend) {
        this.addtimeend = addtimeend;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public void setIsUrgency(String isUrgency) {
        this.isUrgency = isUrgency;
    }

    public void setorderstatus(int orderstatus) {
        this.orderstatus = orderstatus;
    }
}
