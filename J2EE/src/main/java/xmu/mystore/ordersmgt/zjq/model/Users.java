package xmu.mystore.ordersmgt.zjq.model;

import java.math.BigInteger;

/**
 * Created by Administrator on 2017/5/20.
 */


public class Users {
    private long user_id;       //用户ID
    private String user_name;   //用户名
    private String password;    //用户密码
    private String mobile_phone;//用户联系方式

    public Users() {
    }

    public Users(long user_id, String user_name, String password, String mobile_phone) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.mobile_phone = mobile_phone;
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
}
