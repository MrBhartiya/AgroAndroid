package com.mrbhartiya.education.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;

import java.io.Reader;

public class PilotApiRepository implements PilotDataSource {

    private ApiService mService;
    private Context mContext;

    private static PilotApiRepository INSTANCE = null;

    public PilotApiRepository(Context context) {
        super();
        mContext = context;
    }

    public static PilotApiRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PilotApiRepository();
        }

        return INSTANCE;
    }

    public PilotApiRepository() {

        mService = RetrofitClient.createRetrofitService(ApiService.class);
    }

    public Context getContext() {
        return mContext;
    }

    public ApiService getService() {
        return mService;
    }



    protected String handleError(Reader reader) {
        Gson gson = new Gson();
        try {
            ErrorBody errorBody = gson.fromJson(reader, ErrorBody.class);
            Log.e("error body", String.valueOf(errorBody.errors.size()));
            if (errorBody.errors.size() > 0) {
                Log.e("error body", errorBody.errors.get(2));
                return errorBody.errors.get(0);
            }
        } catch (Exception ex) {

            return "Something goes wrong.";
        }

        return "Something goes wrong.";
    }
}
