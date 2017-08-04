package xmu.mystore.goodsmgt.lcf.service;

import java.util.List;

import xmu.mystore.goodsmgt.lcf.model.Brand;

public interface BrandService {

	/**
	 * @param brand
	 * @return
	 */
	public boolean addBrand(Brand brand);

	/**
	 * @param brand
	 * @return
	 */
	public boolean deleteBrand(Brand brand);

	/**
	 * @param brand
	 * @return
	 */
	public boolean modifyBrand(Brand brand);

	/**
	 * @param brand
	 * @return
	 */
	public Brand getABrand(Brand brand);

	/**
	 * @return
	 */
	public List<Brand> getAllBrand();

	/**
	 * @return
	 */
	public List<Brand> getShowBrand();

}
