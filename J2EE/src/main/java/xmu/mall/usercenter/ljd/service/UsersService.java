package xmu.mall.usercenter.ljd.service;

import java.util.List;

import xmu.mall.usercenter.ljd.model.Users;

public interface UsersService {
	
	public Users getUsersByID(Users user);
	
	public boolean updateUsername(Users user);
	
	public boolean updateNickname(Users user);
	
	public boolean updateMobilephone(Users user);
	
}
