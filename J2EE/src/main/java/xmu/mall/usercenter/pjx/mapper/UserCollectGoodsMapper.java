package xmu.mall.usercenter.pjx.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import xmu.mall.usercenter.pjx.model.User_collect_goods;

@Component
public interface UserCollectGoodsMapper {

	public void delete(User_collect_goods user_collect_goods);
	
	public List<User_collect_goods> getAllCollectionsByUserID(long user_id);

}
