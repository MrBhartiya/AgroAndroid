package com.mrbhartiya.education.model;

import com.google.gson.annotations.SerializedName;

public class UserModelSec {
    @SerializedName("status_code")
    public  int statuscode;
    @SerializedName("status")
    public  boolean status;
    @SerializedName("messsage")
    public  String message;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
