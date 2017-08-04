package xmu.mystore.goodsmgt.lcf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.goodsmgt.lcf.model.Category;
import xmu.mystore.goodsmgt.lcf.service.CategoryService;

@Controller
@RequestMapping(value = "Category")
public class CategoryController {

	/**
	 * 返回所有品类的页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String allCategoryPage(Model model) {
		List<Category> categoryList = categoryService.getAllCategory();
		model.addAttribute("categoryList", categoryList);
		return "/lcfgm/allCategory";
	}

	/**
	 * 返回添加品类的页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "addCategory", method = RequestMethod.GET)
	public String addCategoryPage(Model model) {
		List<Category> categoryList = categoryService.getShowCategory();
		model.addAttribute("categoryList", categoryList);
		return "/lcfgm/addCategory";
	}

	/**
	 * 处理添加的品类，返回所有品类的页面
	 * 
	 * @param category
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "addCategory", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		categoryService.addCategory(category);
		return "redirect:/Category";
	}

	/**
	 * 返回对应的品类的修改页面
	 * 
	 * @param category
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modifyCategory", method = RequestMethod.GET)
	public String modifyCategoryPage(@ModelAttribute("category") Category category, Model model) {
		// find this category
		category = categoryService.getACategory(category);
		model.addAttribute("category", category);
		// find upper category
		category = categoryService.getUpperCategory(category);
		model.addAttribute("upperCategory", category);
		List<Category> categoryList = categoryService.getShowCategory();
		model.addAttribute("categoryList", categoryList);
		return "/lcfgm/modifyCategory";
	}

	/**
	 * 处理修改的品类，返回所有品类的页面
	 * 
	 * @param category
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modifyCategory", method = RequestMethod.POST)
	public String modifyCategory(@ModelAttribute("category") Category category, Model model) {
		categoryService.modifyCategory(category);
		return "redirect:/Category";
	}

	/**
	 * 删除对应的品类，返回所有品类的页面
	 * 
	 * @param category
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "deleteCategory", method = RequestMethod.POST)
	public String deleteCategory(@ModelAttribute("category") Category category, Model model) {
		categoryService.deleteCategory(category);
		return "redirect:/Category";
	}

	@Autowired
	private CategoryService categoryService;
}
