package xmu.mall.usercenter.pjx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.mall.usercenter.pjx.model.Users;

@Component
public interface UsersMapper
{
	public Users selectByUserID(Users user);
	
	public void updateUsername(Users user);
	
	public void updateNickname(Users user);
	
	public void updateMobilephone(Users user);
}

