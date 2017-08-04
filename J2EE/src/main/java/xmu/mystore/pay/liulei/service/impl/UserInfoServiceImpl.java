package xmu.mystore.pay.liulei.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mystore.pay.liulei.mapper.UserInfoMapper;
import xmu.mystore.pay.liulei.model.UserInfo;
import xmu.mystore.pay.liulei.service.UserInfoService;

/**
 * 
 * @author liulei
 *
 */

@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public UserInfo getUser(long id){
		return userInfoMapper.getUser(id);
	}
}
