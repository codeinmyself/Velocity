package xmu.mystore.ordersmgt.zyd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.zyd.entities.User;
import xmu.mystore.ordersmgt.zyd.mapper.UserMapper;
import xmu.mystore.ordersmgt.zyd.service.UserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
	@Autowired (required=false) 
	private UserMapper userDao;
	
	public User getUserById(long uid){
		return userDao.getUserById(uid);
	}
}
