package xmu.mystore.ordersmgt.zyd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.ordersmgt.zyd.entities.Goods;
import xmu.mystore.ordersmgt.zyd.entities.Order;
import xmu.mystore.ordersmgt.zyd.entities.User;
import xmu.mystore.ordersmgt.zyd.service.GoodsService;
import xmu.mystore.ordersmgt.zyd.service.OrderService;
import xmu.mystore.ordersmgt.zyd.service.UserService;

@Controller
@RequestMapping(value="/user/order/")
public class OrderController {
	@Resource
	private OrderService orderService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	//@RequestMapping(value="order",method=RequestMethod.GET)//集成时，如果首页冲突，可以使用这个，把上面一条代码注释
	public String orderlist(Model model)
	{
		 List<Order> orderList = orderService.getAllOrder();     
	     //System.out.println(orderService.createOrder_sn());//测试接口
	     //orderService.receiveOrder(1);
	     //orderService.cancelOrder(1);
		 //orderList=orderService.getOrderByUser_id(1);
		 //orderList=orderService.getOrderByStatus(1,4);
		 //orderService.payOrder(1);
		 model.addAttribute("orderlist", orderList);
		 for(int i = 0; i<orderList.size();i++){ 
	    	 if(orderList.get(i).getTime()!=null){
	    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 orderList.get(i).setTime(sdf.format(new Date(Long.valueOf(orderList.get(i).getTime()+"000"))));
	    	 }
	    	 else orderList.get(i).setTime("");
	    	 if(orderList.get(i).getShipped_time()!=null){
	    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 orderList.get(i).setShipped_time(sdf.format(new Date(Long.valueOf(orderList.get(i).getShipped_time()+"000"))));
	    	 }
	    	 else orderList.get(i).setShipped_time("");
	    	 getGoodsName(orderList.get(i));
	     } 
	     return "zyd/orderlist";
	}
	
	@RequestMapping("sureOrder")
    public String sureOrder(Model model,HttpServletRequest request){	
		long oid=Long.parseLong(request.getParameter("orderId"));
		Order o=orderService.getOrderById(oid);
		o.setState(2);
		orderService.updateOrder(o);
		List<Order> orderList = orderService.getAllOrder();
		for(int i = 0; i<orderList.size();i++){ 
	    	 if(orderList.get(i).getTime()!=null){
	    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 orderList.get(i).setTime(sdf.format(new Date(Long.valueOf(orderList.get(i).getTime()+"000"))));
	    	 }
	    	 else orderList.get(i).setTime("");
	    	 if(orderList.get(i).getShipped_time()!=null){
	    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 orderList.get(i).setShipped_time(sdf.format(new Date(Long.valueOf(orderList.get(i).getShipped_time()+"000"))));
	    	 }
	    	 else orderList.get(i).setShipped_time("");
	    	 getGoodsName(orderList.get(i));
	    }
	    model.addAttribute("orderlist", orderList);
	    return "zyd/orderlist";
    }
	
	@RequestMapping("deliverOrder")
    public String deliverOrder(Model model,HttpServletRequest request){
		long oid=Long.parseLong(request.getParameter("orderId"));
		Order o=orderService.getOrderById(oid);
		if(o.getTime()!=null){
	   		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   		o.setTime(sdf.format(new Date(Long.valueOf(o.getTime()+"000"))));
	   	}
	   	else o.setTime("");
	   	if(o.getShipped_time()!=null){
	   		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   		o.setShipped_time(sdf.format(new Date(Long.valueOf(o.getShipped_time()+"000"))));
	   	}
	   	else o.setShipped_time("");
		List<Goods> goodsList=goodsService.getGoodsByOrderid(oid);
		User u=userService.getUserById(o.getUserId());
		
		model.addAttribute("order", o);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("user", u);
        return "zyd/deliver";
    }
	
