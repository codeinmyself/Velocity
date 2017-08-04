package xmu.mall.usercenter.ghz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mall.usercenter.ghz.entity.User;
import xmu.mall.usercenter.ghz.mapper.IUserMapper;

@Service
public class UserService {
	
	@Autowired
	private IUserMapper userMapper;
	
	public User getUserById(int user_id) {
		return userMapper.getUserById(user_id);
	}
	
	public boolean updateUserName(int user_id, String nickname) {
		return userMapper.updateUserName(user_id, nickname);
	}
}
