package com.hjc.entity;

/**
 * Created by GeniusV on 4/3/18.
 */
public class User {
    private String useName;
    private String pwd;
    private String email;
    private String tel;

    public User(String useName, String pwd, String email, String tel) {
        this.useName = useName;
        this.pwd = pwd;
        this.email = email;
        this.tel = tel;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
