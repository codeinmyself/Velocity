package xmu.mystore.securitymgt.yzh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.mapper.RoleMapper;
import xmu.mystore.securitymgt.yzh.model.Permission;
import xmu.mystore.securitymgt.yzh.model.Role;
import xmu.mystore.securitymgt.yzh.model.RoleInfo;
import xmu.mystore.securitymgt.yzh.model.UserRole;

@Component
public class RoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	public RoleInfo getRoleById(Long role_id){
		return roleMapper.getRoleTypeByID(role_id);
	}
	
	public List<Role> getAllRole(){
		return roleMapper.getAllRole();
	}
	
	public List<Permission> getAllPermissionByRoleId(Long role_id){
		return roleMapper.getAllPermissionByRoleId(role_id);
	}

	public List<Permission> getAllNotExistintPermissionByRoleId(Long role_id){
		return roleMapper.getAllNotExistintPermissionByRoleId(role_id);
	}
	
	public RoleInfo getRoleInfoById(Long role_id) {
		return roleMapper.getRoleInfoById(role_id);
	}

	public void saveRoleInfo(RoleInfo roleInfo) {
		roleMapper.saveRoleInfo(roleInfo);
	}

	public void deleteRoleInfo(RoleInfo roleInfo) {
		roleMapper.deleteRoleInfoByRoleId(roleInfo.getRole_id());
	}

	public void addRoleInfo(RoleInfo roleInfo) {
		roleMapper.addRoleInfo(roleInfo);
		
	}

	public void deleteRole(Role role) {
		roleMapper.deleteRole(role);
	}

	public void addRole(Role role) {
		roleMapper.addRole(role);
	}

	public List<RoleInfo> getAllRoleInfoByUserId(long user_id) {
		return roleMapper.getAllRoleInfoByUserId(user_id);
	}

	public void deleteUserRole(UserRole user_role) {
		roleMapper.deleteUserRole(user_role);
		
	}

	public void addUserRole(UserRole user_role) {
		roleMapper.addUserRole(user_role);
		
	}

	public List<RoleInfo> getAllNotExistintRoleInfoByUserId(long user_id) {
		return roleMapper.getAllNotExistintRoleInfoByUserId(user_id);
	}
}
