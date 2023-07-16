package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Expensedata {
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
    @SerializedName("expense_list")
    public ArrayList<Expenselistdata> expense_list;

    public ArrayList<Expenselistdata> getExpense_list() {
        return expense_list;
    }

    public void setExpense_list(ArrayList<Expenselistdata> expense_list) {
        this.expense_list = expense_list;
    }
}
