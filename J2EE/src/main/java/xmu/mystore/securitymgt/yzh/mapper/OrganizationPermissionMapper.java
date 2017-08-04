package xmu.mystore.securitymgt.yzh.mapper;

import java.util.List;

import xmu.mystore.securitymgt.yzh.model.Organization;
import xmu.mystore.securitymgt.yzh.model.OrganizationPermission;

public interface OrganizationPermissionMapper {
	
	List<OrganizationPermission> getAllOrganizationPermission();

	OrganizationPermission getOrganizationPermissionByOp_Id(Long op_id);

	void modifyOrganizationPermission(OrganizationPermission organizationPermission);

	void deletePermissionByOp_id(Long op_id);

	void addPermission(OrganizationPermission organizationPermission);
}
