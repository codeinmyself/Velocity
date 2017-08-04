package xmu.mall.usercenter.ly.mapper;

import java.util.List;
import xmu.mall.usercenter.ly.model.User_collect_goods;

public interface User_collect_goodsMapper
{
	public List<User_collect_goods> getCollectListByUserId(long user_id);
}
