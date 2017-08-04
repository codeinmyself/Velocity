package xmu.mystore.securitymgt.yzh.model;

import java.io.Serializable;

public class Permission implements Serializable{

	private static final long serialVersionUID = -3127746678765605688L;
	
	private Long permission_id;
	private String permission_name;
	private String permission;
	private String permission_description;
	
	public Permission(){
		
	}
	
	public Permission(Long permission_id, String permission, String permission_description) {
		super();
		this.permission_id = permission_id;
		this.permission = permission;
		this.permission_description = permission_description;
	}
	
	public Long getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(Long permission_id) {
		this.permission_id = permission_id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getPermission_description() {
		return permission_description;
	}
	public void setPermission_description(String permission_description) {
		this.permission_description = permission_description;
	}

	public String getPermission_name() {
		return permission_name;
	}

	public void setPermission_name(String table_name) {
		this.permission_name = table_name;
	}

	@Override
	public String toString() {
		return "Permission [permission_id=" + permission_id + ", table_name=" + permission_name + ", permission="
				+ permission + ", permission_description=" + permission_description + "]";
	}
	
}
