package xmu.mystore.goodsmgt.wyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.wyh.mapper.BrandMapper;
import xmu.mystore.goodsmgt.wyh.model.Brand;
import xmu.mystore.goodsmgt.wyh.service.BrandService;

@Service("wyh_BrandService")
@Transactional

public class BrandServiceImpl implements BrandService {
	@Autowired
	@Qualifier("wyh_BrandMapper")
	private BrandMapper brandMapper;

	public BrandMapper getBrandMapper() {
		return brandMapper;
	}

	
	public void setBrandMapper(BrandMapper brandMapper) {
		this.brandMapper = brandMapper;
	}

	
	public Brand getBrandById(String brandId) {
		return this.brandMapper.getBrandById(brandId);
	}

	public List<Brand> getAllBrand() {
		return this.brandMapper.getAllBrand();
	}

	public Brand insertBrand(Brand brand) {
		this.brandMapper.insertBrand(brand);

		return getBrandById(String.valueOf(brand.getBrandId()));
	}


	public String getBrandIdByName(String brandName) {
		// TODO Auto-generated method stub
		String temp=this.brandMapper.getBrandIdByName(brandName).getName();
		return temp;
	}


	public void updateBrandById(Brand brand) {
		// TODO Auto-generated method stub
		this.brandMapper.updateBrandById(brand);
	}


	@Override
	public void deleteBrandById(String id) {
		// TODO Auto-generated method stub
		brandMapper.deleteBrandById(id);
	}

}