package com.loginapp.loginapp.model;

/**
 * Created by Shyam_2 on 12/18/2016.
 */

public class Registration {

    private long regId;
    private String email;
    private String password;
    private String mobile;

    public long getRegId() {
        return regId;
    }

    public void setRegId(long regId) {
        this.regId = regId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



}
