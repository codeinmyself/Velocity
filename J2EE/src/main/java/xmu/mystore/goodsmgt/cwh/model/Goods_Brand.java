package xmu.mystore.goodsmgt.cwh.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="goods_brand")
@DynamicUpdate(true)
public class Goods_Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="goods_brand_id",nullable=false)
	private Long id;//品牌id
	
	@Column(name="goods_brand_name",nullable=false,unique=true)
	@Pattern(regexp="[\\S]{1,20}",message="{valid.name}")
	private String name;//品牌名称
	
	@Column(name="goods_brand_website")
	@Pattern(regexp="(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*$",message="{valid.website}")
	private String website;//品牌网址
	
	@Column(name="goods_brand_description")
	@Length(min=0,max=255,message="{valid.description}")
	private String description;//品牌描述
	
	@Column(name="goods_brand_type")
	private Tnt type;//品牌状态(是否在前台显示)
	
	@OneToMany(mappedBy="brand")
	private List<Goods> goodsx;
	
	
	public List<Goods> getGoodsx() {
		return goodsx;
	}
	public void setGoodsx(List<Goods> goodsx) {
		this.goodsx = goodsx;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Tnt getType() {
		return type;
	}
	public void setType(Tnt type) {
		this.type = type;
	}
	
	public String toString(){
		return "id:"+id+"\n"+
				"name:"+name+"\n"+
				"website:"+website+"\n"+
				".....\n";
	}
}
