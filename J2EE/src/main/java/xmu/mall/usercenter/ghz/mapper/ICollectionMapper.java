package xmu.mall.usercenter.ghz.mapper;

import java.util.List;

import xmu.mystore.ordersmgt.zf.model.Goods;

public interface ICollectionMapper {
	
	public List<Goods> getUserCollection(int user_id);
	
}
