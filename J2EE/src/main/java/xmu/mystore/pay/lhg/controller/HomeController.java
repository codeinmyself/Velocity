package xmu.mystore.pay.lhg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.goodsmgt.zlt.service.GoodsMgtService;
import xmu.mystore.goodsmgt.zlt.service.GoodsService;
import xmu.mystore.pay.lhg.model.OrderGoods;
import xmu.mystore.pay.lhg.service.OrderGoodsService;
import xmu.mystore.pay.lhg.service.OrderInfoService;
import xmu.mystore.pay.lhg.service.UserInfoService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user/orderindex/order")
public class HomeController {
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showOrderInfos(String[] goodsId, String[] goodsNumber, Model model, HttpSession session) {
//        OrderInfo order = new OrderInfo();
//        order.setAddress("1111");
//        order.setOrder_price(2499.99);
//        order.setUser_id(1);
//        model.addAttribute("order", order);
//        UserInfo user = new UserInfo();
//        user.setNickname("admin");
//        user.setMobile_phone("13800997766");
//        user.setUser_name("李恒贵");
//        user.setUser_id(1);
//        model.addAttribute("user", user);
//        Goods goods = new Goods();
//        goods.setName("小米6");
//        goods.setDescription("小米6高配版");
//        goods.setReal_price(2499.99);
//        model.addAttribute("goods", goods);
        ArrayList<Goods> goodsList = new ArrayList<>();
        for (String i : goodsId) {
            goodsList.add(goodsMgtService.getGoodsByGoodsId(Long.parseLong(i)));
        }

        model.addAttribute("goodsId", goodsId);
        model.addAttribute("goodsNumber", goodsNumber);
        model.addAttribute("user", userInfoService.getUser((long) session.getAttribute("userId")));
        model.addAttribute("goods", goodsList);
        return "/lhg/submitOrder2";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST) //@ModelAttribute long orderId,
    public String payOrder(Model model, HttpSession session) {

        return "/lhg/payOrder3";
    }

    @RequestMapping(value = "/pay/success", method = RequestMethod.POST)
    public String paySuccess(Model model, HttpSession session) {
        return "/lhg/paySuccess";
    }
}
