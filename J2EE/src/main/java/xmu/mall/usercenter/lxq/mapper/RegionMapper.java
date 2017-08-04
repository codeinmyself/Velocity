package xmu.mall.usercenter.lxq.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mall.usercenter.lxq.model.Region;

@Repository
public interface RegionMapper {
	String getRegionNameByRegionId(Integer region_id);// 根据地区id获得地区的名称

	List<Region> getChildsByParentId(Integer parent_id);// 通过父类获得子地区的集合。
}
