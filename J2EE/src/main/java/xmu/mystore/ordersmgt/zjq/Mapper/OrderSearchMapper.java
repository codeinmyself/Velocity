package xmu.mystore.ordersmgt.zjq.Mapper;

import org.apache.ibatis.session.SqlSession;
import xmu.mystore.ordersmgt.zjq.model.Order_goods;
import xmu.mystore.ordersmgt.zjq.model.Order_info;
import xmu.mystore.ordersmgt.zjq.model.SearchObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */
public class OrderSearchMapper {
    private SqlSession sqlSession;
    public OrderSearchMapper()
    {
        sqlSession=SqlSessionFactoryCreator.getSqlSessionFactory().openSession(true);
    }
    protected void finalize()
    {
        if(sqlSession!=null)
        {
            sqlSession.close();
        }
    }
    public List<Order_info> SearchOneInfo(SearchObject searchObject)
    {
        List<Order_info> orderInfos=new ArrayList<Order_info>();
        try
        {
            orderInfos=sqlSession.selectList("OrderSearch.searchone",searchObject);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orderInfos;
    }
    public List<Order_goods> SearchOrderGoods(SearchObject searchObject)
    {
        List<Order_goods> orderGoods=new ArrayList<Order_goods>();
        try
        {
            orderGoods=sqlSession.selectList("OrderSearch.searchorderandgood",searchObject);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orderGoods;
    }
    public List<Order_info> SearchOrderByList(List<Order_goods> orderGoods)
    {
        List<Order_info> orderInfos=new ArrayList<Order_info>();
        try
        {
            orderInfos=sqlSession.selectList("OrderSearch.searchorderbylist",orderGoods);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orderInfos;
    }
}
