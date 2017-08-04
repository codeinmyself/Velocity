package xmu.mystore.ordersmgt.zjq.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xmu.mystore.ordersmgt.zjq.Mapper.OrderChangeMapper;
import xmu.mystore.ordersmgt.zjq.Mapper.OrderDetailMapper;
import xmu.mystore.ordersmgt.zjq.Mapper.SqlSessionFactoryCreator;
import xmu.mystore.ordersmgt.zjq.model.Order_goods;
import xmu.mystore.ordersmgt.zjq.model.Order_info;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
@Controller
public class OrderDeatil {
    @RequestMapping("/Detail")
    public String ShowDetail(@RequestParam(value="order_id")String order_id, Model model)
    {
            long orderId=Long.parseLong(order_id);
            OrderDetailMapper mapper=new OrderDetailMapper();
            List<Order_goods> selectOrderGoods=new ArrayList<Order_goods>();
            Order_info order_info=new Order_info();
            selectOrderGoods=mapper.SelectOrdersGoods(orderId);
            order_info=mapper.SelectOrderOne(orderId);
            model.addAttribute("ordersn",order_info.getOrder_sn());
            switch (order_info.getOrder_status())
            {
                case 0:model.addAttribute("orderstatus","未付款");break;
                case 1:model.addAttribute("orderstatus","已付款");break;
                case 2:model.addAttribute("orderstatus","定制中");break;
                case 3:model.addAttribute("orderstatus","已发货");break;
                case 4:model.addAttribute("orderstatus","已收货");break;
                case 5:model.addAttribute("orderstatus","取消");break;
            }
            model.addAttribute("address",order_info.getAddress());
            model.addAttribute("orderprice",order_info.getOrder_price());
            model.addAttribute("consignee",order_info.getConsignee());
            model.addAttribute("zipcode",order_info.getZipcode());
            model.addAttribute("telephone",order_info.getTelephone());
            model.addAttribute("goodslist",selectOrderGoods);
            model.addAttribute("goodsprice",order_info.getGoods_price());
        return "zjq/OrderDetail";
    }
    @RequestMapping("/SendOrder")
    public String SendOrder(@RequestParam(value="order_id")String order_id, Model model)
    {
        long orderId=Long.parseLong(order_id);
        OrderDetailMapper mapper=new OrderDetailMapper();
        List<Order_goods> selectOrderGoods=new ArrayList<Order_goods>();
        Order_info order_info=new Order_info();
        selectOrderGoods=mapper.SelectOrdersGoods(orderId);
        order_info=mapper.SelectOrderOne(orderId);
        model.addAttribute("orderid",order_id);
        model.addAttribute("ordersn",order_info.getOrder_sn());
        switch (order_info.getOrder_status())
        {
            case 0:model.addAttribute("orderstatus","未付款");break;
            case 1:model.addAttribute("orderstatus","已付款");break;
            case 2:model.addAttribute("orderstatus","定制中");break;
            case 3:model.addAttribute("orderstatus","已发货");break;
            case 4:model.addAttribute("orderstatus","已收货");break;
            case 5:model.addAttribute("orderstatus","取消");break;
        }
        model.addAttribute("address",order_info.getAddress());
        model.addAttribute("orderprice",order_info.getOrder_price());
        model.addAttribute("consignee",order_info.getConsignee());
        model.addAttribute("zipcode",order_info.getZipcode());
        model.addAttribute("telephone",order_info.getTelephone());
        model.addAttribute("goodslist",selectOrderGoods);
        model.addAttribute("goodsprice",order_info.getGoods_price());
        return "zjq/Send";
    }
    @RequestMapping("/SendUpdate")
    public String SendUpdate(@RequestParam(value = "orderid")String orderId,@RequestParam(value = "code") String code)
    {
        OrderChangeMapper mapper=new OrderChangeMapper();
        Order_info order_info=new Order_info();
        order_info.setOrder_id(Long.parseLong(orderId));
        order_info.setExpressCode(code);
        order_info.setOrder_status(3);
        mapper.UpdateExpressCode(order_info);
        mapper.UpdateStatus(order_info);
        long date=new Date().getTime();
        order_info.setShipped_time(date);
        mapper.UpdateShippedTime(order_info);
        return "zjq/ShowOrders";
    }
}
