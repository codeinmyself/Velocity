package xmu.mystore.pay.liulei.mapper;

import org.springframework.stereotype.Component;

import xmu.mystore.pay.liulei.model.UserInfo;

@Component
public interface UserInfoMapper {

	public UserInfo getUser(long id);
}
