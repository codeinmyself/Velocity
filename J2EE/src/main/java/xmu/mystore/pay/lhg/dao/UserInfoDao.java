package xmu.mystore.pay.lhg.dao;

import org.springframework.stereotype.Component;
import xmu.mystore.pay.lhg.model.UserInfo;

@Component
public interface UserInfoDao {

	public UserInfo getUser(long id);
}
