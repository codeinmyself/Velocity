package xmu.mystore.securitymgt.yzh.mapper;

import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.model.UserType;

@Component
public interface UserRoleMapper {
	
	UserType getUserTypeByID(Long user_id);
	
	
}
