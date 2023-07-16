package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Workerdata {
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
    @SerializedName("wstaff_list")
    public ArrayList<Workerlistdata> wstaff_list;

    public ArrayList<Workerlistdata> getWstaff_list() {
        return wstaff_list;
    }

    public void setWstaff_list(ArrayList<Workerlistdata> wstaff_list) {
        this.wstaff_list = wstaff_list;
    }
}
