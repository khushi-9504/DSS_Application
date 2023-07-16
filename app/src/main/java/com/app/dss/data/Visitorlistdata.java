package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

public class Visitorlistdata {
    @SerializedName("sm_v_id")
    public String sm_v_id;
    @SerializedName("sm_v_name")
    public String sm_v_name;
    @SerializedName("sm_v_type")
    public String sm_v_type;
    @SerializedName("sm_v_contact")
    public String sm_v_contact;
    @SerializedName("sm_v_guardname")
    public String sm_v_guardname;
    @SerializedName("u_id")
    public String u_id;
    @SerializedName("sm_v_member")
    public String sm_v_member;
    @SerializedName("sm_v_time")
    public String sm_v_time;
    @SerializedName("sm_v_status")
    public String sm_v_status;
    @SerializedName("sm_v_c_date")
    public String sm_v_c_date;

    public String getSm_v_id() {
        return sm_v_id;
    }

    public void setSm_v_id(String sm_v_id) {
        this.sm_v_id = sm_v_id;
    }

    public String getSm_v_name() {
        return sm_v_name;
    }

    public void setSm_v_name(String sm_v_name) {
        this.sm_v_name = sm_v_name;
    }

    public String getSm_v_type() {
        return sm_v_type;
    }

    public void setSm_v_type(String sm_v_type) {
        this.sm_v_type = sm_v_type;
    }

    public String getSm_v_contact() {
        return sm_v_contact;
    }

    public void setSm_v_contact(String sm_v_contact) {
        this.sm_v_contact = sm_v_contact;
    }

    public String getSm_v_guardname() {
        return sm_v_guardname;
    }

    public void setSm_v_guardname(String sm_v_guardname) {
        this.sm_v_guardname = sm_v_guardname;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getSm_v_member() {
        return sm_v_member;
    }

    public void setSm_v_member(String sm_v_member) {
        this.sm_v_member = sm_v_member;
    }

    public String getSm_v_time() {
        return sm_v_time;
    }

    public void setSm_v_time(String sm_v_time) {
        this.sm_v_time = sm_v_time;
    }

    public String getSm_v_status() {
        return sm_v_status;
    }

    public void setSm_v_status(String sm_v_status) {
        this.sm_v_status = sm_v_status;
    }

    public String getSm_v_c_date() {
        return sm_v_c_date;
    }

    public void setSm_v_c_date(String sm_v_c_date) {
        this.sm_v_c_date = sm_v_c_date;
    }
}
