package xmu.mystore.ordermgt.lhr.service;

import java.util.List;

import xmu.mystore.ordermgt.lhr.model.OrderGoods;

public interface OrderGoodsService
{
	public List<OrderGoods> getAllOrdersByOrderId(long order_id);
}
