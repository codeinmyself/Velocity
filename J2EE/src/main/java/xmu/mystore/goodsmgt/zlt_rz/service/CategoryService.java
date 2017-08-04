package xmu.mystore.goodsmgt.zlt_rz.service;

import java.util.List;

import xmu.mystore.goodsmgt.zlt_rz.model.Category;

/**
 * @author zhenglongtian
 *
 */
public interface CategoryService {

	/**
	 * @param category
	 * @return
	 */
	public boolean addCategory(Category category);

	/**
	 * @param category
	 * @return
	 */
	public boolean modifyCategory(Category category);

	/**
	 * @param category
	 * @return
	 */
	public boolean deleteCategory(Category category);

	/**
	 * @param category
	 * @return
	 */
	public Category getACategory(Category category);

	/**
	 * @return
	 */
	public List<Category> getAllCategory();

	/**
	 * @return
	 */
	public List<Category> getShowCategory();

	/**
	 * @param category
	 * @return
	 */
	public Category getUpperCategory(Category category);

}
