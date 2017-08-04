package xmu.mall.usercenter.lxq.service;

import xmu.mall.goodsindex.zjh.model.AjaxReturnResult;
import xmu.mall.usercenter.lxq.model.Users;

public interface IUserMessageService {

	Users getUserByUserId(long id);

	AjaxReturnResult updatenickname(String str);

	AjaxReturnResult updatetel(String str);

}
