package xmu.mystore.pay.liulei.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.pay.liulei.model.OrderGoods;
import xmu.mystore.pay.liulei.model.OrderInfo;
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.goodsmgt.zlt.service.GoodsMgtService;
import xmu.mystore.goodsmgt.zlt.service.GoodsService;
import xmu.mystore.pay.liulei.service.OrderGoodsService;
import xmu.mystore.pay.liulei.service.OrderInfoService;
import xmu.mystore.pay.liulei.service.UserInfoService;

@Controller
@RequestMapping(value = "/user/orderindex/order")
public class OrderSubmitController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private OrderInfoService orderInfoService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodsMgtService goodsMgtService;
	
	@Autowired
	private OrderGoodsService orderGoodsService;
	
	@RequestMapping(value="",method = RequestMethod.POST)
	public String showOrderInfo(String[] goodsId, String[] goodsNumber, Model model, HttpSession session) {
		
		ArrayList<Goods> goodsList=new ArrayList<Goods>();
		for(String i:goodsId){
			goodsList.add(goodsMgtService.getGoodsByGoodsId(Long.parseLong(i)));
		}
		
		model.addAttribute("goodsId",goodsId);
		model.addAttribute("goodsNumber",goodsNumber);
		
//		ArrayList<OrderGoods> orderGoodsList=new ArrayList<>();
//		
//		for(int i=0;i<goodsId.length;i++) {
//			orderGoodsList.add(new OrderGoods())
//		}
		model.addAttribute("user",userInfoService.getUser((long)session.getAttribute("userId")));
		model.addAttribute("goods",goodsList);//得到商品列表
//		model.addAttribute("user",userInfoService.getUser((long)session.getAttribute("userId")));
		
		//model.addAttribute("order", orderInfoService.getOrderInfo(2));
		return "liulei/submitOrder2";
	}
	
	
	@RequestMapping(value="/pay",method=RequestMethod.POST)//@ModelAttribute long orderId,
	public String payOrder ( Model model,HttpSession session){
		//将获取到的订单ID的状态改为未支付
		
		//OrderInfo order=orderInfoService.getOrderInfo(user_id);
		
//		model.addAttribute("order",order);
		
		List<OrderGoods> orderGoods=orderGoodsService.getOrderGoods(3);
		ArrayList<Goods> goods = new ArrayList<Goods>();
		//orderInfoService.setOrderStatus(0, 3);
		
		for(OrderGoods og:orderGoods) {
			goods.add(goodsMgtService.getGoodsByGoodsId(og.getGoods_id()));
		}
		Goods goodes=goodsMgtService.getGoodsByGoodsId((long)55);
		
		model.addAttribute("goods", goodes);//订单内的所有商品列表
		model.addAttribute("user",userInfoService.getUser((long)session.getAttribute("userId")));//传递用户
		
		//orderInfoService.getOrderInfo(id).setOrder_status(0);
		return "/liulei/payOrder3";
	}
	
	@RequestMapping(value="/pay/success",method=RequestMethod.POST)
	public String paySuccess(Model model,HttpSession session) {
		
		return "/liulei/paySuccess";
	}
}
