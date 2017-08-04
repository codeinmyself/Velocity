package xmu.mystore.ordersmgt.tangkai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.tangkai.mapper.UserMapper;
import xmu.mystore.ordersmgt.tangkai.model.User;
import xmu.mystore.ordersmgt.tangkai.service.UserService;

/**
 * @author tangkai
 * @data 2017年6月2日--下午1:19:56
 */
@Service("tangkai_UserService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
	@Autowired (required=false) 
	private UserMapper userMapper;
	
	@Override
	public User getUserByUserId(long user_id) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUserId(user_id);
	}

}
