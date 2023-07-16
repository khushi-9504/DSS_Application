package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Eventdata {
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
    @SerializedName("event_list")
    public ArrayList<Eventlistdata> event_list;

    public ArrayList<Eventlistdata> getEvent_list() {
        return event_list;
    }

    public void setEvent_list(ArrayList<Eventlistdata> event_list) {
        this.event_list = event_list;
    }
}
