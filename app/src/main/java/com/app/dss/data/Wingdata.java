package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Wingdata {
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
    @SerializedName("wing_list")
    public ArrayList<Winglistdata> wing_list;

    public ArrayList<Winglistdata> getWing_list() {
        return wing_list;
    }

    public void setWing_list(ArrayList<Winglistdata> wing_list) {
        this.wing_list = wing_list;
    }
}
