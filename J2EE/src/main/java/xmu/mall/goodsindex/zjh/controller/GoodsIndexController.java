package xmu.mall.goodsindex.zjh.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mystore.goodsmgt.zlt.model.SelectParameters;
import xmu.mall.goodsindex.zjh.constant.ProgramConstant;
import xmu.mall.goodsindex.zjh.constant.RenderAjaxReturnResult;
import xmu.mall.goodsindex.zjh.model.AjaxReturnResult;
/*import xmu.mall.usercenter.zy.model.UserCollection;
import xmu.mall.usercenter.zy.service.IUserCollectionService;*/
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.goodsmgt.zlt.service.GoodsMgtService;

/**
 * 主页控制器
 * @author ZengJieHang
 *
 */
@Controller
@RequestMapping(value="/")
public class GoodsIndexController 
{
	@Autowired
	@Qualifier("GoodsMgtService")
	private GoodsMgtService goodsMgtService;
	
	/*@Autowired
	@Qualifier("userCollectionService")
	private IUserCollectionService userCollectionService;
	*/
	private Logger logger=Logger.getLogger("GoodsIndexController");
	
	/**
	 * 返回主页,页面初始化进入此方法
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public String home(Model model,HttpSession session)
	{
		//session.setAttribute("userId", 1);//设置用户session
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		
		//初始化查询参数
		SelectParameters select=new SelectParameters();
		select.initialPage(ProgramConstant.INDEX_INITIAL_PAGE, ProgramConstant.INDEX_PIGE_SIZE);
		
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(select));
		return "zjh/index";
	}
	
	/**
	 * 返回商品详情页,页面路径/index/GoodsDetail/商品id
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="index/goodsDetail/{id}",method=RequestMethod.GET)
	public String goodsDetail(
			@PathVariable Long id,
			Model model,
			HttpSession session)
	{
		model.addAttribute("goods", goodsMgtService.getGoodsByGoodsId(id));
		
		/*Object userId=session.getAttribute("userId");
		if(userId!=null&&!userId.toString().equals(""))
		{
			long userIdLong=Long.valueOf(userId.toString());
			UserCollection uCollection=userCollectionService.hasCollection(userIdLong, id);
			if(uCollection==null)
				model.addAttribute("isCollected","N");
			else
				model.addAttribute("isCollected","Y");
		}*/
		return "zjh/goodsDetail";
	}
	
	/**
	 * 根据商品类别筛选商品,实现主页的分类功能
	 * @param selectParameters
	 * @param model
	 * @return
	 */
	@RequestMapping(value="index/choose",method=RequestMethod.GET)
	public String indexChooseTypeHome(
			@ModelAttribute("selects")SelectParameters selectParameters,
			Model model)
	{
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		selectParameters.initialPage(ProgramConstant.INDEX_INITIAL_PAGE, ProgramConstant.INDEX_PIGE_SIZE);
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(selectParameters));
		return "zjh/index";
	}
	
	/**
	 * 通过ajax获取更多商品
	 * @param selectParameters
	 * @param model
	 * @return
	 */
	@RequestMapping(value="index/getGoodsListByAjax",method=RequestMethod.POST)
	@ResponseBody
	public List<Goods> getGoodsListByAjax(
			@ModelAttribute("selects")SelectParameters selectParameters,
			Model model)
	{
		List<Goods> goodsList=goodsMgtService.getGoodsBy(selectParameters);
		return goodsList;
	}
	
	/**
	 * 查找商品
	 * @param selectParameters
	 * @param model
	 * @return
	 */
	@RequestMapping(value="index/changeInSearchPage",method=RequestMethod.POST)
	public String orderGoods(
			@ModelAttribute("selects") SelectParameters selectParameters,
			Model model)
	{
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		model.addAttribute("brandList", goodsMgtService.getBrandList());
		//初始化页码和页大小
		selectParameters.initialPage(ProgramConstant.INDEX_INITIAL_PAGE, ProgramConstant.INDEX_PIGE_SIZE);
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(selectParameters));
		return "zjh/search";
	}
	
	/**
	 * 查找商品
	 * @param selectParameters
	 * @param model
	 * @return
	 */
	@RequestMapping(value="index/search",method=RequestMethod.POST)
	public String searchGoods(
			@ModelAttribute("selects") SelectParameters selectParameters,
			Model model)
	{
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		model.addAttribute("brandList", goodsMgtService.getBrandList());
		//初始化页码和页大小
		selectParameters.initialPage(ProgramConstant.INDEX_INITIAL_PAGE, ProgramConstant.INDEX_PIGE_SIZE);
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(selectParameters));
		return "zjh/search";
	}

	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String loginWithPath(@ModelAttribute("urlPath")String urlPath,HttpSession session)
	{
		if(urlPath!=null&&!urlPath.equals(""))
		{
			session.setAttribute("path", urlPath);
		}
		return "zbh/login";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnResult logout(Model model
			,HttpSession session)
	{
		Object obj = session.getAttribute("userId");
		if(obj==null||"".equals(obj.toString()))
		{
			return RenderAjaxReturnResult.renderErrorResult("用户尚未登陆");
		}
		else
		{
			session.removeAttribute("userId");
			return RenderAjaxReturnResult.renderSuccessResult("退出成功!");
		}
	}
}
