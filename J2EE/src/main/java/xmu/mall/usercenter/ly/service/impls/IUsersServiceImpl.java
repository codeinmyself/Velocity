package xmu.mall.usercenter.ly.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mall.usercenter.ly.mapper.IUsersMapper;
import xmu.mall.usercenter.ly.model.Users;
import xmu.mall.usercenter.ly.service.IUsersService;

@Service("IUsersServiceImpl")
public class IUsersServiceImpl implements IUsersService
{
	@Autowired
	private IUsersMapper iusersmapper;
	
	public List<Users> getUserByUserId(Long id)
	{
		return iusersmapper.getUserByUserId(id);
	}
	public void updateu(Long user_id,String user_name,String nickname,String mobile_phone,String imagepath)
	{
		iusersmapper.updateu(user_id, user_name, nickname, mobile_phone, imagepath);
	}
}
