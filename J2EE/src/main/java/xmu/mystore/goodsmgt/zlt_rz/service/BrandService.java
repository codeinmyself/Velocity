package xmu.mystore.goodsmgt.zlt_rz.service;

import java.util.List;

import xmu.mystore.goodsmgt.zlt_rz.model.Brand;

/**
 * @author zhenglongtian
 *
 */
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
