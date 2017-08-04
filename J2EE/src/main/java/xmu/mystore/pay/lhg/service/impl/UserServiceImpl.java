package xmu.mystore.pay.lhg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.mystore.pay.lhg.dao.UserDao;
import xmu.mystore.pay.lhg.model.User;
import xmu.mystore.pay.lhg.service.UserService;


@Service("UserInfoService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUser(long id){
		return userDao.getUser(id);
	}
}
