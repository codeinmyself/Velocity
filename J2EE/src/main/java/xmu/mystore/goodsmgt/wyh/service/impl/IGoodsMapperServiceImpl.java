package xmu.mystore.goodsmgt.wyh.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import xmu.mystore.goodsmgt.wyh.model.Brand;
import xmu.mystore.goodsmgt.wyh.model.Category;
import xmu.mystore.goodsmgt.wyh.model.Goods;
import xmu.mystore.goodsmgt.wyh.model.Stand;
import xmu.mystore.goodsmgt.wyh.service.BrandService;
import xmu.mystore.goodsmgt.wyh.service.CategoryService;
import xmu.mystore.goodsmgt.wyh.service.GoodsService;
import xmu.mystore.goodsmgt.wyh.service.IGoodsMapperService;
import xmu.mystore.goodsmgt.wyh.service.StandService;
import xmu.mystore.goodsmgt.wyh.tool.PreSaleNumberComparator;
import xmu.mystore.goodsmgt.wyh.tool.RealPriceComparator;

public class IGoodsMapperServiceImpl implements IGoodsMapperService {

	public GoodsService goodsService;
	
	public GoodsService getGoodsService() {
		return goodsService;
	}
	
	@Autowired
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public StandService standService;
	
	public BrandService brandService;
	
	public CategoryService categoryService;
	
	public CategoryService getCategoryService() {
		return categoryService;
	}
	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public BrandService getBrandService() {
		return brandService;
	}
	@Autowired
	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}
	public StandService getStandService() {
		return standService;
	}
	@Autowired
	public void setStandService(StandService standService) {
		this.standService = standService;
	}

	public Goods getGoodsByGoodsCode(String serialCode) {
		// TODO Auto-generated method stub
		return goodsService.getGoodsByGoodsCode(serialCode);
	}

	public List<Goods> getGoodsByGoodsName(String goods_name) {
		// TODO Auto-generated method stub
		return goodsService.getGoodsByName(goods_name);
	}

	public List<Goods> getGoodsBy(Map<String, String> array) {
		// TODO Auto-generated method stub
		int sortNumSaleNumber=-1,sortNumRealPrice=-1,brandId=-1,standId=-1;
		int pageNumber=-1,lineNumber=-1;
		Iterator<Map.Entry<String, String>> it = array.entrySet().iterator();
		while (it.hasNext()) {
		            Map.Entry<String, String> entry = it.next();
		            String key=entry.getKey();
		            String value=entry.getValue();
		            if(key.equals("pre_sale_number")){
		            	if(value.equals("0"))
		            		sortNumSaleNumber=0;
		            	else 
		            		sortNumSaleNumber=1;
		            }else if(key.equals("brand_id")){
		            	brandId=Integer.valueOf(value);
		            }else if(key.equals("stand_id")){
		            	standId=Integer.valueOf(value);
		            }else if(key.equals("real_price")){
		            	if(value.equals("0"))
		            		sortNumRealPrice=0;
		            	else 
		            		sortNumRealPrice=1;
		            }else if(key.equals("no")){
		            	pageNumber=Integer.valueOf(value);
		            }else if(key.equals("size")){
		            	lineNumber=Integer.valueOf(value);
		            }
		            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		         }
		int chooseNumber=10*(pageNumber-1);
		List<Goods> temp=null;
		if(brandId!=-1&&standId!=-1){
			temp=goodsService.getGoodsByStandAndBrand(chooseNumber, lineNumber, standId, brandId);
		}else{
			if(brandId!=-1){
				temp=goodsService.getGoodsByBrand(chooseNumber, lineNumber, brandId);
			}
			if(standId!=-1){
				temp=goodsService.getGoodsByStand(chooseNumber, lineNumber, standId);
			}
		}
		if(brandId==-1&&standId==-1)
			temp=goodsService.getGoodsByNumber(pageNumber, lineNumber);
		
		if(sortNumSaleNumber!=-1){
			PreSaleNumberComparator preSaleNumberComparator =new PreSaleNumberComparator(sortNumSaleNumber);
			Collections.sort(temp, preSaleNumberComparator);
		}
		if(sortNumRealPrice!=-1){
			RealPriceComparator realPriceComparator =new RealPriceComparator(sortNumRealPrice);
			Collections.sort(temp, realPriceComparator);
		}
		
		return temp ;
	}

	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		
		List<Category> categorys=categoryService.getAllCategory();
		return categorys;
	}

	public List<Brand> getBrandList() {
		// TODO Auto-generated method stub
		
		List<Brand> brands=brandService.getAllBrand();
		return brands;
	}

	public Stand getGoodsPrice(Long goods_id) {
		// TODO Auto-generated method stub
		
		return standService.getStandByGoodsId(String.valueOf(goods_id));
	//	return null;
	}
	
}
