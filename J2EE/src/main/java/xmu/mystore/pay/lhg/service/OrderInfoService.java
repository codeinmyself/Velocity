package xmu.mystore.pay.lhg.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xmu.mystore.pay.lhg.model.OrderInfo;
@Mapper
public interface OrderInfoService {
    void addOrderInfo(@Param("pojo") OrderInfo orderInfo);
}
