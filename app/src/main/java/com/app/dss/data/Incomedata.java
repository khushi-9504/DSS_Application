package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Incomedata {
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
    @SerializedName("income_list")
    public ArrayList<Incomelistdata> income_list;

    public ArrayList<Incomelistdata> getIncome_list() {
        return income_list;
    }

    public void setIncome_list(ArrayList<Incomelistdata> income_list) {
        this.income_list = income_list;
    }
}
