package xmu.mystore.ordersmgt.lhr.service;

import java.util.List;

import xmu.mystore.ordersmgt.lhr.model.OrderGoods;

public interface OrderGoodsService
{
	public List<OrderGoods> getAllOrdersByOrderId(long order_id);
}
