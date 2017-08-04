package xmu.mall.usercenter.lxq.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mall.usercenter.lxq.model.Goods;
import xmu.mall.usercenter.lxq.model.UserCollectGoods;

@Component
public interface MyCollectMapper {

	List<Goods> getGoodsListByUserId(Long id);

	int deleteCollectByGoodsId(Long id);

	int addCollectByGoodsId(Long id);

	UserCollectGoods hasCollection(Long goodsId, Long id);

}
