package xmu.mystore.securitymgt.yzh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mystore.logmgt.yzh.annotation.ControllerLogger;
import xmu.mystore.securitymgt.yzh.model.Organization;
import xmu.mystore.securitymgt.yzh.service.OrganizationService;
import xmu.mystore.securitymgt.yzh.service.UserService;
import xmu.mystore.securitymgt.yzh.service.UserTypeService;

@Controller
@RequestMapping(value = "/MallMgt/Organization")
public class OrganizationController {
	@Autowired
	@Qualifier("142528_userService")
	private UserService userService;

	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ControllerLogger(description="查看商店信息", operatorObeject="OrganizationInfo")
	public String allGoodsPage(Model model) {
		List<Organization> organizationList = organizationService.getAllOrganization();
		model.addAttribute("organizationList", organizationList);
		return "/yzh/allOrganization";
	}
	
	@RequestMapping(value="/changeOrganizationState", method = RequestMethod.GET)
	@ControllerLogger(description="更改商店状态", operatorObeject="OrganizationState")
	public String changeOrganizationState(@RequestParam("id") Long organization_id, Model model) {
		organizationService.changeOrganizationStateById(organization_id);
		return "redirect:/MallMgt/Organization";
	}
}
