package xmu.mystore.pay.liulei.service;

import xmu.mystore.pay.liulei.model.OrderInfo;

public interface OrderInfoService {

	public void addAOrderInfo(OrderInfo orderInfo);
	
	public OrderInfo getOrderInfo(long id);
	
	public void setOrderStatus(int order_status, long order_id);
}
