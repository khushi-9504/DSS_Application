package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

public class Commondata {

    @SerializedName("msg")
    public String msg;
    @SerializedName("status")
    public String status;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
