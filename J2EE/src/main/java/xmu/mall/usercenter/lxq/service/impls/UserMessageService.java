package xmu.mall.usercenter.lxq.service.impls;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mall.goodsindex.zjh.constant.RenderAjaxReturnResult;
import xmu.mall.goodsindex.zjh.model.AjaxReturnResult;
import xmu.mall.usercenter.lxq.mapper.UserMessageMapper;
import xmu.mall.usercenter.lxq.model.Users;
import xmu.mall.usercenter.lxq.service.IUserMessageService;

@Service("UserMessageService")
public class UserMessageService implements IUserMessageService {

	@Autowired
	private UserMessageMapper userMessageService;

	private HttpServletRequest request;

	public Users getUserByUserId(long id) {
		return userMessageService.getUserByUserId(id);
	}

	public AjaxReturnResult updatenickname(String str) {
		boolean success = true;
		// String str1 = request.getParameter("InputName");

		if (userMessageService.updatenickname(str) > 0)
			success = true;
		else
			success = false;

		if (success) {
			return RenderAjaxReturnResult.renderSuccessResult("修改状态成功");
		} else {
			return RenderAjaxReturnResult.renderErrorResult("修改状态失败!");
		}
	}

	public AjaxReturnResult updatetel(String str) {

		if (userMessageService.updatetel(str) > 0)
			return RenderAjaxReturnResult.renderSuccessResult("修改状态成功");
		return RenderAjaxReturnResult.renderErrorResult("修改状态失败!");
	}

}
