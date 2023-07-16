package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UMdata {
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


    @SerializedName("m_u_id")
    public String m_u_id;
    @SerializedName("sm_m_id")
    public String sm_m_id;
    @SerializedName("u_id")
    public String u_id;
    @SerializedName("m_u_date")
    public String m_u_date;
    @SerializedName("m_u_status")
    public String m_u_status;
    @SerializedName("m_u_pay_mode")
    public String m_u_pay_mode;

    public String getM_u_id() {
        return m_u_id;
    }

    public void setM_u_id(String m_u_id) {
        this.m_u_id = m_u_id;
    }

    public String getSm_m_id() {
        return sm_m_id;
    }

    public void setSm_m_id(String sm_m_id) {
        this.sm_m_id = sm_m_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getM_u_date() {
        return m_u_date;
    }

    public void setM_u_date(String m_u_date) {
        this.m_u_date = m_u_date;
    }

    public String getM_u_status() {
        return m_u_status;
    }

    public void setM_u_status(String m_u_status) {
        this.m_u_status = m_u_status;
    }

    public String getM_u_pay_mode() {
        return m_u_pay_mode;
    }

    public void setM_u_pay_mode(String m_u_pay_mode) {
        this.m_u_pay_mode = m_u_pay_mode;
    }
}
