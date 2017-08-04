package xmu.mystore.ordersmgt.zjq.model;

/**
 * Created by Administrator on 2017/6/2.
 */
public class UserStatus {
    private long user_id;
    private int status;

    public UserStatus() {
    }

    public UserStatus(long user_id, int status) {
        this.user_id = user_id;
        this.status = status;
    }

    public long getUser_id() {
        return user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
