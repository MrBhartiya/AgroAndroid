package com.mrbhartiya.education.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.mrbhartiya.education.model.UserModel;

import java.util.Calendar;
import java.util.List;


public class PreferenceHelper {

    private static final String KEY_UID = "KEY_UID";
    private static final String KEY_USER_ID = "KEY_USER_ID";
    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_EMAIL = "KEY_EMAIL";
    private static final String KEY_PHONE = "KEY_PHONE";
    private static final String KEY_STATUS = "KEY_STATUS";
    private static final String KEY_SIGNEDUP = "KEY_SIGNEDUP";
    private static final String KEY_USER_DATA = "KEY_USER_DATA";
    private static final String KEY_USER_CLASS = "KEY_USER_CLASS";
    private static final String KEY_USER_TOKEN = "KEY_USER_TOKEN";
    private static final String DEVICE_UUID = "DEVICE_UUID";
    private static final String LAST_PLAYED = "LAST_PLAYED";
    public static final String CLIENT_KEY = "client_key";
    public static final String API_SECRET = "secret_key";
    public static final String BUCKET_URL = "bucket_url";
    private static Context mContext = null;
    private static SharedPreferences prefs = null;
    private static final String KEY_FCM_ID = "KEY_FCM_ID";
    private static final String KEY_SIGNUP_SUCCESS = "KEY_SIGNUP_SUCCESS";

    private PreferenceHelper() {
    }

    public static void init(Context applicationContext) {
        if (mContext != null) {
            return;
        }

        mContext = applicationContext;
        prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext);
    }


    private static void updatePref(String key, String value) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(key, value);
        edit.apply();
    }

    private static void updatePref(String key, int value) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    private static void updatePref(String key, boolean value) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    private static void updatePref(String key, long value) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putLong(key, value);
        edit.apply();
    }

    private static void updatePref(String key, float value) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putFloat(key, value);
        edit.apply();
    }

    private static void updatePref(String key, List arrayList) {
        SharedPreferences.Editor edit = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        edit.putString(key, json);
        edit.apply();
    }

    private static void updatePref(String key, UserModel arrayList) {
        SharedPreferences.Editor edit = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        edit.putString(key, json);
        edit.apply();
    }


    public static String getUid() {
        return prefs.getString(KEY_UID, null);
    }

    public static void setUid(String uid) {
        updatePref(KEY_UID, uid);
    }

    public static void clear() {
        prefs.edit().clear().commit();
    }

    public static String getUserId() {
        return prefs.getString(KEY_USER_ID, null);
    }

    public static void setUserId(String id) {
        updatePref(KEY_USER_ID, id);
    }

    public static String getUserStatus() {
        return prefs.getString(KEY_STATUS, null);
    }

    public static void setUserStatus(String id) {
        updatePref(KEY_STATUS, id);
    }

    public static String getName() {
        return prefs.getString(KEY_NAME, "");
    }

    public static void setName(String id) {
        updatePref(KEY_NAME, id);
    }

    public static String getPhone() {
        return prefs.getString(KEY_PHONE, "");
    }

    public static void setPhone(String id) {
        updatePref(KEY_PHONE, id);

    }

    public static String getDeviceUuid() {
        return prefs.getString(DEVICE_UUID, "");
    }

    public static void setDeviceUuid(String id) {
        updatePref(DEVICE_UUID, id);

    }

    public static String getUserToken() {
        return prefs.getString(KEY_USER_TOKEN, "");
    }

    public static void setUserToken(String id) {
        updatePref(KEY_USER_TOKEN, id);

    }
    public static String getClientKey() {
        return prefs.getString(CLIENT_KEY, "");
    }

    public static void setClientKey(String id) {
        updatePref(CLIENT_KEY, id);

    }
    public static String getApiSecret() {
        return prefs.getString(API_SECRET, "");
    }
    public static void setBucketUrl(String id) {
        updatePref(BUCKET_URL, id);

    }
    public static String getBucketUrl() {
        return prefs.getString(BUCKET_URL, "");
    }

    public static void setApiSecret(String id) {
        updatePref(API_SECRET, id);

    }

    public static String getKeySignedup() {
        return prefs.getString(KEY_SIGNEDUP, "");
    }

    public static void setKeySignedup(String id) {
        updatePref(KEY_SIGNEDUP, id);
    }

    public static String getEmail() {
        return prefs.getString(KEY_EMAIL, "");
    }

    public static void setEmail(String id) {
        updatePref(KEY_EMAIL, id);
    }

    public static String getUserClass() {
        return prefs.getString(KEY_USER_CLASS, "");
    }

    public static void setUserClass(String id) {
        updatePref(KEY_USER_CLASS, id);
    }

    public static String getKeyUserData() {
        return prefs.getString(KEY_USER_DATA, "");
    }

    public static void setKeyUserData(UserModel arrayList) {
        updatePref(KEY_USER_DATA, arrayList);
    }

    public static String getLastPlayed() {
        return prefs.getString(LAST_PLAYED, "");
    }

    public static void setLastPlayedVideo(String url) {
        updatePref(LAST_PLAYED, url);
    }

    public static long getTimestampStartOfDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }


    public static String getKeyFcmId() {
        return prefs.getString(KEY_FCM_ID, "");
    }

    public static void setKeyFcmId(String id) {
        updatePref(KEY_FCM_ID, id);
    }


}
