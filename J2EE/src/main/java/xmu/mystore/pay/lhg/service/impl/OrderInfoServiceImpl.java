package xmu.mystore.pay.lhg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.mystore.pay.lhg.dao.OrderInfoDao;
import xmu.mystore.pay.lhg.model.OrderInfo;
import xmu.mystore.pay.lhg.service.OrderInfoService;

@Service("OrderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Override
    public void addOrderInfo(OrderInfo orderInfo) {
        orderInfoDao.add(orderInfo);
    }
}