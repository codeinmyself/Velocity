package xmu.mall.usercenter.cmy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.cmy.entity.User;
import xmu.mall.usercenter.cmy.mapper.User2Mapper;
import xmu.mall.usercenter.cmy.service.User2Service;

@Service
@Transactional(rollbackFor = Exception.class)
public class User2ServiceImpl implements User2Service{
	@Autowired (required=false) 
	private User2Mapper userMapper;
	
	@Override
	public User getUserByUserId(long user_id) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUserId(user_id);
	}

	@Override
	public void updateUser(User user){
		userMapper.updateUser(user);
	}
}
