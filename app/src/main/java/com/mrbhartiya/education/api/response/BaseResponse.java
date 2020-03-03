package com.mrbhartiya.education.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Radha Soni on 16-01-2019.
 */
public class BaseResponse {
    @SerializedName("status")
    @Expose
    public boolean status;
    @SerializedName("errors")
    @Expose
    public boolean errors;
    @SerializedName("message")
    @Expose
    public String message;


    @SerializedName("responsetext")
    @Expose
    public String responsetext;
    @SerializedName("name")
    @Expose
    public String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isErrors() {
        return errors;
    }

    public void setErrors(boolean errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
