package xmu.mystore.pay.lhg.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xmu.mystore.pay.lhg.model.OrderGoods;
@Mapper
public interface OrderGoodsService {

    public OrderGoods addAOrderGoods(@Param("pojo") OrderGoods orderGoods);

    public void deleteAOrderGoods(@Param("pojo") OrderGoods orderGoods);

    public OrderGoods getAOrderGoods(@Param("pojo") OrderGoods orderGoods);

}
