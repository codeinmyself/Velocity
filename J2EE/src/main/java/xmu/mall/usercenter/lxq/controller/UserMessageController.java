package xmu.mall.usercenter.lxq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import xmu.mall.usercenter.lxq.model.Region;
import xmu.mall.usercenter.lxq.model.UserAddress;
import xmu.mall.usercenter.lxq.service.IMyCollectService;
import xmu.mall.usercenter.lxq.service.IUserAddressService;
import xmu.mall.usercenter.lxq.service.IUserMessageService;
import xmu.mystore.ordersmgt.tangkai.service.OrderService;

@Controller
@RequestMapping(value = "/user")
public class UserMessageController {

	@Autowired
	@Qualifier("tangkai_OrderService")
	private OrderService orderService;
	@Autowired
	@Qualifier("MyCollectService")
	private IMyCollectService myCollectService;
	@Autowired
	@Qualifier("UserMessageService")
	private IUserMessageService userMessageService;

	@Autowired
	@Qualifier("userAddressService")
	private IUserAddressService userAddressService;

	/**
	 * 跳转到购物车主页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String cartIndex(Model model, HttpSession session) {

		return "lxq/usermessage";
	}

	@RequestMapping(value = "/address_body", method = RequestMethod.GET)
	public String address_body_dispaly(Model model, HttpSession session) {
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		List<UserAddress> addresses = userAddressService.getAddressesByUserId(userId);
		for (UserAddress address : addresses) {
			address.setProvince_name(userAddressService.getRegionNameByRegionId(address.getProvince()));
			address.setCity_name(userAddressService.getRegionNameByRegionId(address.getCity()));
			address.setDistrict_name(userAddressService.getRegionNameByRegionId(address.getDistrict()));
		}
		model.addAttribute("addresses", addresses);
		model.addAttribute("user_id", userId);
		return "lxq/address_body";
	}

	@RequestMapping(value = "/editAddress", method = RequestMethod.GET)
	public String editAddress_dispaly(Model model, Long user_id, Long address_id) {
		UserAddress address = null;
		String province_str = null, city_str = null, district_str = null;
		if (address_id != null) {
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
		return "lxq/addAddress_body";
	}

	@RequestMapping(value = "/region", method = RequestMethod.GET)
	public String region_dispaly(Model model, Long user_id, UserAddress address) {
		List<Region> regions = userAddressService.getChildsByParentId(1);
		address.setProvince_name(userAddressService.getRegionNameByRegionId(address.getProvince()));
		if (address.getCity() != null) {
			address.setCity_name(userAddressService.getRegionNameByRegionId(address.getCity()));
			List<Region> regions1 = userAddressService.getChildsByParentId(address.getProvince());
			model.addAttribute("regions1", regions1);
		}
		if (address.getCity() != null) {
			address.setDistrict_name(userAddressService.getRegionNameByRegionId(address.getDistrict()));
			List<Region> regions2 = userAddressService.getChildsByParentId(address.getCity());
			model.addAttribute("regions2", regions2);
		}
		model.addAttribute("regions", regions);
		model.addAttribute("address", address);
		model.addAttribute("user_id", user_id);
		return "lxq/region_body";
	}

	@RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
	public String deleteAddress_dispaly(Model model, Long user_id, Long address_id, RedirectAttributes attr) {
		userAddressService.deleteAddress(address_id);
		attr.addAttribute("user_id", user_id);
		return "redirect:/user/address_body";
	}

	@RequestMapping(value = "/updateAddress", method = RequestMethod.GET)
	public String updateAddress_dispaly(Model model, Long user_id, UserAddress address, RedirectAttributes attr) {
		if (address.isIs_default() == true) {
			userAddressService.changeDefaultToZero(user_id);
		}
		if (address.getAddress_id() != null) {
			userAddressService.updateAddressByAddress(address);
		} else {
			userAddressService.addAddress(address);
		}
		attr.addAttribute("user_id", user_id);
		return "redirect:/user/address_body";
	}

	@RequestMapping(value = "/region_back", method = RequestMethod.GET)
	public String region_back_dispaly(Model model, Long user_id, UserAddress address) {
		String province_str = userAddressService.getRegionNameByRegionId(address.getProvince());
		String city_str = userAddressService.getRegionNameByRegionId(address.getCity());
		String district_str = userAddressService.getRegionNameByRegionId(address.getDistrict());
		model.addAttribute("province_str", province_str);
		model.addAttribute("city_str", city_str);
		model.addAttribute("district_str", district_str);
		model.addAttribute("address", address);
		model.addAttribute("user_id", user_id);
		return "lxq/addAddress_body";
	}

	@RequestMapping(value = "/regionCity", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getRegion_city(Integer province, HttpServletRequest request) {
		/*
		 * Integer province =
		 * Integer.parseInt(request.getParameter("province"));
		 */
		System.out.println(province);
		List<Region> cities = userAddressService.getChildsByParentId(province);
		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");

