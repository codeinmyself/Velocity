package xmu.mystore.securitymgt.yzh.model;

import java.io.Serializable;

public class Organization  implements Serializable{

	private static final long serialVersionUID = -4893348544041254236L;

	private Long organization_id;
	private String organization_name;
	private String organization_address;
	private String organization_description;
	private String enable;
	
	public Organization(){
	}
	
	public Organization(Long organization_id, String organization_name, String organization_address,
			String organization_description) {
		super();
		this.organization_id = organization_id;
		this.organization_name = organization_name;
		this.organization_address = organization_address;
		this.organization_description = organization_description;
	}

	public Long getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(Long organization_id) {
		this.organization_id = organization_id;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getOrganization_address() {
		return organization_address;
	}

	public void setOrganization_address(String organization_address) {
		this.organization_address = organization_address;
	}

	public String getOrganization_description() {
		return organization_description;
	}

	public void setOrganization_description(String organization_description) {
		this.organization_description = organization_description;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
}
