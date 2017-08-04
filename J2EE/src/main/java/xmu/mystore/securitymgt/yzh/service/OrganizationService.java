package xmu.mystore.securitymgt.yzh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.User;
import xmu.mystore.securitymgt.yzh.mapper.OrganizationMapper;
import xmu.mystore.securitymgt.yzh.mapper.UserTypeMapper;
import xmu.mystore.securitymgt.yzh.model.Organization;
import xmu.mystore.securitymgt.yzh.model.UserType;

@Component
public class OrganizationService {
	@Autowired
	private OrganizationMapper organizationMapper;
	
	public List<Organization> getAllOrganization(){
		return organizationMapper.getAllOrganization();
	}

	public void changeOrganizationStateById(Long organization_id) {
		String new_state = "enable";
		Organization organization = organizationMapper.getOrganizationByID(organization_id);
		if(organization == null)
			return;
		if(organization.getEnable().equals("enable")){
			new_state = "disable";
		} 
		this.organizationMapper.changeOrganizationStateById(organization_id, new_state);
	}
	
}
