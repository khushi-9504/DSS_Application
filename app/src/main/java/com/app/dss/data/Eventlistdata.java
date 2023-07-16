package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

public class Eventlistdata {
    @SerializedName("sm_e_id")
    public String sm_e_id;
    @SerializedName("sm_e_title")
    public String sm_e_title;
    @SerializedName("sm_e_desc")
    public String sm_e_desc;
    @SerializedName("sm_e_start_date")
    public String sm_e_start_date;
    @SerializedName("sm_e_end_date")
    public String sm_e_end_date;
    @SerializedName("sm_e_status")
    public String sm_e_status;
    @SerializedName("sm_e_c_date")
    public String sm_e_c_date;

    public String getSm_e_id() {
        return sm_e_id;
    }

    public void setSm_e_id(String sm_e_id) {
        this.sm_e_id = sm_e_id;
    }

    public String getSm_e_title() {
        return sm_e_title;
    }

    public void setSm_e_title(String sm_e_title) {
        this.sm_e_title = sm_e_title;
    }

    public String getSm_e_desc() {
        return sm_e_desc;
    }

    public void setSm_e_desc(String sm_e_desc) {
        this.sm_e_desc = sm_e_desc;
    }

    public String getSm_e_start_date() {
        return sm_e_start_date;
    }

    public void setSm_e_start_date(String sm_e_start_date) {
        this.sm_e_start_date = sm_e_start_date;
    }

    public String getSm_e_end_date() {
        return sm_e_end_date;
    }

    public void setSm_e_end_date(String sm_e_end_date) {
        this.sm_e_end_date = sm_e_end_date;
    }

    public String getSm_e_status() {
        return sm_e_status;
    }

    public void setSm_e_status(String sm_e_status) {
        this.sm_e_status = sm_e_status;
    }

    public String getSm_e_c_date() {
        return sm_e_c_date;
    }

    public void setSm_e_c_date(String sm_e_c_date) {
        this.sm_e_c_date = sm_e_c_date;
    }
}
