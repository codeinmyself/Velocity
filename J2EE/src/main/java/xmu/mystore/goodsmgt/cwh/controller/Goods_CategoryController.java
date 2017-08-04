package xmu.mystore.goodsmgt.cwh.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import xmu.mystore.goodsmgt.cwh.model.Goods_Brand;
import xmu.mystore.goodsmgt.cwh.model.Goods_Category;
import xmu.mystore.goodsmgt.cwh.service.Goods_BrandService;
import xmu.mystore.goodsmgt.cwh.service.Goods_CategoryService;

@Controller("goods_categoryController")  
@RequestMapping("/goods_categoryAction")//相对于根目录
public class Goods_CategoryController {

	@Autowired  
    private Goods_CategoryService service;
	
	@RequestMapping
    public ModelAndView init() {
        ModelAndView view = new ModelAndView("/goods_category", "goods_Category", new Goods_Category());
        return view;
    }
	
	@RequestMapping(value="/addGoods_Category", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute @Valid Goods_Category category, BindingResult result) {
        ModelAndView view = new ModelAndView("goods_category");//品类添加界面       
        if(result.hasErrors()) {
        	view.addObject("goods_Category", category);
            return view;
        }else{
        	service.addGoods_Category(category);
        	return new ModelAndView("success");
        }        
    }
	
	@RequestMapping(value="/editGoods_Category", method=RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute @Valid Goods_Category category, BindingResult result) {
        ModelAndView view = new ModelAndView("/goods_category");//品类修改界面       
        if(result.hasErrors()) {
        	view.addObject("goods_Category", category);
            return view;
        }else{
        	service.addGoods_Category(category);
        	return new ModelAndView("success");
        }        
    }
}


