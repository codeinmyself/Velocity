package xmu.mystore.ordersmgt.zf.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mystore.ordersmgt.zf.model.Order_goods;


@Component
public interface Order_goodsMapper {
	
	// 根据订单号获取该订单商品信息
	public List<Order_goods> get(long id);
}
