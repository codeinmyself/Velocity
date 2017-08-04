package xmu.mystore.goodsmgt.lcf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.goodsmgt.lcf.model.Stand;
import xmu.mystore.goodsmgt.lcf.service.StandService;

@Controller
@RequestMapping(value = "Stand")
public class StandController {

	/**
	 * 返回所有上下架的页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String allStandPage(Model model) {
		List<Stand> standList = standService.getAllStand();
		model.addAttribute("standList", standList);
		return "/lcfgm/allStand";
	}

	/**
	 * 返回对应上下架的修改页面
	 * 
	 * @param stand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modifyStand", method = RequestMethod.GET)
	public String modifyStandPage(@ModelAttribute("stand") Stand stand, Model model) {
		// get this stand
		stand = standService.getAStand(stand);
		model.addAttribute("stand", stand);
		return "/lcfgm/modifyStand";
	}

	/**
	 * 处理修改的上下架，返回所有上下架的页面
	 * 
	 * @param stand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modifyStand", method = RequestMethod.POST)
	public String modifyStand(@ModelAttribute("stand") Stand stand, Model model) {
		standService.modifyStand(stand);
		return "redirect:/Stand";
	}

	@Autowired
	private StandService standService;
}