	@RequestMapping("manageOrder")
    public String manageOrder(Model model,HttpServletRequest request){
		long oid=Long.parseLong(request.getParameter("orderId"));
		Order o=orderService.getOrderById(oid);
		if(o.getTime()!=null){
	   		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   		o.setTime(sdf.format(new Date(Long.valueOf(o.getTime()+"000"))));
	   	}
	   	else o.setTime("");
	   	if(o.getShipped_time()!=null){
	   		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   		o.setShipped_time(sdf.format(new Date(Long.valueOf(o.getShipped_time()+"000"))));
	   	}
	   	else o.setShipped_time("");
		List<Goods> goodsList=goodsService.getGoodsByOrderid(oid);
		User u=userService.getUserById(o.getUserId());
		
		model.addAttribute("order", o);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("user", u);
        return "zyd/manageOrder";
    }
	
	@RequestMapping("searchOrder")
    public String searchOrder(){	
		return "zyd/searchOrder";
    }
	
	@RequestMapping("searchResult")
    public String searchResult(Model model,String orderId,String beginTime, String goodsId,
    		String orderTotal,String orderConsignee,String orderAddress,String goodsName,
    		String orderPhone,String userId,String userName,String userPhone,int orderState,
    		String orderRemark,String orderAwb,String isUrgency,String endTime){
		//long longOrderId=stringToLong(orderId);
		long longGoodsId=stringToLong(goodsId);
		long longUserId=stringToLong(userId);
		try{
			
		}catch(Exception e){
			e.printStackTrace(); 
		}
		double total=-1;
		if(orderTotal!="")
		try{
			total=Double.parseDouble(orderTotal);
		}catch(Exception e){
			e.printStackTrace(); 
		}
        Order order=new Order(0, "", orderConsignee, orderAddress,orderPhone, total, 
        		longUserId,orderState,orderRemark,orderAwb,isUrgency);
        order.setOrder_sn(orderId);
        List<Order> orderList = orderService.getOrder(order);
		long ibt,iet,iot;
        try{
			if(beginTime!=""){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date=sdf.parse(beginTime+":00"); 
				ibt=date.getTime();
				if(endTime!=""){
					date=sdf.parse(endTime+":59"); 
					iet=date.getTime();
					for(int i = 0; i<orderList.size();i++){
						iot=Long.parseLong(orderList.get(i).getTime())*1000;
						if(ibt>iot){
							orderList.remove(i);
		        			i=i-1;
		        			continue;
						}
						if(iet<iot){
							orderList.remove(i);
		        			i=i-1;
		        			continue;
						}
				    }
				}				
			}		
		}catch(Exception e){
			e.printStackTrace(); 
		}
        for(int i = 0; i<orderList.size();i++){
        	User u=userService.getUserById(orderList.get(i).getUserId());
        	if(userName!="") 
        		if(u.getName().indexOf(userName)==-1) {
        			orderList.remove(i);
        			i=i-1;
        			continue;
        		}
        	if(userPhone!="")
        		if(u.getPhone().indexOf(userPhone)==-1) {
        			orderList.remove(i);
        			i=i-1;
        			continue;
        		}
        }
        if(goodsName!=""){
	        for(int i = 0; i<orderList.size();i++){
	        	List<Goods> goodsList=goodsService.getGoodsByOrderid(orderList.get(i).getId());
	        	int f=0;
	        	for(int j = 0; j<goodsList.size();j++){
	        		if(goodsList.get(j).getName().indexOf(goodsName)!=-1) f=1;
	        	}
	        	if(f==0){
	        		orderList.remove(i);
	    			i=i-1;
	        	}
	        }
        }
        if(longGoodsId!=0){
	        for(int i = 0; i<orderList.size();i++){
	        	List<Goods> goodsList=goodsService.getGoodsByOrderid(orderList.get(i).getId());
	        	int f=0;
	        	for(int j = 0; j<goodsList.size();j++){
	        		if(goodsList.get(j).getId()==longGoodsId) f=1;
	        	}
	        	if(f==0){
	        		orderList.remove(i);
	    			i=i-1;
	        	}
	        }
        }
        for(int i = 0; i<orderList.size();i++){ 
	    	 if(orderList.get(i).getTime()!=null){
	    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 orderList.get(i).setTime(sdf.format(new Date(Long.valueOf(orderList.get(i).getTime()+"000"))));
	    	 }
	    	 else orderList.get(i).setTime("");
	    	 if(orderList.get(i).getShipped_time()!=null){
	    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 orderList.get(i).setShipped_time(sdf.format(new Date(Long.valueOf(orderList.get(i).getShipped_time()+"000"))));
	    	 }
	    	 else orderList.get(i).setShipped_time("");
	    	 getGoodsName(orderList.get(i));
	    }
        model.addAttribute("orderlist", orderList);
	    return "zyd/orderlist";
    }
	
