package xmu.mystore.securitymgt.yzh.controller;

import java.util.List;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import xmu.mystore.securitymgt.yzh.annotation.HasAuthority;
import xmu.mystore.securitymgt.yzh.model.Permission;
import xmu.mystore.securitymgt.yzh.model.Role;
import xmu.mystore.securitymgt.yzh.model.RoleInfo;
import xmu.mystore.securitymgt.yzh.model.RolePermission;
import xmu.mystore.securitymgt.yzh.model.User;
import xmu.mystore.securitymgt.yzh.model.UserRole;
import xmu.mystore.securitymgt.yzh.service.RolePermissionService;
import xmu.mystore.securitymgt.yzh.service.RoleService;
import xmu.mystore.securitymgt.yzh.service.UserService;
import xmu.mystore.securitymgt.yzh.service.UserTypeService;

import xmu.mystore.logmgt.yzh.annotation.ControllerLogger;

//用户角色管理
@Controller
@RequestMapping(value = "UserRole")
public class UserRoleController {
	
	@Autowired
	@Qualifier("142528_userService")
	private UserService userService;

	@Autowired
	private UserTypeService userTypeService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	@HasAuthority(authority="select_user_role")
	@ControllerLogger(description="查看用户角色", operatorObeject="UserRole")
	public String allUsersPage(Model model) {
		List<User> userList = userService.getAllUsers();
		model.addAttribute("userList", userList);
		return "/yzh/AllUserRole";
	}
	// modifyUserRole

	@RequestMapping(value = "modifyUserRole", method = RequestMethod.GET)
	@HasAuthority(authority="update_user_role")
	@ControllerLogger(description="修改用户角色", operatorObeject="UserRole")
	public String modifyUserRole(@ModelAttribute("user") User user, Model model) {
		user = userService.getUserByID(user.getUser_id());
		List<RoleInfo> roleInfoList = roleService.getAllRoleInfoByUserId(user.getUser_id());
//		System.out.println(user.toString());
//		System.out.println(roleInfoList.toString());
		model.addAttribute("user", user);
		model.addAttribute("roleInfoList", roleInfoList);
		return "/yzh/modifyUserRole";
	}

	@RequestMapping(value = "deleteUserRole", method = RequestMethod.GET)
	@HasAuthority(authority="delete_user_role")
	@ControllerLogger(description="删除用户角色", operatorObeject="UserRole")
	public String deleteUserRole(@ModelAttribute("user_role") UserRole user_role, Model model) {
//		System.out.println("in delete Role" + user_role.toString());
		roleService.deleteUserRole(user_role);
		return "redirect:/UserRole/modifyUserRole?user_id=" + user_role.getUser_id();
	}

	@RequestMapping(value = "addUserRole", method = RequestMethod.GET)
	@HasAuthority(authority="update_user_role")
	@ControllerLogger(description="添加用户角色", operatorObeject="UserRole")
	public String addUserRolePage(@ModelAttribute("user") User user, Model model) {
		user = userService.getUserByID(user.getUser_id());
		List<RoleInfo> roleInfoList = roleService.getAllNotExistintRoleInfoByUserId(user.getUser_id());
		model.addAttribute("user", user);
		model.addAttribute("roleInfoList", roleInfoList);
		return "/yzh/addUserRole";
	}

	@RequestMapping(value = "addUserRoleByRoleInfoId", method = RequestMethod.GET)
	@HasAuthority(authority="update_user_role")
	@ControllerLogger(description="添加用户角色", operatorObeject="UserRole")
	public String addUserRole(@ModelAttribute("user_role") UserRole user_role, Model model) {

//		System.out.println("in add user Role" + user_role.toString());
		roleService.addUserRole(user_role);
		return "redirect:/UserRole/addUserRole?user_id=" + user_role.getUser_id();
	}
	
	@RequestMapping(value = "viewUserRole", method = RequestMethod.GET)
	@HasAuthority(authority="select_user_role")
	@ControllerLogger(description="查看用户角色", operatorObeject="UserRole")
	public String viewUserRolePage(@ModelAttribute("user") User user, Model model) {
		user = userService.getUserByID(user.getUser_id());
		List<RoleInfo> roleInfoList = roleService.getAllRoleInfoByUserId(user.getUser_id());
		model.addAttribute("user", user);
		model.addAttribute("roleInfoList", roleInfoList);
		return "/yzh/viewUserRole";
	}
}
