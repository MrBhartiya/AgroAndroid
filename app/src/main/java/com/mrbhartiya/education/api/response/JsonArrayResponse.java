package com.mrbhartiya.education.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 16-01-2019.
 */
public class JsonArrayResponse<T> extends BaseResponse {

    @SerializedName("response")
    public List<T> list;
}
