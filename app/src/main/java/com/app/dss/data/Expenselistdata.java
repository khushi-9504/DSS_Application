package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

public class Expenselistdata {
    @SerializedName("e_t_name")
    public String e_t_name;
    @SerializedName("e_t_detail")
    public String e_t_detail;
    @SerializedName("sm_e_d_id")
    public String sm_e_d_id;
    @SerializedName("e_name")
    public String e_name;
    @SerializedName("sm_e_amount")
    public String sm_e_amount;
    @SerializedName("sm_e_desc")
    public String sm_e_desc;
    @SerializedName("sm_e_c_date")
    public String sm_e_c_date;

    public String getE_t_name() {
        return e_t_name;
    }

    public void setE_t_name(String e_t_name) {
        this.e_t_name = e_t_name;
    }

    public String getE_t_detail() {
        return e_t_detail;
    }

    public void setE_t_detail(String e_t_detail) {
        this.e_t_detail = e_t_detail;
    }

    public String getSm_e_d_id() {
        return sm_e_d_id;
    }

    public void setSm_e_d_id(String sm_e_d_id) {
        this.sm_e_d_id = sm_e_d_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getSm_e_amount() {
        return sm_e_amount;
    }

    public void setSm_e_amount(String sm_e_amount) {
        this.sm_e_amount = sm_e_amount;
    }

    public String getSm_e_desc() {
        return sm_e_desc;
    }

    public void setSm_e_desc(String sm_e_desc) {
        this.sm_e_desc = sm_e_desc;
    }

    public String getSm_e_c_date() {
        return sm_e_c_date;
    }

    public void setSm_e_c_date(String sm_e_c_date) {
        this.sm_e_c_date = sm_e_c_date;
    }
}
