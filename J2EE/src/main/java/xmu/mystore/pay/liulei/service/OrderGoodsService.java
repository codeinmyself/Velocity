package xmu.mystore.pay.liulei.service;

import java.util.List;

import xmu.mystore.pay.liulei.model.OrderGoods;

public interface OrderGoodsService {
	
	public OrderGoods addAOrderGoods(OrderGoods orderGoods);
	
	public void deleteAOrderGoods(OrderGoods orderGoods);
	
	public List<OrderGoods> getOrderGoods(long order_id);

}
