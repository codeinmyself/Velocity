package xmu.mystore.ordersmgt.zbh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.zbh.mappers.UserMapper;
import xmu.mystore.ordersmgt.zbh.model.User;
import xmu.mystore.ordersmgt.zbh.service.UserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
	@Autowired (required=false) 
	private UserMapper userMapper;
	
	public User getUserByUserId(long userId){
		return userMapper.getUserByUserId(userId);
	}
}
