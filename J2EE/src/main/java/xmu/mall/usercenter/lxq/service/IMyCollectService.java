package xmu.mall.usercenter.lxq.service;

import java.util.List;

import xmu.mall.goodsindex.zjh.model.AjaxReturnResult;
import xmu.mall.usercenter.lxq.model.Goods;
import xmu.mall.usercenter.lxq.model.UserCollectGoods;

public interface IMyCollectService {
	List<Goods> getGoodsListByUserId(Long id);

	AjaxReturnResult deleteCollectByGoodsId(Long id);

	int addCollectByGoodsId(long id);

	UserCollectGoods hasCollection(long goodsId, long userId);
}
