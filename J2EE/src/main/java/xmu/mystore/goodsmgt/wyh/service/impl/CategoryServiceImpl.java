package xmu.mystore.goodsmgt.wyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.wyh.mapper.CategoryMapper;
import xmu.mystore.goodsmgt.wyh.model.Category;
import xmu.mystore.goodsmgt.wyh.service.CategoryService;

@Service("wyh_CategoryService")
@Transactional

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	@Qualifier("wyh_CategoryMapper")
	private CategoryMapper categoryMapper;

	public CategoryMapper getCategoryMapper() {
		return categoryMapper;
	}

	
	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

	
	public Category getCategoryById(String goodsId) {
		return this.categoryMapper.getCategoryById(goodsId);
	}

	public List<Category> getAllCategory() {
		return this.categoryMapper.getAllCategory();
	}

	public Category insertCategory(Category category) {
		this.categoryMapper.insertCategory(category);

		return getCategoryById(String.valueOf(category.getId()));
	}


	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.updateCategory(category);
	}


	@Override
	public void deleteCategoryById(String id) {
		// TODO Auto-generated method stub
		categoryMapper.deleteCategoryById(id);
	}

}