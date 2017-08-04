package xmu.mystore.goodsmgt.cwh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.cwh.dao.Goods_BrandDao;
import xmu.mystore.goodsmgt.cwh.model.Goods_Brand;

@Service("Goods_BrandService")
@Transactional
public class Goods_BrandService {

	@Autowired
	private Goods_BrandDao gbdao;

	public void addGoods_Brand(Goods_Brand brand) {//添加商品品牌
		String website = "http://"+brand.getWebsite();
		brand.setWebsite(website);
		gbdao.save(brand);
	}

	public void editGoods_Brand(Goods_Brand brand) {//修改商品品牌
		gbdao.update(brand);
	}
}
