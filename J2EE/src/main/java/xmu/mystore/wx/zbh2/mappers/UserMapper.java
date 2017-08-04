package xmu.mystore.wx.zbh2.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mystore.wx.zbh2.model.User;

@Repository
public interface UserMapper {
	public User getUserByOpenid(String openid);
	public List<User> showAllUser();
	public void insertUser(User user);

}
