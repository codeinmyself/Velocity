package xmu.mystore.goodsmgt.wcf.mapper;

import java.util.List;

import xmu.mystore.goodsmgt.wcf.model.Brand;


/**
*@author created by �����
*@date 2017��5��31��--����1:43:56
*/
public interface BrandMapper {

	public List<Brand> getBrandList();
	public boolean addBrand(Brand brand);
	public boolean deleteBrandById(long id);
	public Brand getBrandById(long id);
	public boolean updateBrand(Brand brand);
}
