package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Complaintdata {
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
    @SerializedName("complaint_list")
    public ArrayList<Complaintlistdata> complaint_list;


    public ArrayList<Complaintlistdata> getComplaint_list() {
        return complaint_list;
    }

    public void setComplaint_list(ArrayList<Complaintlistdata> complaint_list) {
        this.complaint_list = complaint_list;
    }
}
