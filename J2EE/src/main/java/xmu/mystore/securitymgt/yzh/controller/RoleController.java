package xmu.mystore.securitymgt.yzh.controller;

import java.util.List;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mall.usercenter.zy.model.User;
import xmu.mall.usercenter.zy.service.IUserService;
import xmu.mystore.securitymgt.yzh.model.OrganizationPermission;
import xmu.mystore.securitymgt.yzh.model.Permission;
import xmu.mystore.securitymgt.yzh.model.Role;
import xmu.mystore.securitymgt.yzh.model.RoleInfo;
import xmu.mystore.securitymgt.yzh.model.RolePermission;
import xmu.mystore.securitymgt.yzh.service.PermissionService;
import xmu.mystore.securitymgt.yzh.service.RolePermissionService;
import xmu.mystore.securitymgt.yzh.service.RoleService;
import xmu.mystore.securitymgt.yzh.service.UserTypeService;
import xmu.mystore.logmgt.yzh.annotation.ControllerLogger;
import xmu.mystore.securitymgt.yzh.annotation.HasAuthority;

// 角色管理

@Controller
@RequestMapping(value = "Role")
public class RoleController {
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping(method = RequestMethod.GET)
	@HasAuthority(authority="select_role")
	@ControllerLogger(description="查看角色信息", operatorObeject="Role")
	public String allRolePage(Model model) {
		List<Role> roleList = roleService.getAllRole();
		model.addAttribute("roleList", roleList);
		
//		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
//		String result123 = encoder.encodePassword("111", null);
//		System.out.println(result123);
		
		return "/yzh/AllRole";
	}
	
	@RequestMapping(value = "modifyRole", method = RequestMethod.GET)
	@HasAuthority(authority="update_role")
	@ControllerLogger(description="修改角色信息", operatorObeject="RoleInfo")
	public String modifyRole(
			@ModelAttribute("roleInfo") RoleInfo roleInfo, 
			Model model) {
		roleInfo = roleService.getRoleInfoById(roleInfo.getRole_id());

		model.addAttribute("roleInfo", roleInfo);
		return "/yzh/modifyRole";
	}

	@RequestMapping(value = "modifyRole", method = RequestMethod.POST)
	@HasAuthority(authority="update_role")
	@ControllerLogger(description="保存角色信息", operatorObeject="RoleInfo")
	public String saveRole(
			@ModelAttribute("roleInfo") RoleInfo roleInfo, 
			Model model) {
//		System.out.println("in save Role"+roleInfo.toString());
		roleService.saveRoleInfo(roleInfo);
		return "redirect:/Role";
	}
	
	@RequestMapping(value = "deleteRole",method = RequestMethod.POST)
	@HasAuthority(authority="delete_role")
	@ControllerLogger(description="删除角色", operatorObeject="Role")
	public String deleteRole(
			@ModelAttribute("roleInfo") RoleInfo roleInfo, 
			Model model) {
//		System.out.println("in delete Role"+roleInfo.toString());
		roleService.deleteRoleInfo(roleInfo);
		return "redirect:/Role";
	}
	
	@RequestMapping(value = "addRoleInfo", method = RequestMethod.GET)
	@HasAuthority(authority="insert_role")
	@ControllerLogger(description="添加角色", operatorObeject="addRole")
	public String addRoleInfo(Model model) {
		return "/yzh/addRole";
	}
	
	@RequestMapping(value = "addRoleInfo", method = RequestMethod.POST)
	@HasAuthority(authority="insert_role")
	@ControllerLogger(description="添加角色", operatorObeject="RoleInfo")
	public String addRoleInfo(
			@ModelAttribute("roleInfo") RoleInfo roleInfo, 
			Model model) {
//		System.out.println("in add Role"+roleInfo.toString());
		// 这里在添加了商店信息之后再使用商店id进行设置，现在先使用默认的1L
		roleInfo.setOrganization_id(1L);
		roleService.addRoleInfo(roleInfo);
		return "redirect:/Role";
	}
	
	
	@RequestMapping(value = "modifyRolePermission", method = RequestMethod.GET)
	@HasAuthority(authority="update_role")
	@ControllerLogger(description="修改角色权限", operatorObeject="RolePermission")
	public String modifyRolePermission(
			@ModelAttribute("roleInfo") RoleInfo roleInfo, 
			Model model) {
		roleInfo = roleService.getRoleInfoById(roleInfo.getRole_id());
		List<Permission> permissionList = roleService.getAllPermissionByRoleId(roleInfo.getRole_id());
		
		model.addAttribute("roleInfo", roleInfo);
		model.addAttribute("permissionList", permissionList);
		return "/yzh/modifyRolePermission";
	}
	
	@RequestMapping(value = "deleteRolePermission",method = RequestMethod.GET)
	@HasAuthority(authority="update_role")
	@ControllerLogger(description="删除角色权限", operatorObeject="RolePermission")
	public String deleteRolePermission(
			@ModelAttribute("role") Role role, 
			Model model) {
		System.out.println("in delete Role"+role.toString());
		roleService.deleteRole(role);
		return "redirect:/Role/modifyRolePermission?role_id="+role.getRole_id();
	}
	
	//addRolePermission
	@RequestMapping(value = "addRolePermission", method = RequestMethod.GET)
	@HasAuthority(authority="update_role")
	@ControllerLogger(description="添加角色权限", operatorObeject="RolePermission")
	public String addRolePermissionPage(
			@ModelAttribute("roleInfo") RoleInfo roleInfo,
			Model model) {
		roleInfo = roleService.getRoleInfoById(roleInfo.getRole_id());
		List<Permission> permissionList = roleService.getAllNotExistintPermissionByRoleId(roleInfo.getRole_id());
		model.addAttribute("roleInfo", roleInfo);
		model.addAttribute("permissionList", permissionList);
		return "/yzh/addRolePermission";
	}
	
	@RequestMapping(value = "addRolePermissionByPermissionId", method = RequestMethod.GET)
	@HasAuthority(authority="update_role")
	@ControllerLogger(description="添加角色权限", operatorObeject="RolePermission")
	public String addRolePermission(
			@ModelAttribute("role") Role role, 
			Model model) {

		role.setOrganization_id(roleService.getRoleInfoById(role.getRole_id()).getOrganization_id());
		System.out.println("in add Role permission"+role.toString());
		roleService.addRole(role);
	 
		return "redirect:/Role/addRolePermission?role_id="+role.getRole_id();
	}
}
