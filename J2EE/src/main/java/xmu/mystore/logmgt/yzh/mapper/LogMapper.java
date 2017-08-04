package xmu.mystore.logmgt.yzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mystore.logmgt.yzh.model.Log;

@Component("142528_logMapper")
public interface LogMapper {
	
	List<Log> getAllLog();
	
	List<Log> getLogByTime(@Param("start")String start, @Param("end")String end);
	
	void addLog(Log log);
}
