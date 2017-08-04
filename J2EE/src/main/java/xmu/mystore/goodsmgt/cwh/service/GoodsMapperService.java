package xmu.mystore.goodsmgt.cwh.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.cwh.dao.GoodsDao;
import xmu.mystore.goodsmgt.cwh.dao.Goods_BrandDao;
import xmu.mystore.goodsmgt.cwh.dao.Goods_CategoryDao;
import xmu.mystore.goodsmgt.cwh.dao.Goods_StandDao;
import xmu.mystore.goodsmgt.cwh.model.Goods;
import xmu.mystore.goodsmgt.cwh.model.Goods_Brand;
import xmu.mystore.goodsmgt.cwh.model.Goods_Category;
import xmu.mystore.goodsmgt.cwh.model.Goods_Stand;

@Service("GoodsMapperService")  
@Transactional
public class GoodsMapperService implements IGoodsMapper {

	@Autowired
	private GoodsDao gdao;
	@Autowired
	private Goods_BrandDao gbdao;
	@Autowired
	private Goods_CategoryDao gcdao;
	@Autowired
	private Goods_StandDao gsdao;
	
	@Override
	public Goods getGoodsByGoodsCode(String serial_code) {
		return gdao.getGoodsByGoodsCode(serial_code);
	}

	@Override
	public List<Goods> getGoodsByName(String goods_name) {
		return gdao.getGoodsByName(goods_name);
	}

	@Override
	public List<Goods> getGoodsBy(Map<String, String> map) {
		return gdao.getGoodsBy(map);
	}

	@Override
	public List<Goods_Category> getCategoryList() {
		return gcdao.getAll();
	}

	@Override
	public List<Goods_Brand> getBrandList() {
		return gbdao.getAll();
	}

	@Override
	public Goods_Stand getGoodsPrice(Long goods_id) {
		return gsdao.getStandByGoodsId(goods_id);
	}

}
