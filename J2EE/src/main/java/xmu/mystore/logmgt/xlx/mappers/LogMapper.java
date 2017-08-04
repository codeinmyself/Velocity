package xmu.mystore.logmgt.xlx.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import xmu.mystore.logmgt.xlx.model.Log;

public interface LogMapper {
	/**
	 * 查询所日志记录
	 * @author XingLX
	 * @return
	 */
	public List<Log> getAllLogs();
	
	/**
	 * 根据时间段查询记录
	 * @author XingLX
	 * @param stime
	 * @param ptime
	 * @return
	 */
	public List<Log> getLogsByTime(@Param(value="start_time")long stime,@Param(value="stop_time")long ptime);
	/**
	 * 保存记录
	 * @author XingLX
	 * @param createtime
	 * @param userid
	 * @param code
	 * @param details
	 * @param OperateObject
	 * @param param
	 * @param method
	 * @param description
	 * @param success
	 */
	public void save(@Param(value="createtime")Date createtime,@Param(value="userid")long userid,@Param(value="ExceptionCode")String code,@Param(value="ExceptionDetails")String details,@Param(value="OperateObject")String OperateObject,@Param(value="methodname")String method,@Param(value="description")String description,@Param(value="success")boolean success);
}
