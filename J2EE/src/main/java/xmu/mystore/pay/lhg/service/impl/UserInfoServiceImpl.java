package xmu.mystore.pay.lhg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.mystore.pay.lhg.dao.UserInfoDao;
import xmu.mystore.pay.lhg.model.UserInfo;
import xmu.mystore.pay.lhg.service.UserInfoService;


@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	public UserInfo getUser(long id){
		return userInfoDao.getUser(id);
	}
}
