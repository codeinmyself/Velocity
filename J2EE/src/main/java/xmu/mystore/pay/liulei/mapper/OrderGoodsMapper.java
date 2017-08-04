package xmu.mystore.pay.liulei.mapper;

import java.util.List;

import org.springframework.stereotype.Component;


import xmu.mystore.pay.liulei.model.OrderGoods;

@Component
public interface OrderGoodsMapper {

	public void add(OrderGoods orderGoods);

	public void delete(OrderGoods orderGoods);

	public List<OrderGoods> selectByOrderId(long order_id);

}
