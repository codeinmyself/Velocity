package xmu.mystore.goodsmgt.wyh.service;

import java.util.List;

import xmu.mystore.goodsmgt.wyh.model.Brand;

public interface BrandService {

	Brand getBrandById(String brandId);
	
	List<Brand> getAllBrand();
	
	Brand insertBrand(Brand brand);
	
	String getBrandIdByName(String brandName);
	
	void updateBrandById(Brand brand);
	
	void deleteBrandById(String id);
}
