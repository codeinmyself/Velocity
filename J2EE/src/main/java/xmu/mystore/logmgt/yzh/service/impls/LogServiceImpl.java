package xmu.mystore.logmgt.yzh.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.logmgt.yzh.mapper.LogMapper;
import xmu.mystore.logmgt.yzh.model.Log;
import xmu.mystore.logmgt.yzh.service.LogService;

@Service("142528_logService")
@Transactional
public class LogServiceImpl implements LogService{

	@Autowired
	@Qualifier("142528_logMapper")
	private LogMapper logMapper;
	
	public List<Log> getAllLog() {
		return logMapper.getAllLog();
	}

	public List<Log> getLogByTime(String start, String end) {
		return logMapper.getLogByTime(start, end);
	}

	public void addLog(Log log) {
		logMapper.addLog(log);
	}

}