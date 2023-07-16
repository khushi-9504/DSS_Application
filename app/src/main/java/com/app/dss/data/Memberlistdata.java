package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

public class Memberlistdata {
    @SerializedName("u_flat_no")
    public String u_flat_no;
    @SerializedName("u_role")
    public String u_role;
    @SerializedName("u_name")
    public String u_name;
    @SerializedName("u_id")
    public String u_id;
    @SerializedName("u_mobile")
    public String u_mobile;

    public String getU_flat_no() {
        return u_flat_no;
    }

    public void setU_flat_no(String u_flat_no) {
        this.u_flat_no = u_flat_no;
    }

    public String getU_role() {
        return u_role;
    }

    public void setU_role(String u_role) {
        this.u_role = u_role;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_mobile() {
        return u_mobile;
    }

    public void setU_mobile(String u_mobile) {
        this.u_mobile = u_mobile;
    }
}
