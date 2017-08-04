package xmu.mystore.securitymgt.yzh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.mapper.PermissionMapper;
import xmu.mystore.securitymgt.yzh.mapper.RoleMapper;
import xmu.mystore.securitymgt.yzh.model.Permission;
import xmu.mystore.securitymgt.yzh.model.Role;
import xmu.mystore.securitymgt.yzh.model.RoleInfo;

@Component
public class PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	
	public List<Permission> getAllPermission(){
		return permissionMapper.getAllPermission();
	}
}
