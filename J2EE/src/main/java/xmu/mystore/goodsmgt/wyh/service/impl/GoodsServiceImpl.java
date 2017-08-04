package xmu.mystore.goodsmgt.wyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.wyh.mapper.GoodsMapper;
import xmu.mystore.goodsmgt.wyh.model.Goods;
import xmu.mystore.goodsmgt.wyh.service.GoodsService;


@Service("wyh_GoodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	@Qualifier("wyh_GoodsMapper")
	private GoodsMapper goodsMapper;

	public GoodsMapper getGoodsMapper() {
		return goodsMapper;
	}

	
	public void setGoodsMapper(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}

	
	public Goods getGoodsById(String goodsId) {
		return this.goodsMapper.getGoodsById(goodsId);
	}

	public List<Goods> getAllGoods() {
		return this.goodsMapper.getAllGoods();
	}

	public Goods insertGoods(Goods goods) {
		this.goodsMapper.insertGoods(goods);

		return getGoodsById(String.valueOf(goods.getId()));
	}


	public void updateGoodsNameById(int id) {
		// TODO Auto-generated method stub
		this.goodsMapper.updateGoodsNameById(id);
	}


	public Goods getGoodsByGoodsCode(String serialCode) {
		// TODO Auto-generated method stub
		return this.goodsMapper.getGoodsByGoodsCode(serialCode);
		
	}


	public List<Goods> getGoodsByName(String name) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsByName(name);
	}


	public void updateGoodsById(Goods goods) {
		// TODO Auto-generated method stub
		//goodsMapper.updateGoodsNameById(Integer.valueOf(goodsId));
		
		this.goodsMapper.updateGoodsById(goods);
	}


	public List<Goods> getGoodsByStandAndBrand(int begin, int step, int standId, int brandId) {
		// TODO Auto-generated method stub
		return this.goodsMapper.getGoodsByStandAndBrand(begin, step, standId, brandId);
	}


	public List<Goods> getGoodsByStand(int begin, int step, int standId) {
		// TODO Auto-generated method stub
		return this.goodsMapper.getGoodsByStand(begin, step, standId);
	}


	public List<Goods> getGoodsByBrand(int begin, int step, int brandId) {
		// TODO Auto-generated method stub
		return this.getGoodsByBrand(begin, step, brandId);
	}


	public List<Goods> getGoodsByNumber(int begin, int step) {
		// TODO Auto-generated method stub
		return this.getGoodsByNumber(begin, step);
	}


	@Override
	public void deleteGoodsById(String id) {
		// TODO Auto-generated method stub
		goodsMapper.deleteGoodsById(id);
	}

}