package xmu.mystore.ordersmgt.tangkai.service;

import java.util.List;

import xmu.mystore.ordersmgt.tangkai.model.OrderGoods;

/**
 * @author tangkai
 * @data 2017年6月2日--下午1:19:32
 */
public interface OrderGoodsService {
	public List<OrderGoods> getAllOrdersByOrderId(long order_id);
	public void addOrderGoods(OrderGoods orderGoods);
}
