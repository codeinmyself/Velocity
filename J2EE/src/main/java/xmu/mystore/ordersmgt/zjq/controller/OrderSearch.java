package xmu.mystore.ordersmgt.zjq.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xmu.mystore.ordersmgt.zjq.Mapper.OrderSearchMapper;
import xmu.mystore.ordersmgt.zjq.Mapper.ShowOrdersMapper;
import xmu.mystore.ordersmgt.zjq.Mapper.SqlSessionFactoryCreator;
import xmu.mystore.ordersmgt.zjq.model.*;
import xmu.mystore.ordersmgt.zjq.service.OrderSearchMatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
@Controller
public class OrderSearch {
    @RequestMapping("/GoSearch")
    public String GoSearch()
    {
        return "zjq/OrderSearch";
    }

    @RequestMapping("/Search")
    public String Search()
    {
        return "zjq/ShowOrders";
    }

    /**
     * 查询的controller
     * @param acceptSearch
     * @return
     */
    @RequestMapping("/SearchList")
    @ResponseBody
    public List<ShowOrdersModel> SearchList(@RequestBody AcceptSearch acceptSearch)
    {
            OrderSearchMatch orderSearchMatch=new OrderSearchMatch();
            OrderSearchMapper mapper=new OrderSearchMapper();
            ShowOrdersMapper showOrdersMapper=new ShowOrdersMapper();
            SearchObject searchObject=orderSearchMatch.Match(acceptSearch);
            List<ShowOrdersModel> ordersList=new ArrayList<ShowOrdersModel>();
            List<Order_goods> orderGoods=new ArrayList<Order_goods>();
            List<Order_info> orderInfos=new ArrayList<Order_info>();
            List<Order_info> orderInfos1=new ArrayList<Order_info>();
            List<Users> users=new ArrayList<Users>();
            /**
             * 有两份逻辑，第一份，根据编号等查找订单；第二份，根据商品名称获取一系列的订单id，根据这些id来获取订单
             */
            orderInfos=mapper.SearchOneInfo(searchObject);
            orderGoods=mapper.SearchOrderGoods(searchObject);
            if(orderGoods.size()>0)
                orderInfos1=mapper.SearchOrderByList(orderGoods);
            orderInfos.addAll(orderInfos1);
            orderGoods=showOrdersMapper.GetOrderGoodsList();
            users=showOrdersMapper.GetAllUsers();
            ordersList=orderSearchMatch.MatchShowOrdersModel(orderInfos,orderGoods,users);
            return ordersList;
    }
}
