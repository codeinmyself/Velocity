package xmu.mall.usercenter.cmy.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.cmy.entity.Goods;
import xmu.mall.usercenter.cmy.entity.User;
import xmu.mall.usercenter.cmy.mapper.Goods2Mapper;
import xmu.mall.usercenter.cmy.mapper.User2Mapper;
import xmu.mall.usercenter.cmy.service.Goods2Service;
import xmu.mall.usercenter.cmy.service.User2Service;

@Service
@Transactional(rollbackFor = Exception.class)
public class Goods2ServiceImpl implements Goods2Service{
	@Autowired (required=false) 
	private Goods2Mapper goodsMapper;
	
	@Override
	public List<Goods> getGoodsByUserId(@Param("user_id")long user_id) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsByUserId(user_id);
	}


}
