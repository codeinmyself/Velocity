package xmu.mystore.goodsmgt.zlt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.mystore.goodsmgt.zlt.model.Category;

/**
 * @author zhenglongtian
 *
 */
@Component
public interface CategoryMapper {

	public void add(Category category);

	public void delete(Category category);

	public void update(Category category);

	public Category select(Category category);

	/**
	 * @param isShowable
	 * @return
	 * if isShowable then show categories that type=1
	 */
	public List<Category> selectAll(@Param("isShowable") boolean isShowable);
}
