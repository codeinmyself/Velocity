package xmu.mystore.securitymgt.yzh.model;

import java.io.Serializable;
/*
 * 用户的类型
 * */
public class UserType implements Serializable{

	private static final long serialVersionUID = -901350652189437687L;

	private Long user_id;
	private String type;
	
	public UserType(){
		
	}
	
	public UserType(Long user_id, String type) {
		super();
		this.user_id = user_id;
		this.type = type;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