		Map<String, Object> ReturnMAP = new HashMap<String, Object>();
		ReturnMAP.put("cities", cities);
		return ReturnMAP;
	}

	@RequestMapping(value = "/region_district", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getRegion_district(Integer city, HttpServletRequest request) {
		List<Region> districts = userAddressService.getChildsByParentId(city);
		Map<String, Object> ReturnMAP = new HashMap<String, Object>();
		ReturnMAP.put("districts", districts);
		return ReturnMAP;
	}

	/*
	 * @RequestMapping(value = "/reviseAddress/{id}", method =
	 * RequestMethod.GET) public String reviseAddress(@PathVariable long id,
	 * HttpSession session, Model model) { Address address =
	 * addressService.queryAddress(id); model.addAttribute("address", address);
	 * return "lxq/addressRevise"; }
	 */

	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String kartIndex(Model model, HttpSession session) {
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("userMessageService", userMessageService.getUserByUserId(userId));
		return "lxq/setmessage";
	}

	/*
	 * @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	 * public String updateAddress(Model model, HttpSession session,
	 * HttpServletRequest request) { String consignee =
	 * request.getParameter("consignee"); String telephone =
	 * request.getParameter("telephone");
	 * 
	 * long id = Long.parseLong(request.getParameter("id")); Address address =
	 * new Address(); address.setConsignee(consignee);
	 * address.setTelephone(telephone); address.setId(id); if
	 * (addressService.updateAddress(address) > 0) { return
	 * "redirect:/user/selectAddress";
	 * 
	 * } return "wrong";
	 * 
	 * }
	 */
	/*
	 * @RequestMapping(value = "/toAddAddress", method = RequestMethod.GET)
	 * public String toAddAddress(Model model, HttpSession session) { return
	 * "lxq/addAddress"; }
	 */

	/*
	 * @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	 * public String addAddress(Model model, HttpSession session,
	 * HttpServletRequest request) { String consignee =
	 * request.getParameter("consignee"); String telephone =
	 * request.getParameter("telephone"); Integer province = new
	 * Integer(request.getParameter("povince")); Integer city = new
	 * Integer(request.getParameter("city")); Integer district = new
	 * Integer(request.getParameter("district")); String detail =
	 * request.getParameter("detail");
	 * 
	 * Address address = new Address(); address.setCity(city);
	 * address.setConsignee(consignee); address.setDistrict(district);
	 * address.setProvince(province); address.setDetail(detail);
	 * 
	 * Long userId = Long.valueOf(session.getAttribute("userId").toString());
	 * address.setUser_id(userId); addressService.addAddress(address); return
	 * "redirect:/user/selectAddress"; }
	 */

	/*
	 * @RequestMapping(value = "/selectAddress", method = RequestMethod.GET)
	 * public String selectAddress(Model model, HttpSession session) {
	 * 
	 * Long userId = Long.valueOf(session.getAttribute("userId").toString());
	 * model.addAttribute("addressList", addressService.selectAddress(userId));
	 * return "lxq/address"; }
	 */

	@RequestMapping(value = "/re_address", method = RequestMethod.GET)
	public String kartIndex1(Model model, HttpSession session) {
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("userMessageService", userMessageService.getUserByUserId(userId));
		return "lxq/address";
	}

	@RequestMapping(value = "/collect", method = RequestMethod.GET)
	public String yartIndex(Model model, HttpSession session) {
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("myCollectService", myCollectService.getGoodsListByUserId(userId));
		return "lxq/mycollect";
	}

	@RequestMapping(value = "/wait_pay", method = RequestMethod.GET)
	public String bartIndex(Model model, HttpSession session) {
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("orderInfoService", orderService.getOrderByStatus(userId, 0));
		return "lxq/orderlist_unpay";
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String fartIndex(Model model, HttpSession session) {
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("orderInfoService", orderService.getOrderByStatus(userId, 5));
		return "lxq/orderlist_cancel";
	}

	@RequestMapping(value = "/orderlist", method = RequestMethod.GET)
	public String hartIndex(Model model, HttpSession session) {
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("orderInfoService", orderService.getOrderByUser_id(userId));
		return "lxq/orderlist";
	}

	@RequestMapping(value = "/wait_re", method = RequestMethod.GET)
	public String dartIndex(Model model, HttpSession session) {
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("orderInfoService", orderService.getOrderByStatus(userId, 3));
		return "lxq/orderlist_unre";
	}

	@RequestMapping(value = "/al_re", method = RequestMethod.GET)
	public String eartIndex(Model model, HttpSession session) {
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("orderInfoService", orderService.getOrderByStatus(userId, 4));
		return "lxq/orderlist_re";
	}

	@RequestMapping(value = "orderlist_/{id}", method = RequestMethod.GET)
	public String commitReceive(@PathVariable Long id, Model model, HttpSession session) {
		orderService.receiveOrder(id);
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("orderInfoService", orderService.getOrderByStatus(userId, 3));
		return "lxq/orderlist_unre";
	}

	@RequestMapping(value = "/cancelOrder/{id}", method = RequestMethod.GET)
	public String cancelOrder(@PathVariable Long id, Model model, HttpSession session) {
		orderService.cancelOrder(id);
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("orderInfoService", orderService.getOrderByStatus(userId, 2));
		return "lxq/orderlist_unpay";
	}

	@RequestMapping(value = "/changenickname", method = RequestMethod.POST)
	public String goodsDetail4(Model model, HttpSession session, HttpServletRequest request) {
		String str1 = request.getParameter("InputName");
		userMessageService.updatenickname(str1);
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("userMessageService", userMessageService.getUserByUserId(userId));
		return "lxq/setmessage";
	}

	@RequestMapping(value = "/changetel", method = RequestMethod.POST)
	public String goodsDetail5(Model model, HttpSession session, HttpServletRequest request) {
		String str1 = request.getParameter("InputTel");
		System.out.println(str1);
		userMessageService.updatetel(str1);
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("userMessageService", userMessageService.getUserByUserId(userId));
		return "lxq/setmessage";
	}

	@RequestMapping(value = "/collection/delete/{id}", method = RequestMethod.GET)
	public String goodsDetail2(@PathVariable Long id, Model model, HttpSession session) {
		myCollectService.deleteCollectByGoodsId(id);
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("myCollectService", myCollectService.getGoodsListByUserId(userId));
		return "lxq/mycollect";
	}

	@RequestMapping(value = "/collection/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteCollection(long goodsId, Model model, HttpSession session) {
		myCollectService.deleteCollectByGoodsId(goodsId);
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		Map<String, Object> ReturnMAP = new HashMap<String, Object>();
		ReturnMAP.put("myCollectService", myCollectService.getGoodsListByUserId(userId));
		return ReturnMAP;
	}

	@RequestMapping(value = "/collection/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addCollection(long goodsId, Model model, HttpSession session) {
		myCollectService.addCollectByGoodsId(goodsId);
		Long userId = Long.valueOf(session.getAttribute("userId").toString());

		Map<String, Object> ReturnMAP = new HashMap<String, Object>();
		ReturnMAP.put("myCollectService", myCollectService.getGoodsListByUserId(userId));
		return ReturnMAP;

	}

}
