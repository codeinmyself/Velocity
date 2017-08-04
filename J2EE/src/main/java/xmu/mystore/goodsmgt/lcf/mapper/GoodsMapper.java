package xmu.mystore.goodsmgt.lcf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.mystore.goodsmgt.lcf.model.Goods;
import xmu.mystore.goodsmgt.lcf.model.SelectParameters;

/**
 * @author zhenglongtian
 *
 */
@Component
public interface GoodsMapper {

	public void add(Goods goods);

	public void update(Goods goods);

	public void delete(Goods goods);

	public Goods select(Goods goods);

	public List<Goods> selectAll();

	public Goods selectBySerialCode(Goods goods);

	public int selectByStoreId(Goods goods);

	public List<Goods> selectByName(Goods goods);

	public List<Goods> selectByBrand(Goods goods);

	public List<Goods> selectByCategory(Goods goods);

	public List<Goods> selectByBrandAndCategory(Goods goods);

	public List<Goods> selectByPage(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize);

	/**
	 * @param selects
	 * @return List<Goods> select goods by SelectParamters
	 */
	public List<Goods> selectBy(SelectParameters selects);
}
