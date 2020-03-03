package com.mrbhartiya.education.data;


public interface PilotDataSoruce {

    interface BaseCallback {

        void onSuccess();

        void onError(String error);

    }

    interface BaseObjectCallback {

        <T> void onSuccess(T answer);

        void onError(String error);

    }


}
