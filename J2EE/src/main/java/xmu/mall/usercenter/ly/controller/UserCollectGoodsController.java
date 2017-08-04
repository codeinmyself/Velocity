package xmu.mall.usercenter.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xmu.mall.usercenter.ly.service.User_collect_goodsService;
import xmu.mall.usercenter.ly.service.impls.User_collect_goodsServiceImpl;
import xmu.mystore.goodsmgt.zlt.service.BrandService;
import xmu.mystore.goodsmgt.zlt.service.CategoryService;
import xmu.mystore.goodsmgt.zlt.service.GoodsMgtService;
import xmu.mystore.goodsmgt.zlt.service.GoodsService;

@Controller
@RequestMapping(value="/user")
public class UserCollectGoodsController
{
	@Autowired
    private User_collect_goodsServiceImpl user_collect_goodsservice;
	
	@Autowired
	private GoodsMgtService goodsService;

	@RequestMapping(value="/collect")
	public String collect(Model model)
	{
		model.addAttribute("collectlist", user_collect_goodsservice.getCollectListByUserId(1));
		return "ly/collectview";
	}
	
	@RequestMapping(value="/gooddetails")
	public String gooddetails(Model model,String id)
	{
		long goods_id = Long.parseLong(id);
		model.addAttribute("goods", goodsService.getGoodsByGoodsId(goods_id));
		return "zjh/goodsDetail";
	}
}
