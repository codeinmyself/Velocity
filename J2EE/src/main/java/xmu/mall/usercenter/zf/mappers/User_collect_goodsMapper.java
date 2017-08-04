package xmu.mall.usercenter.zf.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zf.model.User_collect_goods;

/**
 * Created by 63520 on 2017/5/26.
 */
@Component
public interface User_collect_goodsMapper {
	public List<User_collect_goods> getCollectionsByUserId(long id);

	public void deleteById(long cid);
	
}
