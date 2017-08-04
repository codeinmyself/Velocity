package xmu.mystore.ordersmgt.cdd.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.cdd.dao.UserMapper;
import xmu.mystore.ordersmgt.cdd.model.User;
import xmu.mystore.ordersmgt.cdd.service.UserService;

@Service
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
