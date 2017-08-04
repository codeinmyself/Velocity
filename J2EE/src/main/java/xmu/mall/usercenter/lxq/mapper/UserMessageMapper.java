package xmu.mall.usercenter.lxq.mapper;

import org.springframework.stereotype.Component;

import xmu.mall.usercenter.lxq.model.Users;

@Component
public interface UserMessageMapper {

	Users getUserByUserId(long id);

	int updatenickname(String str);

	int updatetel(String str);

}
