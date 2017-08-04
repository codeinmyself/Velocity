package xmu.mall.usercenter.ljd.service;

import java.util.List;

import xmu.mall.usercenter.ljd.model.Goods;
import xmu.mall.usercenter.ljd.model.User_collect_goods;

public interface UserCollectGoodsService {

	public boolean delete(User_collect_goods user_collect_goods);
	
	public List<User_collect_goods> getAllCollectionsByUserID(long user_id);
	
}
