package xmu.mystore.wx.zbh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.wx.zbh.mappers.UserMapper;
import xmu.mystore.wx.zbh.model.User;
import xmu.mystore.wx.zbh.service.UserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
	@Autowired (required=false) 
	private UserMapper userMapper;
	
	public User getUserByOpenid(String openid){
		return userMapper.getUserByOpenid(openid);
	}
	
	public List<User> showAllUser(){
		return userMapper.showAllUser();
	}
	
	public void insertUser(User user){
		userMapper.insertUser(user);
	}

}
