package xmu.mall.usercenter.lxq.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mall.goodsindex.zjh.constant.RenderAjaxReturnResult;
import xmu.mall.goodsindex.zjh.model.AjaxReturnResult;
import xmu.mall.usercenter.lxq.mapper.CollectMapper;
import xmu.mall.usercenter.lxq.mapper.MyCollectMapper;
import xmu.mall.usercenter.lxq.model.Goods;
import xmu.mall.usercenter.lxq.model.UserCollectGoods;
import xmu.mall.usercenter.lxq.service.IMyCollectService;

@Service("MyCollectService")
public class MyCollectService implements IMyCollectService {

	@Autowired
	private MyCollectMapper myCollectService;

	@Autowired
	private CollectMapper collectMapper;

	public List<Goods> getGoodsListByUserId(Long id) {
		return myCollectService.getGoodsListByUserId(id);
	}

	public int addCollectByGoodsId(long id) {
		return myCollectService.addCollectByGoodsId(id);
	}

	public UserCollectGoods hasCollection(long goodsId, long userId) {
		return collectMapper.selectCollectByGoodsIdAndUserId(goodsId, userId);
	}

	public AjaxReturnResult deleteCollectByGoodsId(Long id) {
		boolean success = true;

		if (myCollectService.deleteCollectByGoodsId(id) > 0)
			success = true;
		else
			success = false;

		if (success) {
			return RenderAjaxReturnResult.renderSuccessResult("修改状态成功");
		} else {
			return RenderAjaxReturnResult.renderErrorResult("修改状态失败!");
		}

	}

}
