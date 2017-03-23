package com.rh.udcs.beans;

import java.io.Serializable;

/**
 * Created by hui.ran on 2017/3/22.
 */
public class SysUserInfoBean implements Serializable{

    String userName;
    String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
