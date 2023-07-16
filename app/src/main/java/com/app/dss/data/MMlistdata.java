package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

public class MMlistdata {
    @SerializedName("sm_m_id")
    public String sm_m_id;
    @SerializedName("sm_m_y")
    public String sm_m_y;
    @SerializedName("sm_m_amount")
    public String sm_m_amount;
    @SerializedName("sm_m_month")
    public String sm_m_month;
    @SerializedName("sm_m_year")
    public String sm_m_year;
    @SerializedName("sm_m_status")
    public String sm_m_status;

    public String getSm_m_id() {
        return sm_m_id;
    }

    public void setSm_m_id(String sm_m_id) {
        this.sm_m_id = sm_m_id;
    }

    public String getSm_m_y() {
        return sm_m_y;
    }

    public void setSm_m_y(String sm_m_y) {
        this.sm_m_y = sm_m_y;
    }

    public String getSm_m_amount() {
        return sm_m_amount;
    }

    public void setSm_m_amount(String sm_m_amount) {
        this.sm_m_amount = sm_m_amount;
    }

    public String getSm_m_month() {
        return sm_m_month;
    }

    public void setSm_m_month(String sm_m_month) {
        this.sm_m_month = sm_m_month;
    }

    public String getSm_m_year() {
        return sm_m_year;
    }

    public void setSm_m_year(String sm_m_year) {
        this.sm_m_year = sm_m_year;
    }

    public String getSm_m_status() {
        return sm_m_status;
    }

    public void setSm_m_status(String sm_m_status) {
        this.sm_m_status = sm_m_status;
    }
}
