package xmu.mystore.goodsmgt.zlt_rz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.goodsmgt.zlt_rz.model.Brand;
import xmu.mystore.goodsmgt.zlt_rz.model.Category;
import xmu.mystore.goodsmgt.zlt_rz.model.Goods;
import xmu.mystore.goodsmgt.zlt_rz.service.BrandService;
import xmu.mystore.goodsmgt.zlt_rz.service.CategoryService;
import xmu.mystore.goodsmgt.zlt_rz.service.GoodsService;
import xmu.mystore.logmgt.yzh.annotation.ControllerLogger;
import xmu.mystore.securitymgt.yzh.annotation.HasAuthority;

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
	@HasAuthority(authority="select_goods")
	@ControllerLogger(description="查看商品", operatorObeject="goods")
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
	@HasAuthority(authority="insert_goods")
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
	@HasAuthority(authority="insert_goods")
	@ControllerLogger(description="添加商品", operatorObeject="goods")
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
	@HasAuthority(authority="update_goods")
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
	@HasAuthority(authority="update_goods")
	@ControllerLogger(description="修改商品信息", operatorObeject="goods")
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
	@HasAuthority(authority="delete_goods")
	@ControllerLogger(description="删除商品", operatorObeject="goods")
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
