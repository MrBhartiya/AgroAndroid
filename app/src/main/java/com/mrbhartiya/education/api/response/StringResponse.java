package com.mrbhartiya.education.api.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 16-01-2019.
 */
public class StringResponse extends BaseResponse {

    @SerializedName("data")
    public String object;
}
