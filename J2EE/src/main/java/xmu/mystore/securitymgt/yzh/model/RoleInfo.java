package xmu.mystore.securitymgt.yzh.model;

import java.io.Serializable;

public class RoleInfo implements Serializable{

	private static final long serialVersionUID = 6811311757793351759L;

	private Long role_id;
	private Long organization_id;
	private String role_name;
	private String description;
	
	
	public RoleInfo(){
		
	}

	public RoleInfo(Long role_id, Long organization_id, String role_name, String description) {
		super();
		this.role_id = role_id;
		this.organization_id = organization_id;
		this.role_name = role_name;
		this.description = description;
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

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RoleInfo [role_id=" + role_id + ", organization_id=" + organization_id + ", role_name=" + role_name
				+ ", description=" + description + "]";
	}
	
	
}
