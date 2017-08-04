package xmu.mystore.goodsmgt.lcf.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.goodsmgt.lcf.model.Brand;
import xmu.mystore.goodsmgt.lcf.service.BrandService;

@Controller
@RequestMapping(value = "Brand")
public class BrandController {

	/**
	 * 返回所有品牌的列表页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String allBrandPage(Model model) {
		List<Brand> brandList = brandService.getAllBrand();
		model.addAttribute("brandList", brandList);
		return "/lcfgm/allBrand";
	}

	/**
	 * 返回添加品牌的页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "addBrand", method = RequestMethod.GET)
	public String addBrandPage(Model model) {
		return "/lcfgm/addBrand";
	}

	/**
	 * 处理添加的品牌，回到所有品牌的列表页面
	 * 
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "addBrand", method = RequestMethod.POST)
	public String addBrand(@ModelAttribute("brand") Brand brand, Model model) {
		brandService.addBrand(brand);
		return "redirect:/Brand";
	}

	/**
	 * 返回要修改的品牌的页面
	 * 
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modifyBrand", method = RequestMethod.GET)
	public String modifyBrandPage(@ModelAttribute("brand") Brand brand, Model model) {
		brand = brandService.getABrand(brand);
		model.addAttribute("brand", brand);
		return "/lcfgm/modifyBrand";
	}

	/**
	 * 处理修改后的品牌，返回所有品牌列表的页面
	 * 
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modifyBrand", method = RequestMethod.POST)
	public String modifyBrand(@ModelAttribute("brand") Brand brand, Model model) {
		brandService.modifyBrand(brand);
		return "redirect:/Brand";
	}

	/**
	 * 删除对应品牌，返回所有品牌列表的页面
	 * 
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "deleteBrand", method = RequestMethod.POST)
	public String deleteBrand(@ModelAttribute("brand") Brand brand, Model model) {
		brandService.deleteBrand(brand);
		return "redirect:/Brand";
	}

	@Autowired
	private BrandService brandService;

	private Logger logger = Logger.getLogger("BrandController.class");
}
