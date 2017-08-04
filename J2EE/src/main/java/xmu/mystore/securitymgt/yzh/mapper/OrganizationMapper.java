package xmu.mystore.securitymgt.yzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xmu.mall.usercenter.zy.model.User;
import xmu.mystore.securitymgt.yzh.model.Organization;

public interface OrganizationMapper {
	
	List<Organization> getAllOrganization();

	Organization getOrganizationByID(Long organization_id);

	void changeOrganizationStateById(@Param("organization_id") Long organization_id, @Param("new_state")String new_state);

	Organization getOrganizationByName(String organization_name);
}
