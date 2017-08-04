package xmu.mall.usercenter.ljd.service.impls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.ljd.mapper.UsersMapper;
import xmu.mall.usercenter.ljd.model.Users;
import xmu.mall.usercenter.ljd.service.UsersService;

@Service("UsersService")
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public Users getUsersByID(Users user){
		return usersMapper.selectByUserID(user);
	}
	
	@Override
	public boolean updateUsername(Users user){
		usersMapper.updateUsername(user);
		return true;
	}
	
	@Override
	public boolean updateNickname(Users user){
		usersMapper.updateNickname(user);
		return true;
	}
	
	@Override
	public boolean updateMobilephone(Users user){
		usersMapper.updateMobilephone(user);
		return true;
	}
	
}
