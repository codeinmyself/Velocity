package xmu.mystore.ordersmgt.cdd.service;

import java.util.List;

import xmu.mystore.ordersmgt.cdd.model.OrderGoods;

public interface OrderGoodsService {
	public List<OrderGoods> getAllOrdersByOrderId(long order_id);
}
