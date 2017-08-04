package xmu.mystore.logmgt.yzh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mystore.logmgt.yzh.model.Log;
import xmu.mystore.logmgt.yzh.service.LogService;

@Controller("142528_LogController")
@RequestMapping(value="MallMgt/log")
public class LogController {

	@Autowired
	@Qualifier("142528_logService")
	private LogService logService;
	
	/* 显示全部日志记录*/
	@RequestMapping(value="all", method=RequestMethod.GET)
	public String showAllLog(Model model)
	{
		List<Log> logs = logService.getAllLog();
		model.addAttribute("logs",logs); 
		return "/yzh/allLog";
	}
	
	/* 根据时间查询日志记录 */
	@RequestMapping(value="searchLog",method=RequestMethod.POST)
	public String added(@RequestParam(value="start")String start, @RequestParam(value="end")String end,Model model)
	{
		System.out.println("start"+start);
		System.out.println("end"+end);
		Date sdate = null, edate = null;
		List<Log> logs = new ArrayList<Log>(0);
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); 
		
			if(!start.isEmpty() && !end.isEmpty() ){ // 开始时间到结束时间之间的所有日志记录 
				logs = logService.getLogByTime(start, end);
			} else if(!start.isEmpty() && end.isEmpty() ) { // 开始时间往后的所有日志记录
				logs = logService.getLogByTime(start, "2117-06-17");
			} else if (start.isEmpty() && !end.isEmpty() ) { // 结束日期往前的所有日志记录
				logs = logService.getLogByTime(format.format(0), end);
			} else { // 如果没有指定任何时间，那么显示所有日志记录
				logs = logService.getAllLog();	
			}
		
	    model.addAttribute("logs", logs);
		return "/yzh/allLog";
	}
	
	/* 跳转至精准查询页面 */
	@RequestMapping(value="search",method=RequestMethod.GET)
	public String search(Model model)
	{
		return "/yzh/logSearch";
	}
}

