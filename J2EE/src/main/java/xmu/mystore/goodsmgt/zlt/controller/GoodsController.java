package xmu.mystore.goodsmgt.zlt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.goodsmgt.zlt.model.Brand;
import xmu.mystore.goodsmgt.zlt.model.Category;
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.goodsmgt.zlt.service.BrandService;
import xmu.mystore.goodsmgt.zlt.service.CategoryService;
import xmu.mystore.goodsmgt.zlt.service.GoodsService;

/**
 * @author zhenglongtian
 *
 */
@Controller
@RequestMapping(value = "Goods")
public class GoodsController {

	/**
	 * 返回所有商品的页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String allGoodsPage(Model model) {
		List<Goods> goodsList = goodsService.getAllGoods();
		model.addAttribute("goodsList", goodsList);
		return "/zlt/allGoods";
	}

	/**
	 * 返回添加商品的页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "addGoods", method = RequestMethod.GET)
	public String addGoodsPage(Model model) {
		List<Brand> brandList = brandService.getShowBrand();
		model.addAttribute("brandList", brandList);
		List<Category> categoryList = categoryService.getShowCategory();
		model.addAttribute("categoryList", categoryList);
		return "/zlt/addGoods";
	}

	/**
	 * 处理添加的商品，返回所有商品的页面
	 * 
	 * @param goods
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "addGoods", method = RequestMethod.POST)
	public String addGoods(@ModelAttribute("goods") Goods goods, Model model) {
		goodsService.addGoods(goods);
		return "redirect:/Goods";
	}

	/**
	 * 返回对应商品的修改页面
	 * 
	 * @param goods
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modifyGoods", method = RequestMethod.GET)
	public String modifyGoodsPage(@ModelAttribute("goods") Goods goods, Model model) {
		// get this goods
		goods = goodsService.getAGoods(goods);
		model.addAttribute("goods", goods);
		// get the brand of the goods
		Brand brand = goodsService.getBrand(goods);
		model.addAttribute("brand", brand);
		// get the category of the goods
		Category category = goodsService.getCategory(goods);
		model.addAttribute("category", category);
		// get the brand list
		List<Brand> brandList = brandService.getShowBrand();
		model.addAttribute("brandList", brandList);
		// get the category list
		List<Category> categoryList = categoryService.getShowCategory();
		model.addAttribute("categoryList", categoryList);
		return "/zlt/modifyGoods";
	}

	/**
	 * 处理修改的商品，返回所有商品的页面
	 * 
	 * @param goods
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modifyGoods", method = RequestMethod.POST)
	public String modifyGoods(@ModelAttribute("goods") Goods goods, Model model) {
		goodsService.modifyGoods(goods);
		return "redirect:/Goods";
	}

	/**
	 * 删除对应的商品
	 * 
	 * @param goods
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "deleteGoods", method = RequestMethod.POST)
	public String deleteGoods(@ModelAttribute("goods") Goods goods, Model model) {
		goodsService.deleteGoods(goods);
		return "redirect:/Goods";
	}

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BrandService brandService;
}
