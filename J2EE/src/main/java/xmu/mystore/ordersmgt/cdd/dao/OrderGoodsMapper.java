package xmu.mystore.ordersmgt.cdd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.cdd.model.Order;
import xmu.mystore.ordersmgt.cdd.model.OrderGoods;

//@Repository用于标注数据访问组件，即DAO组件；
@Repository
public interface OrderGoodsMapper {
	public List<OrderGoods> getAllGoodsByOrderId(long order_id);
}
