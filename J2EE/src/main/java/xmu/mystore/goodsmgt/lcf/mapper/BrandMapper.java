package xmu.mystore.goodsmgt.lcf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.mystore.goodsmgt.lcf.model.Brand;

/**
 * @author zhenglongtian
 *
 */
@Component
public interface BrandMapper {

	public int add(Brand brand);

	public int delete(Brand brand);

	public int update(Brand brand);

	public Brand select(Brand brand);

	/**
	 * @param isShowable
	 * @return
	 * if isShowable then show brands that type=1
	 */
	public List<Brand> selectAll(@Param("isShowable") boolean isShowable);

}
