package xmu.mystore.logmgt.xlx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import xmu.mystore.logmgt.xlx.mappers.LogMapper;
import xmu.mystore.logmgt.xlx.model.Log;
import xmu.mystore.logmgt.xlx.service.LogService;
@Service
@Transactional
public class LogServiceImpl implements LogService {
	@Autowired 
	LogMapper logmapper;

	
	/**
	 * 被切面调用，用于保存log到数据库
	 * @author XingLX
	 * @param Log
	 * @return 
	 */
	@Override
	public void save(Log log) {
	
		logmapper.save(log.getCreatetime(),log.getUserid(),log.getExceptionCode(),log.getExceptionDetails(),log.getOperateObject(),log.getMethodname(),log.getDescription(),log.isSuccess());
	}


    /**
     * 根据条件分页查询
     *
     * @param stimestamp
     * @param ptimestamp
     * @param pageNo
     * @param pageSize
     * @return
     */
	public List<Log> QueryByTime(long stimestamp, long ptimestamp,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);
		List<Log> list=logmapper.getLogsByTime(stimestamp, ptimestamp);
		return list;
	}
	

	/**
	 * 分页查询所有日志记录
	 * @author XingLX
	 * @param pageNo 当前页码
	 * @param pageSize 每页显示的个数
	 * @return List<Log>
	 */
	@Override
	public List<Log> getAllLogs(Integer pageNo,Integer pageSize) {
	PageHelper.startPage(pageNo, pageSize);
	return logmapper.getAllLogs();
}
	
	

}
