package xmu.mystore.securitymgt.yzh.model;

import java.io.Serializable;

public class Role implements Serializable{

	private static final long serialVersionUID = 6811311757793351759L;

	private Long role_id;
	private Long organization_id;
	private Long permission_id;
	
	public Role(){
		
	}
	
	public Role(Long role_id, Long organization_id, Long permission_id) {
		super();
		this.role_id = role_id;
		this.organization_id = organization_id;
		this.permission_id = permission_id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public Long getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(Long organization_id) {
		this.organization_id = organization_id;
	}
	public Long getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(Long permission_id) {
		this.permission_id = permission_id;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", organization_id=" + organization_id + ", permission_id=" + permission_id
				+ "]";
	}
	
}
