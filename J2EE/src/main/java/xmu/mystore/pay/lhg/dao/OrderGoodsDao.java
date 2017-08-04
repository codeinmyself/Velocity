package xmu.mystore.pay.lhg.dao;

import xmu.mystore.pay.lhg.model.OrderGoods;

public interface OrderGoodsDao {

    public void add(OrderGoods orderGoods);

    public void delete(OrderGoods orderGoods);

    public OrderGoods select(OrderGoods orderGoods);

}
