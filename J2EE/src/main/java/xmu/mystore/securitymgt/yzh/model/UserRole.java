package xmu.mystore.securitymgt.yzh.model;

import java.io.Serializable;

public class UserRole implements Serializable{

	private static final long serialVersionUID = -5277641848611340945L;

	private Long user_id;
	private Long role_id;
	
	public UserRole(){
		
	}
	
	public UserRole(Long user_id, Long role_id) {
		super();
		this.user_id = user_id;
		this.role_id = role_id;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "UserRole [user_id=" + user_id + ", role_id=" + role_id + "]";
	}
	
}
