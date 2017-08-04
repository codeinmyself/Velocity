package xmu.mall.usercenter.cdd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.cdd.mapper.IUserMapper;
import xmu.mall.usercenter.cdd.model.User;

@Service
@Transactional(rollbackFor = Exception.class)
public class MUserServiceImpl implements IMUserService{
	@Autowired (required=false) 
	private IUserMapper userMapper;
	
	@Override
	public User getUserByUserId(Long user_id) {
		return userMapper.getUserByUserId(user_id);
	}

	@Override
	public void updateUserByUser(User user) {
		userMapper.updateUserByUser(user);
	}

}
