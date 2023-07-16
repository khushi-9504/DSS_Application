package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Notidata {
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
    @SerializedName("noti_list")
    public ArrayList<Notilistdata> noti_list;

    public ArrayList<Notilistdata> getNoti_list() {
        return noti_list;
    }

    public void setNoti_list(ArrayList<Notilistdata> noti_list) {
        this.noti_list = noti_list;
    }
}
