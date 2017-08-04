//package xmu.mystore.goodsmgt.wyh.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
////import xmu.mystore.goodsmgt.wyh.mapper.UserMapper;
//import xmu.mystore.goodsmgt.wyh.model.UserEntity;
//import xmu.mystore.goodsmgt.wyh.service.UserService;
//
//public class UserServiceImpl implements UserService {
//	@Autowired
//	private UserMapper userMapper;
//
//	public UserMapper getUserMapper() {
//		return userMapper;
//	}
//
//	public void setUserMapper(UserMapper userMapper) {
//		this.userMapper = userMapper;
//	}
//
//	public UserEntity getUserEntityById(String userId) {
//		return this.userMapper.getUserEntityById(userId);
//	}
//
//	public List<UserEntity> getUserEntities() {
//		return this.userMapper.getUserEntities();
//	}
//
//	public UserEntity insertUserEntity(UserEntity userEntity) {
//		this.userMapper.insertUser(userEntity);
//
//		return getUserEntityById(userEntity.getUserId());
//	}
//
//}