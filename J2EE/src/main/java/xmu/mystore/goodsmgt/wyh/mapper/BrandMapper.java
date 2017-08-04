package xmu.mystore.goodsmgt.wyh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mystore.goodsmgt.wyh.model.Brand;

@Component("wyh_BrandMapper")
public interface BrandMapper {
	Brand getBrandById(String brandId);
	
	List<Brand> getAllBrand();
	
	int insertBrand(@Param("brand")Brand brand);
	
	Brand getBrandIdByName(String brandName);
	
	void updateBrandById(@Param("brand")Brand brand);
	
	void deleteBrandById(@Param("brandId")String brandId);
}
