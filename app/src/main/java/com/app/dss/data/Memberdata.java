package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Memberdata {
    @SerializedName("status")
    public String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @SerializedName("msg")
    public String msg;
    @SerializedName("wing_list_user")
    public ArrayList<Memberlistdata> wing_list_user;

    public ArrayList<Memberlistdata> getWing_list_user() {
        return wing_list_user;
    }

    public void setWing_list_user(ArrayList<Memberlistdata> wing_list_user) {
        this.wing_list_user = wing_list_user;
    }
}
