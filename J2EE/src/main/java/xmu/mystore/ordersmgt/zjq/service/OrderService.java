package xmu.mystore.ordersmgt.zjq.service;

import xmu.mystore.ordersmgt.zjq.model.Order_info;

import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */
public interface OrderService {
    public String createOrder_sn();
    public List<Order_info> getOrderByUserId(long user_id);
    public List<Order_info> getOrderByStatus(long user_id,int status);
    public void receiveOrder(long order_id);
    public void cancelOrder(long order_id);
}
