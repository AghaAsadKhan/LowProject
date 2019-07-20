package com.workdistrict.onetouch.letswork;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pojo_Login {



    @SerializedName("user_email")
    @Expose
    private String email;

    @SerializedName("user_password")
    @Expose
    private String password;

    @SerializedName("device")
    @Expose
    private String device;

    public Pojo_Login(String email, String password, String device) {
        this.email = email;
        this.password = password;
        this.device = device;
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

    public String getMob() {
        return device;
    }

    public void setMob(String device) {
        this.device = device;
    }
}


