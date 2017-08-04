package xmu.mall.usercenter.pjx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.mall.usercenter.pjx.model.Region;

@Component
public interface RegionMapper
{
	public List<Region> selectAll();
	
	public List<Region> selectAllRegionByParentID(int parent_id);
	
}

