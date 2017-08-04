package xmu.mall.usercenter.cmy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xmu.mall.usercenter.cmy.entity.Goods;
import xmu.mall.usercenter.cmy.entity.User;

public interface Goods2Service {
	public List<Goods> getGoodsByUserId(@Param("user_id")long user_id);
}
