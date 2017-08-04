package xmu.mystore.pay.lhg.model;

public class User {
    long user_id; // 用户ID
    String user_name; // 用户名
    String password; // 用户密码（进行加密，用rsa加密，注意保留公钥和私钥【有问题可以问曹将将】）
    String nickname; // 昵称
    String mobile_phone; // 用户联系方式
    String imagepath; // 头像(0-0有时间、能做的话就做吧，不能做也放个静态图片上去)

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", nickname="
                + nickname + ", mobile_phone=" + mobile_phone + ", imagepath=" + imagepath + "]";
    }

}
