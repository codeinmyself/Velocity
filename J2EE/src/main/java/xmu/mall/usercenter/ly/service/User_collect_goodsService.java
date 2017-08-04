package xmu.mall.usercenter.ly.service;

import java.util.List;

import xmu.mall.usercenter.ly.model.User_collect_goods;

public interface User_collect_goodsService
{
	public List<User_collect_goods> getCollectListByUserId(long user_id);
}
