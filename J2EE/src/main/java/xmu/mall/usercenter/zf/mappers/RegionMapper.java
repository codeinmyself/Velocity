package xmu.mall.usercenter.zf.mappers;

import org.springframework.stereotype.Component;
import xmu.mall.usercenter.zf.model.Region;

import java.util.List;

@Component
public interface RegionMapper {
	
	String getRegionById(int id);

    List<Region> getAllProvince();

    List<Region> getRegions(int pid);
}
