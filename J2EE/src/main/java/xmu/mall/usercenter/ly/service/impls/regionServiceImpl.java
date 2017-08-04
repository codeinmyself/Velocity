package xmu.mall.usercenter.ly.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mall.usercenter.ly.mapper.regionMapper;
import xmu.mall.usercenter.ly.model.region;
import xmu.mall.usercenter.ly.service.regionService;

@Service("regionServiceImpl")
public class regionServiceImpl implements regionService
{
	@Autowired
	private regionMapper regionmapper;
	
	public String getRegionById(int region_id)
	{
		return regionmapper.getRegionById(region_id);
	}
}
