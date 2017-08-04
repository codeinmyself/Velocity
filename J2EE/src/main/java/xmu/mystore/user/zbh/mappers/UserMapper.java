package xmu.mystore.user.zbh.mappers;

import org.springframework.stereotype.Repository;

import xmu.mystore.user.zbh.model.User;

@Repository
public interface UserMapper {
	public void insertUser(User user);
	public User getUserByMobilePhone(String mobilePhone);
	public User getUserByMobilePhoneAndPassword(String mobilePhone,String password);
}
