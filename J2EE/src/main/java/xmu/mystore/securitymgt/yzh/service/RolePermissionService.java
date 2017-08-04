package xmu.mystore.securitymgt.yzh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.mapper.RolePermissionMapper;
import xmu.mystore.securitymgt.yzh.mapper.UserTypeMapper;
import xmu.mystore.securitymgt.yzh.model.RolePermission;
import xmu.mystore.securitymgt.yzh.model.UserType;

@Component
public class RolePermissionService {
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	public List<RolePermission> getAllRolePermission(){
		return rolePermissionMapper.getAllRolePermission();
	}
	
}
