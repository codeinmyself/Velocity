package xmu.mall.usercenter.ly.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mall.usercenter.ly.mapper.User_collect_goodsMapper;
import xmu.mall.usercenter.ly.model.User_collect_goods;
import xmu.mall.usercenter.ly.service.User_collect_goodsService;

@Service("User_collect_goodsServiceImpl")
public class User_collect_goodsServiceImpl implements User_collect_goodsService
{
	@Autowired
	private User_collect_goodsMapper user_collect_goodsmapper;
	
	public List<User_collect_goods> getCollectListByUserId(long user_id)
	{
		return user_collect_goodsmapper.getCollectListByUserId(user_id);
	}
}