package xmu.mystore.logmgt.yzh.model;

import java.sql.Timestamp;

public class Log {
	private Long id;                           
	private String username;                    
	private String local_ip;
	private String remote_ip;
	private String request_url;
	private String request_method;
	private Timestamp request_time;
	private String resolve_class;
	private String resolve_method;
	private String result;
	private String description;
	private String operator_object;
	
	public Log(){
	}

	public Log(Long id, String username, String local_ip, String remote_ip, String request_url,
			String request_method, Timestamp request_time, String resolve_class, String resolve_method, String result,
			String description, String operatorObject) {
		super();
		this.id = id;
		this.username = username;
		this.local_ip = local_ip;
		this.remote_ip = remote_ip;
		this.request_url = request_url;
		this.request_method = request_method;
		this.request_time = request_time;
		this.resolve_class = resolve_class;
		this.resolve_method = resolve_method;
		this.result = result;
		this.description = description;
		this.operator_object = operatorObject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOperatorObject() {
		return operator_object;
	}

	public void setOperatorObject(String operatorObject) {
		this.operator_object = operatorObject;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocal_ip() {
		return local_ip;
	}

	public void setLocal_ip(String local_ip) {
		this.local_ip = local_ip;
	}

	public String getRemote_ip() {
		return remote_ip;
	}

	public void setRemote_ip(String remote_ip) {
		this.remote_ip = remote_ip;
	}

	public String getRequest_url() {
		return request_url;
	}

	public void setRequest_url(String request_url) {
		this.request_url = request_url;
	}

	public String getRequest_method() {
		return request_method;
	}

	public void setRequest_method(String request_method) {
		this.request_method = request_method;
	}

	public Timestamp getRequest_time() {
		return request_time;
	}

	public void setRequest_time(Timestamp request_time) {
		this.request_time = request_time;
	}

	public String getResolve_class() {
		return resolve_class;
	}

	public void setResolve_class(String resolve_class) {
		this.resolve_class = resolve_class;
	}

	public String getResolve_method() {
		return resolve_method;
	}

	public void setResolve_method(String resolve_method) {
		this.resolve_method = resolve_method;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", username=" + username + ", local_ip=" + local_ip + ", remote_ip=" + remote_ip
				+ ", request_url=" + request_url + ", request_method=" + request_method + ", request_time="
				+ request_time + ", resolve_class=" + resolve_class + ", resolve_method=" + resolve_method + ", result="
				+ result + ", description=" + description + ", operator_object=" + operator_object + "]";
	}

	
}
