package xmu.mall.usercenter.cwh.service;
import xmu.mall.usercenter.cwh.model.User;

public interface IMUserService {
	User getUserByUserId(Long user_id);//根据用户id获得用户对象
	void updateUserByUser(User user);//根据用户对象更改用户
}
