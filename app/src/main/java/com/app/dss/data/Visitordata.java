package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Visitordata {
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
    @SerializedName("visitor_list")
    public ArrayList<Visitorlistdata> visitor_list;

    public ArrayList<Visitorlistdata> getVisitor_list() {
        return visitor_list;
    }

    public void setVisitor_list(ArrayList<Visitorlistdata> visitor_list) {
        this.visitor_list = visitor_list;
    }
}
