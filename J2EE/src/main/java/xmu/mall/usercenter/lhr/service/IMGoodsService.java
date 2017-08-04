package xmu.mall.usercenter.lhr.service;

import java.util.List;

import xmu.mystore.goodsmgt.zlt.model.Goods;

public interface IMGoodsService {
	List<Goods> getAllGoodsByOrderId(Long order_id);//根据订单号获取商品对象(详细版)
	List<Goods> getCollectedGoodsByUserId(Long user_id);//根据用户号获取收藏的商品列表(详细版)
	void delectCollectedGoodsByUserIdAndGoodsId(Long user_id,Long goods_id);//根据用户号和商品号删除收藏的商品对象
}
