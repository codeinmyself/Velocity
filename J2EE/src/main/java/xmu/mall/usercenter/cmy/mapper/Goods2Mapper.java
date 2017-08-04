package xmu.mall.usercenter.cmy.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xmu.mall.usercenter.cmy.entity.Goods;
import xmu.mall.usercenter.cmy.entity.User;

@Repository
public interface Goods2Mapper {
	
	public List<Goods> getGoodsByUserId(@Param("user_id")long user_id);

}
