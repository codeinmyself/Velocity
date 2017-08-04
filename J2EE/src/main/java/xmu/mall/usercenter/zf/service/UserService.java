package xmu.mall.usercenter.zf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.zf.mappers.User_collect_goodsMapper;
import xmu.mall.usercenter.zf.model.User_collect_goods;
import xmu.mystore.ordersmgt.zf.mapper.UsersMapper;
import xmu.mystore.ordersmgt.zf.model.Users;

/**
 * Created by 63520 on 2017/5/26.
 */
@Service("userService")
@Transactional
public class UserService {

    @Autowired
    private UsersMapper userMapper;
    
    @Autowired
    private User_collect_goodsMapper collectMapper;

    public Users getUserById(long id){
        return this.userMapper.getUserById(id);
    }

	public void saveNickname(long uid, String nickname) {
		this.userMapper.updateNickname(uid, nickname);
	}

	// 获取用户收藏
	public List<User_collect_goods> getCollectionsById(long uid) {
		return this.collectMapper.getCollectionsByUserId(uid);
	}

	// 删除收藏
	public void deleteCollect(long cid) {
		this.collectMapper.deleteById(cid);
	}

    public void saveTelephone(long uid, String tel) {
    	this.userMapper.updateTelephone(uid, tel);
    }

	public void savePassword(long uid, String pwd) {
    	this.userMapper.updatePassword(uid, pwd);
	}
}
