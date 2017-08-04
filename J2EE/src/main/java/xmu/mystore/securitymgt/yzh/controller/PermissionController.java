package xmu.mystore.securitymgt.yzh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mall.usercenter.zy.service.IUserService;
import xmu.mystore.goodsmgt.zlt.model.Brand;
import xmu.mystore.logmgt.yzh.annotation.ControllerLogger;
import xmu.mystore.securitymgt.yzh.model.Organization;
import xmu.mystore.securitymgt.yzh.model.OrganizationPermission;
import xmu.mystore.securitymgt.yzh.model.RolePermission;
import xmu.mystore.securitymgt.yzh.service.OrganizationPermissionService;
import xmu.mystore.securitymgt.yzh.service.OrganizationService;
import xmu.mystore.securitymgt.yzh.service.RolePermissionService;

@Controller
@RequestMapping(value = "/MallMgt/Permission")
public class PermissionController {

	@Autowired
	private OrganizationPermissionService organizationPermissionService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ControllerLogger(description="查看组织权限", operatorObeject="OrganizationPermission")
	public String allPermissionPage(Model model) {
		List<OrganizationPermission> organizationPermissionList = organizationPermissionService.getAllOrganizationPermission();
		model.addAttribute("organizationPermissionList", organizationPermissionList);
		return "/yzh/allOrganizationPermission";
	}

	
	@RequestMapping(value = "modifyOrganizationPermission", method = RequestMethod.GET)
	@ControllerLogger(description="修改组织权限", operatorObeject="OrganizationPermission")
	public String modifyOrganizationPermission(
			@ModelAttribute("organizationPermission") OrganizationPermission organizationPermission, 
			Model model) {
		organizationPermission = organizationPermissionService.getOrganizationPermissionByOp_Id(organizationPermission.getOp_id());
//		System.out.println(organizationPermission.toString());
		model.addAttribute("organizationPermission", organizationPermission);
		return "/yzh/modifyOrganizationPermission";
	}

	@RequestMapping(value = "modifyOrganizationPermission",method = RequestMethod.POST)
	@ControllerLogger(description="查看组织权限", operatorObeject="OrganizationPermission")
	public String saveOrganizationPermission(
			@ModelAttribute("organizationPermission") OrganizationPermission organizationPermission, 
			Model model) {
//		System.out.println(organizationPermission.toString());
		organizationPermissionService.modifyOrganizationPermission(organizationPermission);
		return "redirect:/MallMgt/Permission";
	}
	
	@RequestMapping(value = "deleteOrganizationPermission",method = RequestMethod.POST)
	@ControllerLogger(description="删除组织权限", operatorObeject="OrganizationPermission")
	public String deleteOrganizationPermission(
			@ModelAttribute("organizationPermission") OrganizationPermission organizationPermission, 
			Model model) {
		System.out.println(organizationPermission.toString());
		//brandService.modifyBrand(brand);
		organizationPermissionService.deletePermission(organizationPermission);
		return "redirect:/MallMgt/Permission";
	}
	
	@RequestMapping(value = "addOrganizationPermission", method = RequestMethod.GET)
	@ControllerLogger(description="添加组织权限", operatorObeject="OrganizationPermission")
	public String addOrganizationPermissionPage(Model model) {
		return "/yzh/addOrganizationPermission";
	}
	
	@RequestMapping(value = "addOrganizationPermission", method = RequestMethod.POST)
	public String addOrganizationPermission(@ModelAttribute("organizationPermission") OrganizationPermission organizationPermission, 
			Model model) {
//		System.out.println(organizationPermission.toString());
		organizationPermissionService.addPermission(organizationPermission);
		return "redirect:/MallMgt/Permission";
	}
}
