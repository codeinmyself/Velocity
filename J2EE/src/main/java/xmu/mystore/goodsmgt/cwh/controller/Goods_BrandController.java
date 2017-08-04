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
import xmu.mystore.goodsmgt.cwh.service.Goods_BrandService;

@Controller("goods_brandController")  
@RequestMapping("/goods_brandAction")//相对于根目录
public class Goods_BrandController {

	@Autowired  
    private Goods_BrandService service;
	
	@RequestMapping
    public ModelAndView init() {
        ModelAndView view = new ModelAndView("/goods_brand", "goods_Brand", new Goods_Brand());
        return view;
    }
	
	@RequestMapping(value="/addGoods_Brand", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute @Valid Goods_Brand brand, BindingResult result) {
        ModelAndView view = new ModelAndView("/goods_brand");//品牌添加界面       
        if(result.hasErrors()) {
        	view.addObject("goods_Brand", brand);
            return view;
        }else{
        	service.addGoods_Brand(brand);
        	return new ModelAndView("success");
        }        
    }
	
	@RequestMapping(value="/editGoods_Brand", method=RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute @Valid Goods_Brand brand, BindingResult result) {
        ModelAndView view = new ModelAndView("/goods_brand");//品牌修改界面       
        if(result.hasErrors()) {
        	view.addObject("goods_Brand", brand);
            return view;
        }else{
        	service.addGoods_Brand(brand);
        	return new ModelAndView("success");
        }        
    }
}

