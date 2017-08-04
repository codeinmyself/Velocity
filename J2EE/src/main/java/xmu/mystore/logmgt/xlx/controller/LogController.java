package xmu.mystore.logmgt.xlx.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.github.pagehelper.PageInfo;

import xmu.mystore.logmgt.xlx.Util.TransTime;
import xmu.mystore.logmgt.xlx.model.Log;
import xmu.mystore.logmgt.xlx.service.LogService;


@Controller
public class LogController extends BaseController {
	@Autowired
	LogService logservice;

	
	@RequestMapping(value="/log",method=RequestMethod.GET)
	public String getLogs(Model model)
	{

		model.addAttribute("contextPath","http://localhost:8080/JavaEE");
		return "xlx/logs";
	
	}
	
	
	@RequestMapping(value="log/queryBytime", method=RequestMethod.POST)
	@ResponseBody
	public String getLogByTime(Model model,String dateRange,Integer pageNumber,Integer pageSize)
	{
		System.out.println(dateRange);

		try{
			if(dateRange==null||dateRange.equals(""))
			{
				
			
				System.out.println(pageSize);
				PageInfo<Log> pages=new PageInfo<Log>(logservice.getAllLogs(pageNumber, pageSize));
				System.out.println(pages.getPageNum());
				System.out.println(pages.getSize());
				System.out.println(pages.getList().get(2).getId());
			
				return responseSuccess(pages);
				
			}
			else
			{
				String stime=dateRange.split(" - ")[0];
				String ptime=dateRange.split(" - ")[1];
				long start_time=TransTime.getTime(stime);
				long stop_time=TransTime.getTime(ptime);
				PageInfo<Log> pages=new PageInfo<Log>(logservice.QueryByTime(start_time, stop_time, pageNumber, pageSize));
				model.addAttribute("contextPath","http://localhost:8080/JavaEE");
				return responseSuccess(pages);
			
			}
		}catch(Exception e)
		{
			return responseFail(e.getMessage());
		}

	}
	
}
