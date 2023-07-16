package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

public class Complaintlistdata {
    @SerializedName("sm_c_id")
    public String sm_c_id;
    @SerializedName("sm_u_id")
    public String sm_u_id;
    @SerializedName("sm_u_title")
    public String sm_u_title;
    @SerializedName("sm_u_desc")
    public String sm_u_desc;
    @SerializedName("sm_u_c_type")
    public String sm_u_c_type;
    @SerializedName("sm_u_status")
    public String sm_u_status;
    @SerializedName("sm_u_r_date")
    public String sm_u_r_date;
    @SerializedName("sm_u_c_date")
    public String sm_u_c_date;

    public String getSm_c_id() {
        return sm_c_id;
    }

    public void setSm_c_id(String sm_c_id) {
        this.sm_c_id = sm_c_id;
    }

    public String getSm_u_id() {
        return sm_u_id;
    }

    public void setSm_u_id(String sm_u_id) {
        this.sm_u_id = sm_u_id;
    }

    public String getSm_u_title() {
        return sm_u_title;
    }

    public void setSm_u_title(String sm_u_title) {
        this.sm_u_title = sm_u_title;
    }

    public String getSm_u_desc() {
        return sm_u_desc;
    }

    public void setSm_u_desc(String sm_u_desc) {
        this.sm_u_desc = sm_u_desc;
    }

    public String getSm_u_c_type() {
        return sm_u_c_type;
    }

    public void setSm_u_c_type(String sm_u_c_type) {
        this.sm_u_c_type = sm_u_c_type;
    }

    public String getSm_u_status() {
        return sm_u_status;
    }

    public void setSm_u_status(String sm_u_status) {
        this.sm_u_status = sm_u_status;
    }

    public String getSm_u_r_date() {
        return sm_u_r_date;
    }

    public void setSm_u_r_date(String sm_u_r_date) {
        this.sm_u_r_date = sm_u_r_date;
    }

    public String getSm_u_c_date() {
        return sm_u_c_date;
    }

    public void setSm_u_c_date(String sm_u_c_date) {
        this.sm_u_c_date = sm_u_c_date;
    }
}
