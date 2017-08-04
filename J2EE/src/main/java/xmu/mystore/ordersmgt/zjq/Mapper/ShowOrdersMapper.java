package xmu.mystore.ordersmgt.zjq.Mapper;

import org.apache.ibatis.session.SqlSession;
import xmu.mystore.ordersmgt.zjq.model.ForChange;
import xmu.mystore.ordersmgt.zjq.model.Order_goods;
import xmu.mystore.ordersmgt.zjq.model.Order_info;
import xmu.mystore.ordersmgt.zjq.model.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */
public class ShowOrdersMapper {
    private SqlSession sqlSession;
    public ShowOrdersMapper() {
        sqlSession=SqlSessionFactoryCreator.getSqlSessionFactory().openSession(true);
    }
    protected void finalize()
    {
        if(sqlSession!=null)
        {
            sqlSession.close();
        }
    }
    public List<Order_info> GetOrderInfoList()
    {
        List<Order_info> orderInfos = new ArrayList<Order_info>();
        try {
            orderInfos = sqlSession.selectList("ShowOrders.selectorderinfo");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orderInfos;
    }
    public List<Order_goods> GetOrderGoodsList()
    {
        List<Order_goods> orderGoods=new ArrayList<Order_goods>();
        try {
            orderGoods = sqlSession.selectList("ShowOrders.selectordergoods");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orderGoods;
    }
    public List<Users> GetAllUsers()
    {
        List<Users> users=new ArrayList<Users>();
        try {
            users = sqlSession.selectList("ShowOrders.selectusers");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return users;
    }
    public String Update(ForChange forChange)
    {   int num=0;
        try
        {
            num=sqlSession.update("ShowOrders.change",forChange);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if(num>0)return "success";
        else return "fail";
    }
}
