package xmu.mystore.goodsmgt.wyh.service;

import java.util.List;

import xmu.mystore.goodsmgt.wyh.model.UserEntity;

public interface UserService {

	UserEntity getUserEntityById(String userId);
	
	List<UserEntity> getUserEntities();
	
	UserEntity insertUserEntity(UserEntity userEntity);
}
