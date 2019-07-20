package com.workdistrict.onetouch.letswork;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pojo_SignUp {

    @SerializedName("user_email")
    @Expose
    private String email;

    @SerializedName("user_number")
    @Expose
    private String number;

    @SerializedName("user_full_name")
    @Expose
    private String fullName;

    @SerializedName("user_password")
    @Expose
    private String password;

    @SerializedName("users_cnic")
    @Expose
    private String cnic;


    public Pojo_SignUp(String email, String number, String fullName, String password, String cnic) {

        this.email = email;
        this.number = number;
        this.fullName = fullName;
        this.password = password;
        this.cnic = cnic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {

        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }
}

