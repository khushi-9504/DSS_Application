package com.app.dss.data;

import com.google.gson.annotations.SerializedName;

public class Incomelistdata {
    @SerializedName("e_i_id")
    public String e_i_id;
    @SerializedName("e_i_title")
    public String e_i_title;
    @SerializedName("e_i_desc")
    public String e_i_desc;
    @SerializedName("e_i_amount")
    public String e_i_amount;
    @SerializedName("e_i_c_date")
    public String e_i_c_date;

    public String getE_i_id() {
        return e_i_id;
    }

    public void setE_i_id(String e_i_id) {
        this.e_i_id = e_i_id;
    }

    public String getE_i_title() {
        return e_i_title;
    }

    public void setE_i_title(String e_i_title) {
        this.e_i_title = e_i_title;
    }

    public String getE_i_desc() {
        return e_i_desc;
    }

    public void setE_i_desc(String e_i_desc) {
        this.e_i_desc = e_i_desc;
    }

    public String getE_i_amount() {
        return e_i_amount;
    }

    public void setE_i_amount(String e_i_amount) {
        this.e_i_amount = e_i_amount;
    }

    public String getE_i_c_date() {
        return e_i_c_date;
    }

    public void setE_i_c_date(String e_i_c_date) {
        this.e_i_c_date = e_i_c_date;
    }
}
