package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

public class Notilistdata {
    @SerializedName("sm_n_id")
    public String sm_n_id;
    @SerializedName("sm_n_title")
    public String sm_n_title;
    @SerializedName("sm_n_detail")
    public String sm_n_detail;
    @SerializedName("sm_n_pic")
    public String sm_n_pic;
    @SerializedName("sm_n_date")
    public String sm_n_date;

    public String getSm_n_id() {
        return sm_n_id;
    }

    public void setSm_n_id(String sm_n_id) {
        this.sm_n_id = sm_n_id;
    }

    public String getSm_n_title() {
        return sm_n_title;
    }

    public void setSm_n_title(String sm_n_title) {
        this.sm_n_title = sm_n_title;
    }

    public String getSm_n_detail() {
        return sm_n_detail;
    }

    public void setSm_n_detail(String sm_n_detail) {
        this.sm_n_detail = sm_n_detail;
    }

    public String getSm_n_pic() {
        return sm_n_pic;
    }

    public void setSm_n_pic(String sm_n_pic) {
        this.sm_n_pic = sm_n_pic;
    }

    public String getSm_n_date() {
        return sm_n_date;
    }

    public void setSm_n_date(String sm_n_date) {
        this.sm_n_date = sm_n_date;
    }
}
