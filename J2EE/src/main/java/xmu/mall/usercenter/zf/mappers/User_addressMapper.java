package xmu.mall.usercenter.zf.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zf.model.User_address;

/**
 * Created by 63520 on 2017/5/26.
 */
@Component
public interface User_addressMapper {
	
	User_address getAddressById(long id);

	List<User_address> getAddressByUid(long id);

    void changeToNotDefault();

	void changeToDefault(long id);

	void deleteAddress(long id);

	void saveAddress(User_address address);

	void updateAddress(User_address address);
}
