package xmu.mystore.pay.liulei.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mystore.pay.liulei.model.OrderInfo;

@Component
public interface OrderInfoMapper {

	public void add(OrderInfo orderInfo);

	public void delete(OrderInfo orderInfo);

	public void update(OrderInfo orderInfo);

	public OrderInfo select(OrderInfo orderInfo);

	public List<OrderInfo> selectAll();

	public OrderInfo getOrderInfo(long id);
	
	public void setOrderStatus(int order_status, long order_id);
}
