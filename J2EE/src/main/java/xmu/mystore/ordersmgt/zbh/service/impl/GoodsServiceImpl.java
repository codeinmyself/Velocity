package xmu.mystore.ordersmgt.zbh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.zbh.mappers.GoodsMapper;
import xmu.mystore.ordersmgt.zbh.model.Goods;
import xmu.mystore.ordersmgt.zbh.service.GoodsService;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl implements GoodsService{
	@Autowired (required=false) 
	private GoodsMapper goodsMapper;
	
	public List<Goods> getGoodsByOrderid(long oid){
		return goodsMapper.getGoodsByOrderid(oid);
	}
}
