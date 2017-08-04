package xmu.mystore.ordersmgt.zf.mapper;

import org.springframework.stereotype.Component;

import xmu.mystore.ordersmgt.zf.model.Users;



@Component
public interface UsersMapper {
	public Users getUserById(long id);

	void updateNickname(long uid, String nickname);

    void updateTelephone(long uid, String tel);

    void updatePassword(long uid, String pwd);
}
