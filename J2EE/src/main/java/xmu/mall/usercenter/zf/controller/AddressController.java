package xmu.mall.usercenter.zf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import xmu.mall.usercenter.zf.model.Region;
import xmu.mall.usercenter.zf.model.User_address;
import xmu.mall.usercenter.zf.service.AddressService;


@Controller
public class AddressController {

	@Autowired
	@Qualifier("addressService")
	private AddressService addressService;
	
	// 管理地址界面
	@RequestMapping(value="manageAddress", method=RequestMethod.GET)
	public String home(long uid, Model model)
	{
		List<User_address> addresses = this.addressService.getUserAddress(uid);
		model.addAttribute("addresses", addresses);
		model.addAttribute("uid", uid);
		
		return "manageAddress";
	}
	
	// 编辑地址
	@RequestMapping(value="editAddress", method=RequestMethod.GET)
	public String editAddress(long aid, Model model)
	{
		User_address address = this.addressService.getAddressById(aid);
		model.addAttribute("address", address);
		model.addAttribute("type", "edit");

		return "editAddress";
	}

	// 删除地址
	@RequestMapping(value="deleteAddress", method=RequestMethod.GET)
	public String deleteAddress(long uid, long aid, Model model)
	{
		this.addressService.deleteAddress(aid);

		List<User_address> addresses = this.addressService.getUserAddress(uid);
		model.addAttribute("addresses", addresses);
		model.addAttribute("uid", uid);

		return "manageAddress";
	}

	// 新建地址
	@RequestMapping(value="newAddress", method=RequestMethod.GET)
	public String newAddress(long uid, Model model)
	{
		User_address address  = new User_address();
		address.setAddress_id(-1);
		address.setUser_id(uid);

		model.addAttribute("address", address);
		model.addAttribute("type", "new");
		
		return "editAddress";
	}

	// 保存地址
	@RequestMapping(value="saveAddress", method=RequestMethod.POST)
	public String addAddress(User_address address, Model model){
		if((address.getConsignee() == null || address.getConsignee() == "") ||
				(address.getTelephone() == null || address.getTelephone() == "") ||
				(address.getZipcode() == null || address.getZipcode() == "") ||
				(address.getProvince_name() == null || address.getProvince_name() == "") ||
				(address.getDetail() == null || address.getDetail() == "")){

			System.out.print("必须填完！");
			model.addAttribute("address", address);
			return "editAddress";
		}

		this.addressService.saveAddress(address);

		List<User_address> addresses = this.addressService.getUserAddress(address.getUser_id());
		model.addAttribute("addresses", addresses);
		model.addAttribute("uid", address.getUser_id());

		return "manageAddress";
	}

	// 更新地址
	@RequestMapping(value="updateAddress", method=RequestMethod.POST)
	public String updateAddress(User_address address, Model model){
		if((address.getConsignee() == null || address.getConsignee() == "") ||
				(address.getTelephone() == null || address.getTelephone() == "") ||
				(address.getZipcode() == null || address.getZipcode() == "") ||
				(address.getProvince_name() == null || address.getProvince_name() == "") ||
				(address.getDetail() == null || address.getDetail() == "")){

			System.out.print("必须填完！");
			model.addAttribute("address", address);
			return "editAddress";
		}

		this.addressService.updateAddress(address);

		List<User_address> addresses = this.addressService.getUserAddress(address.getUser_id());
		model.addAttribute("addresses", addresses);
		model.addAttribute("uid", address.getUser_id());

		return "manageAddress";
	}

	// 选择省份
	@RequestMapping(value="selectProvince", method=RequestMethod.POST)
	public String selectProvince(User_address address, Model model){

		List<Region> regions = this.addressService.getAllProvince(address.getCountry());
		model.addAttribute("slt", "province");
		model.addAttribute("address", address);
		model.addAttribute("regions", regions);
		return "region";
	}


	// 选择城市
	@RequestMapping(value="selectCity", method=RequestMethod.POST)
	public String selectCity(User_address address, Model model){

		List<Region> regions = this.addressService.getAllCity(address.getProvince());
		model.addAttribute("slt", "city");
		model.addAttribute("address", address);
		model.addAttribute("regions", regions);
		return "region";
	}

	// 选择市区
	@RequestMapping(value="selectDistrict", method=RequestMethod.POST)
	public String selectDistrict(User_address address, Model model){

		List<Region> regions = this.addressService.getAllDistrict(address.getCity());
		model.addAttribute("slt", "district");
		model.addAttribute("address", address);
		model.addAttribute("regions", regions);
		return "region";
	}

	// 选择地区成功，返回地址界面
	@RequestMapping(value="selectDone", method=RequestMethod.POST)
	public String selectDone(User_address address, Model model){
		model.addAttribute("address", address);
		return "editAddress";
	}

	/**
	 * 切换默认地址
	 * uid: 替换的地址ID（新默认地址）
	 * */
	@RequestMapping(value="changeDefault", method=RequestMethod.POST)
	@ResponseBody
	public String changeDefault(long uid){
		if(this.addressService.changeDefault(uid))
			return "success";

		return "error";
	}
}
