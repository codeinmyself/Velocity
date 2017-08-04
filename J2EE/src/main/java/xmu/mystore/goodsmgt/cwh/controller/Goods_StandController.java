package xmu.mystore.goodsmgt.cwh.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import xmu.mystore.goodsmgt.cwh.dao.Goods_StandDao;
import xmu.mystore.goodsmgt.cwh.dao.TimeConvertor;
import xmu.mystore.goodsmgt.cwh.model.Goods;
import xmu.mystore.goodsmgt.cwh.model.Goods_Stand;
import xmu.mystore.goodsmgt.cwh.service.GoodsService;
import xmu.mystore.goodsmgt.cwh.service.Goods_StandService;

@Controller("goods_standController")  
@RequestMapping("/goods_standAction")//相对于根目录
public class Goods_StandController {

	@Autowired  
    private Goods_StandService service;
	
	@Autowired
	private Goods_StandDao gsdao;
	
	@RequestMapping
    public ModelAndView init(@RequestParam("goods_stand_id") String stand_id ) {
        ModelAndView view = new ModelAndView("/goods_stand", "goods_Stand", gsdao.getById(Long.parseLong(stand_id)));
        return view;
    }
	
	@RequestMapping(value="/editGoods_Stand", method=RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute @Valid Goods_Stand stand, BindingResult result) {
        ModelAndView view = new ModelAndView("/goods_stand");//商品添加界面
        view.addObject("goods_Stand", stand);
        
        if(result.hasErrors()) {
            return view;
        }else{
        	if (!service.eidtGoods_Stand(stand)){
        		result.addError(new ObjectError("off_market_time","下架时间应在上架时间之后！"));
        		return view;
        	}
        	return new ModelAndView("success");
        }        
    }
}
