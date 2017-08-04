package xmu.mystore.securitymgt.yzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.model.Permission;
import xmu.mystore.securitymgt.yzh.model.RolePermission;
import xmu.mystore.securitymgt.yzh.model.UserType;

@Component
public interface PermissionMapper {
	List<Permission> getAllPermissionByUserId(Long user_id);
	
	Permission getPermissionByPermissionId(Long permission_id);
	
	Permission getPermissionByTableNameAndPermission(
			@Param("permission_name") String permission_name, @Param("permission")String permission);
	
	List<Permission> getAllPermission();
}
