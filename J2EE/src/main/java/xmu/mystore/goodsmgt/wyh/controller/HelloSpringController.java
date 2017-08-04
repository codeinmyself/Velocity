package xmu.mystore.goodsmgt.wyh.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import xmu.mystore.goodsmgt.wyh.model.Brand;
import xmu.mystore.goodsmgt.wyh.model.Category;
import xmu.mystore.goodsmgt.wyh.model.Goods;
import xmu.mystore.goodsmgt.wyh.model.Stand;
import xmu.mystore.goodsmgt.wyh.service.BrandService;
import xmu.mystore.goodsmgt.wyh.service.CategoryService;
import xmu.mystore.goodsmgt.wyh.service.GoodsService;
import xmu.mystore.goodsmgt.wyh.service.IGoodsService;
import xmu.mystore.goodsmgt.wyh.service.StandService;
import xmu.mystore.goodsmgt.wyh.service.impl.IGoodsServiceImpl;

@Controller
@RequestMapping(value = "/")
public class HelloSpringController {
    String message = "Welcome to Spring MVC!";
 
    public IGoodsService getIGoodsService() {
		return iGoodsService;
	}
    @Autowired
	public void setIGoodsService(IGoodsService iGoodsService) {
		this.iGoodsService = iGoodsService;
	}

	private IGoodsService iGoodsService;
    
    public StandService getStandService() {
		return standService;
	}
    @Autowired
	public void setStandService(StandService standService) {
		this.standService = standService;
	}
	public BrandService getBrandService() {
		return brandService;
	}
	@Autowired
	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	private StandService standService;
    
    private BrandService brandService;
    
    private GoodsService goodsService;
    
