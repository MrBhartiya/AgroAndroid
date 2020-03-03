package com.mrbhartiya.education.api.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Radha on 16-01-2019.
 */
public class JsonObjectResponse<T> extends BaseResponse {

    @SerializedName("data")
    public T object;

    @SerializedName("data")
    public String data;
}
