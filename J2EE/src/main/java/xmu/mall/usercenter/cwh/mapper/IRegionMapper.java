package xmu.mall.usercenter.cwh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xmu.mall.usercenter.cwh.model.Region;

@Repository
public interface IRegionMapper {
	String getRegionNameByRegionId(Integer region_id);//根据地区id获得地区的名称
	List<Region> getChildsByParentId(Integer parent_id);//通过父类获得子地区的集合。
}
