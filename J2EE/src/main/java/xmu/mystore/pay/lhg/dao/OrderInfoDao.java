package xmu.mystore.pay.lhg.dao;

import xmu.mystore.pay.lhg.model.OrderInfo;

import java.util.List;

public interface OrderInfoDao {

    public void add(OrderInfo orderInfo);

    public void delete(OrderInfo orderInfo);

    public void update(OrderInfo orderInfo);

    public OrderInfo select(OrderInfo orderInfo);

    public List<OrderInfo> selectAll();

}
