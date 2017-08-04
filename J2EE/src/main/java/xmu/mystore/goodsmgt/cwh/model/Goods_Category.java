package xmu.mystore.goodsmgt.cwh.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="goods_category")
@DynamicUpdate(true)
public class Goods_Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="goods_category_id",nullable=false)
	private Long id;//品类id
	
	@Column(name="goods_category_name",unique=true)
	@Pattern(regexp="[\\S]{1,20}",message="{valid.name}")
	private String name;//品类名
	
	@JoinColumn(name="goods_category_upper_category_id",nullable=true)
	@ManyToOne(fetch=FetchType.EAGER)
	private Goods_Category upper_category;//上级品类
	
	@Column(name="goods_category_rank")
	@NotNull(message="{valid.rank}")
	private Integer rank;//品类等级
	
	@Column(name="goods_category_type")
	@NotNull(message="{valid.type}")
	private Integer type;//品类状态(目前是否还在前台显示)
	
	@Column(name="goods_category_priority")
	@Range(min=0,max=255,message="{valid.priority}")
	@NotNull(message="{valid.priority}")
	private Integer priority;//品类前台显示顺序
	
	@OneToMany(mappedBy="category")
	private List<Goods> goodsx;//该类别的商品集
	
	@OneToMany(mappedBy="upper_category",cascade={CascadeType.ALL})
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("priority")
	private List<Goods_Category> childCatagory;
	
	
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
	public Goods_Category getUpper_category() {
		return upper_category;
	}
	public void setUpper_category(Goods_Category upper_category) {
		this.upper_category = upper_category;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public List<Goods> getGoodsx() {
		return goodsx;
	}
	public void setGoodsx(List<Goods> goodsx) {
		this.goodsx = goodsx;
	}
	public List<Goods_Category> getChildCatagory() {
		return childCatagory;
	}
	public void setChildCatagory(List<Goods_Category> childCatagory) {
		this.childCatagory = childCatagory;
	}
	
	public String toString(){
		return "id:"+id+"\n"+
				"name:"+name+"\n"+
				"rank:"+rank+"\n"+
				".....\n";
	}
}
