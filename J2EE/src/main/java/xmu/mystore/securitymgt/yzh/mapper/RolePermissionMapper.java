package xmu.mystore.securitymgt.yzh.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.model.RolePermission;
import xmu.mystore.securitymgt.yzh.model.UserType;

@Component
public interface RolePermissionMapper {
	List<RolePermission> getAllRolePermission();
}
