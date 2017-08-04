package xmu.mystore.securitymgt.yzh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.mapper.UserTypeMapper;
import xmu.mystore.securitymgt.yzh.model.UserType;

@Component
public class UserTypeService {
	@Autowired
	private UserTypeMapper userTypeMapper;
	
	public UserType getUserTypeById(Long user_id){
		return userTypeMapper.getUserTypeByID(user_id);
	}
	
}
