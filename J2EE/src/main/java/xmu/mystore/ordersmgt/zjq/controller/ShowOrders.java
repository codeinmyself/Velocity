package xmu.mystore.ordersmgt.zjq.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xmu.mystore.ordersmgt.zjq.Mapper.ShowOrdersMapper;
import xmu.mystore.ordersmgt.zjq.Mapper.SqlSessionFactoryCreator;
import xmu.mystore.ordersmgt.zjq.model.*;
import xmu.mystore.ordersmgt.zjq.service.ShowOrdersMatch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20.
 */
@Controller
public class ShowOrders {
    @RequestMapping("/OrderManage")
    public String ShowListIndex()
    {
        return "zjq/ShowOrders";
    }
    @RequestMapping("/ShowList")
    @ResponseBody
    public List<ShowOrdersModel> ShowList()
    {
            List<ShowOrdersModel> ordersList=new ArrayList<ShowOrdersModel>();
            List<Order_info> orderInfos=new ArrayList<Order_info>();
            List<Order_goods> orderGoods=new ArrayList<Order_goods>();
            List<Users> users=new ArrayList<Users>();
            ShowOrdersMapper mapper=new ShowOrdersMapper();
            orderInfos=mapper.GetOrderInfoList();
            orderGoods=mapper.GetOrderGoodsList();
            users=mapper.GetAllUsers();
            ShowOrdersMatch match=new ShowOrdersMatch();
            ordersList=match.Match(orderInfos,orderGoods,users);
            return ordersList;
    }

    /**
     * 修改订单状态，从定制中到发货，或者从已付款到定制中
     * @param order_id
     * @param status
     * @return
     */

    @RequestMapping("/change")
    @ResponseBody
    public String Change(@RequestParam(value = "orderid") String order_id,@RequestParam(value = "status") String status)
    {
        ForChange forChange=new ForChange(order_id,Integer.parseInt(status));
        ShowOrdersMapper mapper=new ShowOrdersMapper();
        return mapper.Update(forChange);
    }
    /**
     * 商品管理和订单管理的选择页面
     */
    @RequestMapping("/aaa")
    public String Index()
    {
        return "zjq/Index";
    }

}
