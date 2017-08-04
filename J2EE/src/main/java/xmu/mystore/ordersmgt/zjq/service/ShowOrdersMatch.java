package xmu.mystore.ordersmgt.zjq.service;

import xmu.mystore.ordersmgt.zjq.model.Order_goods;
import xmu.mystore.ordersmgt.zjq.model.Order_info;
import xmu.mystore.ordersmgt.zjq.model.ShowOrdersModel;
import xmu.mystore.ordersmgt.zjq.model.Users;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */
public class ShowOrdersMatch {
    /**
     * 这个返回的类不是完全的order_info类，而是商品信息和order_info集成成一条显示信息的类
     * @param orderInfos
     * @param orderGoods
     * @param users
     * @return
     */
    public List<ShowOrdersModel> Match(List<Order_info> orderInfos,List<Order_goods> orderGoods, List<Users> users)
    {
        List<ShowOrdersModel> ordersList=new ArrayList<ShowOrdersModel>();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i<orderInfos.size();i++)
        {
            ShowOrdersModel showOrdersModel=new ShowOrdersModel();
            long d1=orderInfos.get(i).getAdd_time();
            
            long d2=orderInfos.get(i).getShipped_time();
            

            Date date=new Date(d1);
            Date date1=null;
            if(d2!=0) {
                date1 = new Date(d2);
                showOrdersModel.setShipped_time(format.format(date1));
            }
            else showOrdersModel.setShipped_time("");
            showOrdersModel.setOrder_sn(orderInfos.get(i).getOrder_sn());
            showOrdersModel.setAdd_time(format.format(date));
            showOrdersModel.setConsignee(orderInfos.get(i).getConsignee());
            showOrdersModel.setOrder_price(orderInfos.get(i).getOrder_price());
            showOrdersModel.setRemark(orderInfos.get(i).getRemark());
            showOrdersModel.setUser_id(orderInfos.get(i).getUser_id());
            showOrdersModel.setOrder_id(orderInfos.get(i).getOrder_id());
            if(orderInfos.get(i).getIsUrgency().equals("Y"))
                showOrdersModel.setIsUrgency("加急");
            else showOrdersModel.setIsUrgency("未加急");
            switch (orderInfos.get(i).getOrder_status())
            {
                case 0:showOrdersModel.setOrder_status("未付款");break;
                case 1:showOrdersModel.setOrder_status("已收款");break;
                case 2:showOrdersModel.setOrder_status("定制中");break;
                case 3:showOrdersModel.setOrder_status("已发货");break;
                case 4:showOrdersModel.setOrder_status("已收货");break;
                case 5:showOrdersModel.setOrder_status("取消");break;
            }
            showOrdersModel.setExpressCode(orderInfos.get(i).getExpressCode());
            ordersList.add(showOrdersModel);
        }
        for(int i=0;i<ordersList.size();i++)
        {
            for(int j=0;j<orderGoods.size();j++)
            {
                if (orderGoods.get(j).getOrder_id()==ordersList.get(i).getOrder_id())
                {
                    ordersList.get(i).setName(orderGoods.get(j).getGoods_name());
                    break;
                }
            }
            for(int k=0;k<users.size();k++)
            {
                if(users.get(k).getUser_id()==ordersList.get(i).getUser_id())
                {
                    ordersList.get(i).setUser_name(users.get(k).getUser_name());
                }
            }
        }
        return ordersList;
    }
}
