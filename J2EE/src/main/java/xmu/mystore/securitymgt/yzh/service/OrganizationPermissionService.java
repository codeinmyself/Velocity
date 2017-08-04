package xmu.mystore.securitymgt.yzh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.mapper.OrganizationMapper;
import xmu.mystore.securitymgt.yzh.mapper.OrganizationPermissionMapper;
import xmu.mystore.securitymgt.yzh.mapper.PermissionMapper;
import xmu.mystore.securitymgt.yzh.mapper.RolePermissionMapper;
import xmu.mystore.securitymgt.yzh.mapper.UserTypeMapper;
import xmu.mystore.securitymgt.yzh.model.Organization;
import xmu.mystore.securitymgt.yzh.model.OrganizationPermission;
import xmu.mystore.securitymgt.yzh.model.Permission;
import xmu.mystore.securitymgt.yzh.model.RolePermission;
import xmu.mystore.securitymgt.yzh.model.UserType;

@Component
public class OrganizationPermissionService {
	@Autowired
	private OrganizationPermissionMapper organizationPermissionMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Autowired
	private OrganizationMapper organizationMapper;
	
	public List<OrganizationPermission> getAllOrganizationPermission(){
		return organizationPermissionMapper.getAllOrganizationPermission();
	}

	public OrganizationPermission getOrganizationPermissionByOp_Id(Long op_id) {
		
		return organizationPermissionMapper.getOrganizationPermissionByOp_Id(op_id);
	}

	public void modifyOrganizationPermission(OrganizationPermission organizationPermission) {
		Permission permission = organizationPermission.getPermission();
		permission = permissionMapper.
				getPermissionByTableNameAndPermission(permission.getPermission_name(), 
						permission.getPermission());
		if(permission == null)
			return ;
		organizationPermission.setPermission_id(permission.getPermission_id());
		organizationPermissionMapper.modifyOrganizationPermission(organizationPermission);
	}

	public void deletePermission(OrganizationPermission organizationPermission) {
		organizationPermissionMapper.deletePermissionByOp_id(organizationPermission.getOp_id());
	}

	public void addPermission(OrganizationPermission organizationPermission) {
		Permission permission = organizationPermission.getPermission();
		permission = permissionMapper.
				getPermissionByTableNameAndPermission(permission.getPermission_name(), 
						permission.getPermission());
		if(permission == null)
			return ;
		Organization organization = organizationMapper
				.getOrganizationByName(organizationPermission.getOrganization_name());
		if(organization == null){
			System.out.println("can find or" + organizationPermission.getOrganization_name());
			return ;
		}
		System.out.println(organization.toString());
		organizationPermission.setOrganization_id(organization.getOrganization_id());
		organizationPermission.setPermission_id(permission.getPermission_id());
		organizationPermissionMapper.addPermission(organizationPermission);	
		
	}
	
}