    private CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}
	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	@Autowired
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	@RequestMapping({"/GoodsAddResult"})
	public ModelAndView goodsAddResult(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = request.getParameter("goodsName");
		String id = request.getParameter("goodsId");
		String brandId = request.getParameter("goodsBrandName");
		String standName = request.getParameter("goodsStandName");
		String stockCount = request.getParameter("goodsStockCount");
		String marketPrice = request.getParameter("goodsMarketPrice");
		String midUserPrice = request.getParameter("goodsMidUserPrice");
		String defaultExpress = request.getParameter("goodsDefaultExpress");
		String weight = request.getParameter("goodsWeight");
		Goods goods=new Goods();
		goods.setName(name);
		if(!id.equals(""))
			goods.setId(Long.valueOf(id));
		goods.setSerial_code(String.valueOf(System.currentTimeMillis()));
		goods.setStock_count(Integer.valueOf(stockCount));
		goods.setMarket_price(Double.valueOf(marketPrice));
		goods.setMid_user_price(Double.valueOf(midUserPrice));
		goods.setDefault_express(defaultExpress);
		goods.setWeight(Double.valueOf(weight));
		goods.setBrand_id(Integer.valueOf(brandId));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		goods.setAdd_time(df.format(new Date()));
		goodsService.insertGoods(goods);
		
		Stand stand=new Stand();
		stand.setGoodsId(Integer.valueOf(id));
		stand.setMarketPrice(Double.valueOf(marketPrice));
		stand.setMidUserPrice(Double.valueOf(midUserPrice));
		stand.setOffMarketTime("2018-01-01 00:00:00");
		stand.setOnMarketTime(df.format(new Date()));
		stand.setPreSaleCount(20);
		stand.setRealPrice(Double.valueOf("11"));
		
		standService.insertStand(stand);
		
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}
	
	@RequestMapping({"/BrandAddResult"})
	public ModelAndView BrandAddResult(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		String website = request.getParameter("website");
		String description = request.getParameter("description");
		if(website.indexOf("http://")<0)
			website="http://"+website;
		Brand brand=new Brand();
		brand.setDescription(description);
		brand.setWebsite(website);
		brand.setName(name);
		brand.setType(0);
		brandService.insertBrand(brand);
		
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}
	
	@RequestMapping({"/StandAddResult"})
	public ModelAndView StandAddResult(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String onMarketTime = request.getParameter("onMarketTime");
		String offMarketTime = request.getParameter("offMarketTime");
		String preSaleCount = request.getParameter("preSaleCount");
		
		
		
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}
	
	@RequestMapping({"/CategoryAddResult"})
	public ModelAndView CategoryAddResult(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		String rank = request.getParameter("rank");
		
		Category category=new Category();
		category.setName(name);
		category.setRank(Integer.valueOf(rank));
		category.setPriority(0);
		category.setType(0);
		category.setUpperCategoryId(0);
		
		categoryService.insertCategory(category);
		
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}
	
	@RequestMapping({"/GoodsUpdate"})
	public ModelAndView goodsUpdate(String goodsId){
		ModelAndView mView=new ModelAndView("wyh/GoodsUpdate");
		Goods goods=goodsService.getGoodsById(goodsId);
		mView.addObject("goods", goods);
		return mView;
	}

	@RequestMapping({"/GoodsUpdateResult"})
	public ModelAndView goodsUpdateResult(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String goodsId = request.getParameter("goodsId");
		String serialCode = request.getParameter("serialCode");
		String name = request.getParameter("goodsName");
		String brandId = request.getParameter("goodsBrandName");
		String stockCount = request.getParameter("goodsStockCount");
		String marketPrice = request.getParameter("goodsMarketPrice");
		String midUserPrice = request.getParameter("goodsMidUserPrice");
		String defaultExpress = request.getParameter("goodsDefaultExpress");
		String weight = request.getParameter("goodsWeight");
		
		Goods goods=new Goods();
		goods.setId(Long.valueOf(goodsId));
		goods.setSerial_code(serialCode);
		goods.setName(name);
		goods.setStock_count(Integer.valueOf(stockCount));
		goods.setMarket_price(Double.valueOf(marketPrice));
		goods.setMid_user_price(Double.valueOf(midUserPrice));
		goods.setDefault_express(defaultExpress);
		goods.setWeight(Double.valueOf(weight));
		goods.setBrand_id(Integer.valueOf(brandId));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		goods.setLast_modified_time(df.format(new Date()));
		goodsService.updateGoodsById(goods);
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}


	@RequestMapping({"/StandUpdate"})
	public ModelAndView standUpdate(String standId){
		ModelAndView mView=new ModelAndView("wyh/StandUpdate");
		Stand stand=standService.getStandById(standId);
		mView.addObject("stand", stand);
		mView.addObject("message", message);
		return mView;
	}
	
	@RequestMapping({"/StandUpdateResult"})
	public ModelAndView standUpdateResult(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String standId=request.getParameter("standId");
		String onMarketTime=request.getParameter("onMarketTime");
		String offMarketTime=request.getParameter("offMarketTime");
		String preSaleCount=request.getParameter("preSaleCount");
		
		standService.updateStand(standId, onMarketTime, offMarketTime, preSaleCount);
		
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}
	

	
	@RequestMapping({"/BrandUpdate"})
	public ModelAndView brandUpdate(String brandId){
		ModelAndView mView=new ModelAndView("wyh/BrandUpdate");
		Brand brand=brandService.getBrandById(brandId);
		mView.addObject("brand", brand);
		return mView;
	}
	
	@RequestMapping({"/BrandUpdateResult"})
	public ModelAndView brandUpdateResult(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String brandId=request.getParameter("brandId");
		String name=request.getParameter("name");
		String website=request.getParameter("website");
		String description=request.getParameter("description");
		if(website.indexOf("http://")<0)
			website="http://"+website;
		Brand brand=new Brand();
		brand.setBrandId(Integer.valueOf(brandId));
		brand.setDescription(description);
		brand.setName(name);
		brand.setWebsite(website);
		brandService.updateBrandById(brand);
		
		
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}
	
	@RequestMapping({"/CategoryUpdate"})
	public ModelAndView categoryUpdate(String categoryId){
		ModelAndView mView=new ModelAndView("wyh/CategoryUpdate");
		Category category=categoryService.getCategoryById(categoryId);
		mView.addObject("category", category);
		return mView;
	}
	
	@RequestMapping({"/CategoryUpdateResult"})
	public ModelAndView categoryUpdateResult(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String categoryId=request.getParameter("categoryId");
		String name=request.getParameter("name");
		String rank=request.getParameter("rank");
		Category category=new Category();
		category.setId(Integer.valueOf(categoryId));
		category.setName(name);
		category.setRank(Integer.valueOf(rank));
		categoryService.updateCategory(category);
		
		
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}
	
	
	@RequestMapping({"/AddPage"})
	public ModelAndView goodsAdd(String a){
		String destination=a+"Add";
		ModelAndView mView=new ModelAndView("wyh/"+destination);
		return mView;
	}
	
	@RequestMapping({"/","/home"})
	public ModelAndView homePage(){
		ModelAndView mView=new ModelAndView("wyh/home");
		List<Goods> gs = goodsService.getAllGoods();
		List<Category> categorys=categoryService.getAllCategory();
		List<Stand> stands=standService.getAllStand();
		List<Brand> brands=brandService.getAllBrand();
		mView.addObject("goods", gs);
		mView.addObject("categorys", categorys);
		mView.addObject("stands", stands);
		mView.addObject("brands", brands);
		mView.addObject("message", message);
		return mView;
	}
	
	@RequestMapping({"/GoodsDelete"})
	public ModelAndView goodsDelete(String goodsId){
		goodsService.deleteGoodsById(goodsId);
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}
	
	@RequestMapping({"/BrandDelete"})
	public ModelAndView brandDelete(String brandId){
		brandService.deleteBrandById(brandId);
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}
	
	@RequestMapping({"/CategoryDelete"})
	public ModelAndView categoryDelete(String categoryId){
		categoryService.deleteCategoryById(categoryId);
		ModelAndView mView=new ModelAndView("redirect:/home");
		return mView;
	}
	
	@RequestMapping({"/wuyihao"})
	public String wuyihao(){
		
		return "home";
	}

}