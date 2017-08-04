package xmu.mall.usercenter.ljd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mall.usercenter.ljd.model.Region;

@Component
public interface RegionMapper
{
	public List<Region> selectAll();
	
	public List<Region> selectAllRegionByParentID(int parent_id);
	
}

