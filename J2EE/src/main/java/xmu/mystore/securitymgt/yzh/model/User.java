package xmu.mystore.securitymgt.yzh.model;

import java.io.Serializable;

/**
 * @Description: 用户实体类
 * @ClassNmae: User
 * @author copy from ZhengYang 
 * @version: [1.0]
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = -1602869510905935769L;
	long user_id;	
	String user_name;	//用户姓名
	String password;	//用户密码（进行加密，用rsa加密，注意保留公钥和私钥【有问题可以问曹将将】）
	String mobile_phone;	//用户联系方式
	String imagepath;       //头像(0-0有时间、能做的话就做吧，不能做也放个静态图片上去)
	
	String real_name;
	
	Long openid;
	Long recommend_user_id;
	String sex;
	String birthday;
	String reg_time;
	String last_login;
	String last_ip;
	
	String enable;      // 是否启用
	String user_type;   // 用户类型
	
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Long getOpenid() {
		return openid;
	}
	public void setOpenid(Long openid) {
		this.openid = openid;
	}
	public Long getRecommend_user_id() {
		return recommend_user_id;
	}
	public void setRecommend_user_id(Long recommend_user_id) {
		this.recommend_user_id = recommend_user_id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getReg_time() {
		return reg_time;
	}
	public void setReg_time(String reg_time) {
		this.reg_time = reg_time;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public String getLast_ip() {
		return last_ip;
	}
	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getUser_id() {
		return user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getPassword() {
		return password;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", mobile_phone="
				+ mobile_phone + ", imagepath=" + imagepath + ", real_name=" + real_name + ", openid=" + openid
				+ ", recommend_user_id=" + recommend_user_id + ", sex=" + sex + ", birthday=" + birthday + ", reg_time="
				+ reg_time + ", last_login=" + last_login + ", last_ip=" + last_ip + ", enable=" + enable
				+ ", user_type=" + user_type + "]";
	}
	
	
}
