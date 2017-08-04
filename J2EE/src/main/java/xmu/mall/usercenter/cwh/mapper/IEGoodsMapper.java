package xmu.mall.usercenter.cwh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xmu.mystore.goodsmgt.zlt.model.Goods;

@Repository
public interface IEGoodsMapper {
	List<Goods> getAllGoodsByOrderId(Long order_id);//根据订单号获取商品对象(详细版)
	List<Goods> getCollectedGoodsByUserId(Long user_id);//根据用户号获取收藏的商品列表(详细版)
	void delectCollectedGoodsByUserIdAndGoodsId(@Param("user_id")Long user_id,@Param("goods_id")Long goods_id);//根据用户号和商品号删除收藏的商品对象
}
