package com.mrbhartiya.education.model;

public class SignupModel {


    /**
     * status_code : 200
     * status : true
     * message : Otp validate for 10 minutes
     * data :
     */

    private int status_code;
    private boolean status;
    private String message;
    private String data;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
