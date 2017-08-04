package xmu.mystore.goodsmgt.wyh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mystore.goodsmgt.wyh.model.Category;

@Component("wyh_CategoryMapper")
public interface CategoryMapper {
	Category getCategoryById(String categoryId);
	
	List<Category> getAllCategory();
	
	int insertCategory(@Param("category")Category category);
	
	void updateCategory(@Param("category")Category category);
	
	void deleteCategoryById(@Param("categoryId")String categoryId);
}
