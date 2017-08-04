package xmu.mystore.logmgt.xlx.service;

import java.util.List;

import xmu.mystore.logmgt.xlx.model.Log;

public interface LogService {
	
	/**
	 * 保存log到数据库
	 * @author XingLX
	 * @param log
	 */
	public void save(Log log);
	
	
	
	 /**
     * 根据时间段条件分页查询
     * @author XingLX
     * @param stimestamp   查询条件的开始时间
     * @param ptimestamp   查询条件的结束时间
     * @param pageNo     页码
     * @param pageSize   每页记录数
     * @return
     */
	public List<Log> QueryByTime(long stimestamp,long ptimestamp,Integer pageNo,Integer pageSize);
	

	
	/**
	 * 分页查询所有的日志
	 * @author XingLX
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Log> getAllLogs(Integer pageNo,Integer pageSize);


}
