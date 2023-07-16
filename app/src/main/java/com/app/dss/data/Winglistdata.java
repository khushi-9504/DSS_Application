package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

public class Winglistdata {
    @SerializedName("w_id")
    public String w_id;
    @SerializedName("w_name")
    public String w_name;
    @SerializedName("w_status")
    public String w_status;
    @SerializedName("w_c_date")
    public String w_c_date;

    public String getW_id() {
        return w_id;
    }

    public void setW_id(String w_id) {
        this.w_id = w_id;
    }

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public String getW_status() {
        return w_status;
    }

    public void setW_status(String w_status) {
        this.w_status = w_status;
    }

    public String getW_c_date() {
        return w_c_date;
    }

    public void setW_c_date(String w_c_date) {
        this.w_c_date = w_c_date;
    }
}
