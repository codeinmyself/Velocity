package xmu.mystore.securitymgt.yzh.model;

import java.io.Serializable;

public class RolePermission  implements Serializable{
	
	private static final long serialVersionUID = -8437274037766751426L;
	
	private Long role_id;
	private String role_name;
	private String organization_name;
	private String permission;
	private String permission_description;
	private String permission_name;
	
	public RolePermission(){
		
	}

	public RolePermission(Long role_id, String role_name, String organization_name, String permission,
			String permission_description, String table_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.organization_name = organization_name;
		this.permission = permission;
		this.permission_description = permission_description;
		this.permission_name = table_name;
	}

	public String getPermission_name() {
		return permission_name;
	}

	public void setPermission_name(String table_name) {
		this.permission_name = table_name;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
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
	
}
