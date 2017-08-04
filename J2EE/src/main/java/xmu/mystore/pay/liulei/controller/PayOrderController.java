package xmu.mystore.pay.liulei.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.pay.liulei.service.OrderGoodsService;
import xmu.mystore.pay.liulei.service.OrderInfoService;
import xmu.mystore.pay.liulei.service.UserInfoService;

@Controller
@RequestMapping(value = "/user/orderindex/order/pay/error")
public class PayOrderController {

//	@Autowired
//	private UserInfoService UserInfoService;
	
//	@Autowired
//	private OrderInfoService orderInfoService;
//	
//	@Autowired
//	private OrderGoodsService orderGoodsService;
//	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String list(Model model,HttpSession session){
		
//		model.addAttribute("goods", orderGoodsService.getAOrderGoods(null));
//		model.addAttribute("expressCode", orderInfoService.getOrderInfo(2).getExpressCode());
//		
		return "/liulei/pay";
	}
}