	@RequestMapping("updateOrder")
    public String updateOrder(Model model,long id,String consignee,String address,String phone,
    		int state,String awb,String remark,String isUrgency){	
		Order o=orderService.getOrderById(id);
		o.setConsignee(consignee);
		o.setAddress(address);
		o.setPhone(phone);
		o.setState(state);
		o.setAwb(awb);
		o.setRemark(remark);
		o.setIsUrgency(isUrgency);
		orderService.updateOrder(o);
		List<Order> orderList = orderService.getAllOrder();
		for(int i = 0; i<orderList.size();i++){ 
	    	 if(orderList.get(i).getTime()!=null){
	    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 orderList.get(i).setTime(sdf.format(new Date(Long.valueOf(orderList.get(i).getTime()+"000"))));
	    	 }
	    	 else orderList.get(i).setTime("");
	    	 if(orderList.get(i).getShipped_time()!=null){
	    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 orderList.get(i).setShipped_time(sdf.format(new Date(Long.valueOf(orderList.get(i).getShipped_time()+"000"))));
	    	 }
	    	 else orderList.get(i).setShipped_time("");
	    	 getGoodsName(orderList.get(i));
	    }
	    model.addAttribute("orderlist", orderList);
	    return "zyd/orderlist";
    }
	
	@RequestMapping("deliveredOrder")
    public String deliveredOrder(Model model,long id,String awb){	
		Order o=orderService.getOrderById(id);	
		o.setAwb(awb);
		o.setState(3);
		orderService.updateOrder(o);
		//IdTime it=new IdTime(id,(int)(new Date().getTime()/1000));
		//orderService.updateTime(it);
		orderService.updateTime(id,(int)(new Date().getTime()/1000));
		List<Order> orderList = orderService.getAllOrder();
		for(int i = 0; i<orderList.size();i++){ 
	    	 if(orderList.get(i).getTime()!=null){
	    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 orderList.get(i).setTime(sdf.format(new Date(Long.valueOf(orderList.get(i).getTime()+"000"))));
	    	 }
	    	 else orderList.get(i).setTime("");
	    	 if(orderList.get(i).getShipped_time()!=null){
	    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 orderList.get(i).setShipped_time(sdf.format(new Date(Long.valueOf(orderList.get(i).getShipped_time()+"000"))));
	    	 }
	    	 else orderList.get(i).setShipped_time("");
	    	 getGoodsName(orderList.get(i));
	    }
	    model.addAttribute("orderlist", orderList);
	    return "zyd/orderlist";
    }
	
	public long stringToLong(String str){
		long i=0;
		if(str==""||str==null) i=0;
		else i=Long.parseLong(str);
		return i;
	}
	
	public void getGoodsName(Order o){
		 List<Goods> goodsList=goodsService.getGoodsByOrderid(o.getId());
    	 if(goodsList.size()==0) o.setGoods("");
    	 else if(goodsList.size()==1) o.setGoods(goodsList.get(0).getName());
    	 else o.setGoods("......");
	}
}
