package xmu.mall.usercenter.lxq.mapper;

import xmu.mall.usercenter.lxq.model.UserCollectGoods;

public interface CollectMapper {

	UserCollectGoods selectCollectByGoodsIdAndUserId(long goodsId, long userId);

}
