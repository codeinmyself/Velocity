package xmu.mystore.securitymgt.yzh.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.model.Permission;
import xmu.mystore.securitymgt.yzh.model.Role;
import xmu.mystore.securitymgt.yzh.model.RoleInfo;
import xmu.mystore.securitymgt.yzh.model.UserRole;
import xmu.mystore.securitymgt.yzh.model.UserType;

@Component
public interface RoleMapper {
	
	RoleInfo getRoleTypeByID(Long role_id);
	
	List<Role> getAllRole();
/*
 * 
 * select * 
from permission 
where permission_id not in(
select permission.permission_id 
from permission, role
where role.role_id=1 AND
permission.permission_id=role.permission_id);
*
 */
	List<Permission> getAllPermissionByRoleId(Long role_id);
	
	// 查找当前角色未获得的权限
	List<Permission> getAllNotExistintPermissionByRoleId(Long role_id);

	RoleInfo getRoleInfoById(Long role_id);

	void saveRoleInfo(RoleInfo roleInfo);

	void deleteRoleInfoByRoleId(Long role_id);

	void addRoleInfo(RoleInfo roleInfo);

	void deleteRole(Role role);

	void addRole(Role role);

	List<RoleInfo> getAllRoleInfoByUserId(long user_id);

	void deleteUserRole(UserRole user_role);

	void addUserRole(UserRole user_role);

	List<RoleInfo> getAllNotExistintRoleInfoByUserId(long user_id);
}
