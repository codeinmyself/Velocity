package xmu.mystore.logmgt.xlx.model;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable{

	private long id;
	private Date createtime;
	private long userid;
	private String ExceptionCode;    //异常代码
	private String ExceptionDetails;  //异常信息
	private String OperateObject;
//	private String params;   //请求参数
	private String methodname;
	private String description;  //方法描述
	private boolean success;

	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getOperateObject() {
		return OperateObject;
	}
	public void setOperateObject(String operateObject) {
		OperateObject = operateObject;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getExceptionCode() {
		return ExceptionCode;
	}
	public void setExceptionCode(String string) {
		ExceptionCode = string;
	}
	public String getExceptionDetails() {
		return ExceptionDetails;
	}
	public void setExceptionDetails(String exceptionDetails) {
		ExceptionDetails = exceptionDetails;
	}
//	public String getParams() {
//		return params;
//	}
//	public void setParams(String params) {
//		this.params = params;
//	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
