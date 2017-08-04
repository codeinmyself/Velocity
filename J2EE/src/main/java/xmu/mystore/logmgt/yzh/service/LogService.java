package xmu.mystore.logmgt.yzh.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xmu.mystore.logmgt.yzh.model.Log;

public interface LogService {
	List<Log> getAllLog();
	
	List<Log> getLogByTime(@Param("start")String start, @Param("end")String end);
	
	void addLog(Log log);
}
