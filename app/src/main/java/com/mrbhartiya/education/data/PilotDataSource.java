package com.mrbhartiya.education.data;


import java.util.WeakHashMap;

public interface PilotDataSource extends PilotDataSoruce {
    interface UserCallback {

      //  void onSuccess(UserModel user);

        void onError(String error);

    }





}
