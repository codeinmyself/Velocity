package xmu.mystore.ordersmgt.cmy.service;

import java.util.List;

import xmu.mystore.ordersmgt.cmy.entity.OrderGoods;

public interface OrderGoodsService {
	public List<OrderGoods> getAllOrdersByOrderId(long order_id);
}
