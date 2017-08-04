package xmu.mystore.goodsmgt.wyh.service;

import java.util.List;

import xmu.mystore.goodsmgt.wyh.model.Category;

public interface CategoryService {

	Category getCategoryById(String categoryId);
	
	List<Category> getAllCategory();
	
	Category insertCategory(Category category);
	
	void updateCategory(Category category);
	
	void deleteCategoryById(String id);
}
