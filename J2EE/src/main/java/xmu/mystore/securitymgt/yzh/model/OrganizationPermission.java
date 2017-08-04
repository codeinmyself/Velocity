package xmu.mystore.securitymgt.yzh.model;

import java.io.Serializable;

public class OrganizationPermission implements Serializable{

	private static final long serialVersionUID = 8871445475324694706L;
	private Long op_id;
	private Long organization_id;
	private String organization_name;
	private Long permission_id;
	private Permission permission;
	private String description;
	
	public OrganizationPermission(){
	}

	public OrganizationPermission(Long op_id, Long organization_id, String organization_name, Long permission_id,
			Permission permission, String description) {
		super();
		this.op_id = op_id;
		this.organization_id = organization_id;
		this.organization_name = organization_name;
		this.permission_id = permission_id;
		this.permission = permission;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Long getOp_id() {
		return op_id;
	}

	public void setOp_id(Long op_id) {
		this.op_id = op_id;
	}

	@Override
	public String toString() {
		return "OrganizationPermission [op_id=" + op_id + ", organization_id=" + organization_id
				+ ", organization_name=" + organization_name + ", permission_id=" + permission_id + ", permission="
				+ permission + ", description=" + description + "]";
	}
	
}
