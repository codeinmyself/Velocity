package xmu.mall.usercenter.cwh.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import xmu.mall.usercenter.cwh.model.Region;
import xmu.mall.usercenter.cwh.model.User;
import xmu.mall.usercenter.cwh.model.User_Address;
import xmu.mall.usercenter.cwh.service.IMGoodsService;
import xmu.mall.usercenter.cwh.service.IMUserService;
import xmu.mall.usercenter.cwh.service.IUser_AddressService;
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.ordersmgt.zyd.entities.Order;
import xmu.mystore.ordersmgt.zyd.service.OrderService;

@Controller
@RequestMapping(value = "/user/")
public class UserCenterController {

	@Resource
	private OrderService orderService;
	@Resource
	private IMGoodsService goodsService;
	@Resource
	private IUser_AddressService userAddressService;
	@Resource
	private IMUserService userService;

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		return "redirect:user_center_body?user_id=1";
	}
	
	@RequestMapping(value = "user_center_body", method = RequestMethod.GET)
	public String user_center_dispaly(Model model, Long user_id) {
		User user = userService.getUserByUserId(user_id);
		model.addAttribute("user", user);
		return "cwh/user_center_body";
	}

	@RequestMapping(value = "user_info_body", method = RequestMethod.GET)
	public String user_info_dispaly(Model model, Long user_id) {
		User user = userService.getUserByUserId(user_id);
		model.addAttribute("user", user);
		return "cwh/user_info_body";
	}

	@RequestMapping(value = "all_orders_body", method = RequestMethod.GET)
	public String order_dispaly(Model model, Long user_id, Integer order_status) {
		if (order_status == null)
			order_status = 43210;
		List<Order> orders = orderService.getOrderByStatus(user_id, order_status % 10);
		while (order_status / 10 > 0) {
			order_status /= 10;
			orders.addAll(orderService.getOrderByStatus(user_id, order_status % 10));
		}
		for (Order order : orders) {
			List goodslist = goodsService.getAllGoodsByOrderId(order.getId());
			order.setGoodslist(goodslist);
		}
		model.addAttribute("orders", orders);
		model.addAttribute("user_id", user_id);
		model.addAttribute("order_status", order_status);
		return "cwh/all_orders_body";
	}

	@RequestMapping(value = "changeOrderStatus", method = RequestMethod.GET)
	public String changeOrderStatus_dispaly(Model model, Long user_id, Long order_id, Integer order_status,
			RedirectAttributes attr) {
		if (order_status == 1) {
			orderService.payOrder(order_id);
			attr.addAttribute("user_id", user_id);
			attr.addAttribute("order_status", 0);
			return "redirect:/user/all_orders_body";
		} else if (order_status == 4) {
			orderService.receiveOrder(order_id);
			attr.addAttribute("user_id", user_id);
			attr.addAttribute("order_status", 123);
			return "redirect:/user/all_orders_body";
		} else {
			return "cwh/user_center_body?user_id=" + user_id;
		}
	}

	@RequestMapping(value = "my_collect_body", method = RequestMethod.GET)
	public String collect_body_dispaly(Model model, Long user_id) {
		List<Goods> goodslist = goodsService.getCollectedGoodsByUserId(user_id);
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("user_id", user_id);
		return "cwh/my_collect_body";
	}

	@RequestMapping(value = "cancelCollect", method = RequestMethod.GET)
	public String cancelCollect_dispaly(Model model, Long user_id, Long goods_id) {
		goodsService.delectCollectedGoodsByUserIdAndGoodsId(user_id, goods_id);
		List<Goods> goodslist = goodsService.getCollectedGoodsByUserId(user_id);
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("user_id", user_id);
		return "cwh/my_collect_body";
	}

	@RequestMapping(value = "address_body", method = RequestMethod.GET)
	public String address_body_dispaly(Model model, Long user_id) {
		List<User_Address> addresses = userAddressService.getAddressesByUserId(user_id);
		for (User_Address address : addresses) {
			address.setProvince_name(userAddressService.getRegionNameByRegionId(address.getProvince()));
			address.setCity_name(userAddressService.getRegionNameByRegionId(address.getCity()));
			address.setDistrict_name(userAddressService.getRegionNameByRegionId(address.getDistrict()));
		}
		model.addAttribute("addresses", addresses);
		model.addAttribute("user_id", user_id);
		return "cwh/address_body";
	}

	@RequestMapping(value = "editAddress", method = RequestMethod.GET)
	public String editAddress_dispaly(Model model, Long user_id, Long address_id) {
		User_Address address = null;
		String province_str = null, city_str = null, district_str = null;
		if (address_id != null ) {
			address = userAddressService.getAddressByAddressId(address_id);
			province_str = userAddressService.getRegionNameByRegionId(address.getProvince());
			city_str = userAddressService.getRegionNameByRegionId(address.getCity());
			district_str = userAddressService.getRegionNameByRegionId(address.getDistrict());
		}
		model.addAttribute("province_str", province_str);
		model.addAttribute("city_str", city_str);
		model.addAttribute("district_str", district_str);
		model.addAttribute("address", address);
		model.addAttribute("user_id", user_id);
		return "cwh/addAddress_body";
	}

	@RequestMapping(value = "region", method = RequestMethod.GET)
	public String region_dispaly(Model model, Long user_id, User_Address address) {
		List<Region> regions = userAddressService.getChildsByParentId(1);
		address.setProvince_name(userAddressService.getRegionNameByRegionId(address.getProvince()));
		if (address.getCity()!=null){
			address.setCity_name(userAddressService.getRegionNameByRegionId(address.getCity()));
			List<Region> regions1 = userAddressService.getChildsByParentId(address.getProvince());
			model.addAttribute("regions1", regions1);		
		}
		if (address.getCity()!=null){
			address.setDistrict_name(userAddressService.getRegionNameByRegionId(address.getDistrict()));
			List<Region> regions2 = userAddressService.getChildsByParentId(address.getCity());
			model.addAttribute("regions2", regions2);		
		}
		model.addAttribute("regions", regions);
		model.addAttribute("address", address);
		model.addAttribute("user_id", user_id);
		return "cwh/region_body";
	}
	
	@RequestMapping(value = "deleteAddress", method = RequestMethod.GET)
	public String deleteAddress_dispaly(Model model, Long user_id, Long address_id,RedirectAttributes attr) {
		userAddressService.deleteAddress(address_id);
		attr.addAttribute("user_id", user_id);
		return "redirect:/user/address_body";
	}
	
	@RequestMapping(value = "updateAddress", method = RequestMethod.GET)
	public String updateAddress_dispaly(Model model, Long user_id, User_Address address,RedirectAttributes attr) {
		if (address.isIs_default()==true){
			userAddressService.changeDefaultToZero(user_id);
		}
		if (address.getAddress_id()!=null){
			userAddressService.updateAddressByAddress(address);
		}else{
			userAddressService.addAddress(address);
		}
		attr.addAttribute("user_id", user_id);
		return "redirect:/user/address_body";
	}
	
	@RequestMapping(value = "region_back", method = RequestMethod.GET)
	public String region_back_dispaly(Model model, Long user_id, User_Address address) {
		String province_str = userAddressService.getRegionNameByRegionId(address.getProvince());
		String city_str = userAddressService.getRegionNameByRegionId(address.getCity());
		String district_str = userAddressService.getRegionNameByRegionId(address.getDistrict());
		model.addAttribute("province_str", province_str);
		model.addAttribute("city_str", city_str);
		model.addAttribute("district_str", district_str);
		model.addAttribute("address", address);
		model.addAttribute("user_id", user_id);
		return "cwh/addAddress_body";
	}

	@RequestMapping(value = "region_city",method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getRegion_city(Integer province,HttpServletRequest request) {
		List<Region> cities = userAddressService.getChildsByParentId(province);
		Map<String, Object> ReturnMAP = new HashMap<String, Object>();
		ReturnMAP.put("cities", cities);
		return ReturnMAP;
	}
	
	@RequestMapping(value = "region_district",method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getRegion_district(Integer city,HttpServletRequest request) {
		List<Region> districts = userAddressService.getChildsByParentId(city);
		Map<String, Object> ReturnMAP = new HashMap<String, Object>();
		ReturnMAP.put("districts", districts);
		return ReturnMAP;
	}
	
    @RequestMapping(value="updateUser_info", method=RequestMethod.POST)  
    public String doUploadFile(@RequestParam("file") MultipartFile file,User user,HttpServletRequest request
    		,RedirectAttributes attr) throws Exception{ 
    	String path=request.getSession().getServletContext().getRealPath("resources/images/cwh");
    	userService.updateUserByUser(user);
        if(!file.isEmpty()){  
            try {  
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path,file.getOriginalFilename()));  
            } catch (IOException e) {  
                e.printStackTrace();  
            } 
        }  
        attr.addAttribute("user_id",user.getUser_id());
        return "redirect:/user/user_center_body";  //上传成功则跳转至此success.jsp页面  
    }  
}
