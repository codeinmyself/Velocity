package xmu.mystore.goodsmgt.lcf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mystore.goodsmgt.lcf.model.Goods;
import xmu.mystore.goodsmgt.lcf.model.Stand;

/**
 * @author zhenglongtian
 *
 */
@Component
public interface StandMapper {
	public void add(Goods goods);

	public void delete(Stand stand);

	public void update(Stand stand);

	public Stand select(Stand stand);

	public List<Stand> selectByPage(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize);

	public List<Stand> selectAll();
}
