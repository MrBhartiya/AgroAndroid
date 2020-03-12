package com.mrbhartiya.education.utility;

import android.os.Environment;

import java.io.File;

public class Constant {

    //public static final String BASE_URL = "http://ec2-13-232-236-23.ap-south-1.compute.amazonaws.com/api/";
  //  public static final String BASE_URL = "http://ec2-13-232-236-23.ap-south-1.compute.amazonaws.com/api/";
    public static final String BASE_URL = "http://api.mrbhartiya.com/api/";
    public static final int MIN_BUFFER_DURATION = 10;
    public static final String STORAGE_LOCATION = Environment.getExternalStorageDirectory() + File.separator + ".mbr/";
    public static final String CLIENT_KEY = PreferenceHelper.getClientKey();
    public static final String SECRET_KEY = PreferenceHelper.getApiSecret();
    // public static final String BASE_URL = "http://192.168.43.58:8080/api/v1/";
    //public static final String BASE_URL = "http://192.168.0.80:8080/api/v1/";


}
