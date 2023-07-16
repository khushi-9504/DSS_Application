package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MMdata {
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
    @SerializedName("maintance_mlist")
    public ArrayList<MMlistdata> maintance_mlist;

    public ArrayList<MMlistdata> getMaintance_mlist() {
        return maintance_mlist;
    }

    public void setMaintance_mlist(ArrayList<MMlistdata> maintance_mlist) {
        this.maintance_mlist = maintance_mlist;
    }
}
