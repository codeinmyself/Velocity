package xmu.mystore.user.zbh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.user.zbh.mappers.UserMapper;
import xmu.mystore.user.zbh.model.User;
import xmu.mystore.user.zbh.service.UserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
	@Autowired (required=false) 
	private UserMapper userMapper;

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
	}

	@Override
	public User getUserByMobilePhone(String mobilePhone) {
		// TODO Auto-generated method stub
		return userMapper.getUserByMobilePhone(mobilePhone);
	}

	@Override
	public User getUserByMobilePhoneAndPassword(String mobilePhone, String password) {
		// TODO Auto-generated method stub
		return userMapper.getUserByMobilePhoneAndPassword(mobilePhone, password);
	}
	
	
	

}
