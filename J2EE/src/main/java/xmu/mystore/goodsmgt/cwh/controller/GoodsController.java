package xmu.mystore.goodsmgt.cwh.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import xmu.mystore.goodsmgt.cwh.model.Goods;
import xmu.mystore.goodsmgt.cwh.service.GoodsService;

@Controller("goodsController")  
@RequestMapping("/goodsAction")//相对于根目录
public class GoodsController {

	@Autowired  
    private GoodsService service;
	
	@RequestMapping
    public ModelAndView init() {
        ModelAndView view = new ModelAndView("/goods", "goods", new Goods());
        return view;
    }
	
	@RequestMapping(value="/addGoods", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute @Valid Goods goods, BindingResult result) {
        ModelAndView view = new ModelAndView("/goods");//商品添加界面
        view.addObject("goods", goods);
        
        if(result.hasErrors()) {
            return view;
        }else{
        	service.addGoods(goods);
        	return new ModelAndView("success");
        }        
    }
}
